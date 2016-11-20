package com.discover.neural.engine.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;

import com.discover.neural.engine.NeuralEngine;
import com.discover.neural.engine.component.Config;

public class Log4jUtils {

	public static void updateLog4jConfiguration(Config config) { 
        Properties props = new Properties(); 
        try { 
            InputStream configStream = NeuralEngine.class.getResourceAsStream( "/log4j.properties"); 
            props.load(configStream); 
            configStream.close(); 
        } catch (IOException e) { 
            System.out.println("Error unable to load log4j configuration file "); 
        } 
        
        String logFile = props.getProperty("log4j.appender.file.File");
        props.setProperty("log4j.appender.file.File", config.getNeuralHome() + "\\" + logFile); 
        LogManager.resetConfiguration(); 
        PropertyConfigurator.configure(props); 
     }
}
