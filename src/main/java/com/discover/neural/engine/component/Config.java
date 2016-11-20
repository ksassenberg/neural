package com.discover.neural.engine.component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.discover.neural.engine.jaxb.network.NetworkType;

@Component
public class Config {
	
	private static final Logger LOG = Logger.getLogger(Config.class.getName());
	
	public static final String NEURAL_HOME_ENV = "NEURAL_HOME";
	
	private Map<String, String> env = System.getenv();
	private String neuralHome;
	private String networksHome;
	private Map<String, NetworkType> networks;
	private Map<String, String> networkSources;
	
	@Value("${project.version}")
	private String version;
	
	public Config(){
		setNeuralHome();
		networksHome = this.neuralHome + File.separator + "networks";
		try{
			loadNetworks();
		}catch(IOException io){
			LOG.error("Unable to read Networks Home directory:\n" + ExceptionUtils.getStackTrace(io));
		}catch(JAXBException jaxb){
			LOG.error("Unable to create unMarshaller:\n" + ExceptionUtils.getStackTrace(jaxb));
		}
	}

	public String getNeuralHome() {
		return neuralHome;
	}
	
	public Map<String, NetworkType> getNetworks() {
		return networks;
	}
	
	public Map<String, String> getNetworkSources() {
		return networkSources;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	private void setNeuralHome(){
		for (String envName : env.keySet()) {
            if (envName.equalsIgnoreCase(NEURAL_HOME_ENV)){
            	neuralHome = env.get(envName);
            }
        }
	}
	
	@SuppressWarnings("unchecked")
	private void loadNetworks() throws IOException, JAXBException{
		
		JAXBContext jaxbContext = JAXBContext.newInstance("com.discover.neural.engine.jaxb.network");
    	Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
    	networks = new ConcurrentHashMap<>();
    	networkSources = new ConcurrentHashMap<>();

		Files.newDirectoryStream(Paths.get(networksHome),
		        path -> path.toString().endsWith(".xml"))
		        .forEach(path ->{
		        	try{
		        		NetworkType network = ((JAXBElement<NetworkType>)jaxbUnmarshaller.unmarshal(new FileInputStream(path.toString()))).getValue();
		        		networks.put(network.getId(), network);
		        		networkSources.put(network.getId(), path.toString());
		        	}catch(FileNotFoundException fnf){
		    			LOG.error("Unable to open file:\n" + ExceptionUtils.getStackTrace(fnf));
		    		}catch(JAXBException jaxb){
		    			LOG.error("Unable to unmarshall file:\n" + ExceptionUtils.getStackTrace(jaxb));
		    		}
		        });
	}
	
}
