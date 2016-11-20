package com.discover.neural.engine;

import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.D;
import static org.matheclipse.core.expression.F.Sin;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.x;

import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.matheclipse.core.eval.ExprEvaluator;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.parser.client.SyntaxError;
import org.matheclipse.parser.client.math.MathException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.discover.neural.engine.component.Config;
import com.discover.neural.engine.jaxb.network.NetworkType;
import com.discover.neural.engine.utils.Log4jUtils;

/**
 * Hello world!
 *
 */
public class NeuralEngine 
{
	private static final Logger LOG = Logger.getLogger(NeuralEngine.class.getName());
	
    public static void main( String[] args )
    {
    	try(ClassPathXmlApplicationContext context = 
    				new ClassPathXmlApplicationContext("com/discover/neural/engine/config/spring-beans.xml")){
    		
    		
    		Config config = (Config)context.getBean("config");
    		
    		Log4jUtils.updateLog4jConfiguration(config);
    		
    		Map<String, NetworkType> networks = config.getNetworks();
    		Map<String, String> networkSources = config.getNetworkSources();
    		networks.keySet().stream().forEach(key->{
    			LOG.info("Id: " + key);
    			NetworkType nt = networks.get(key);
    			LOG.info(nt.getNeurons().getNeuron().get(0).getType());
    			LOG.info("Source: " + networkSources.get(key));
    		});
    		
    		try{
    			java.lang.Thread.sleep(Long.MAX_VALUE);
    		}catch(InterruptedException e){}
    		
    	}
    }
    
    private static void symjaExample2(){
    	try {
			// don't distinguish between lower- and uppercase identifiers
    		org.matheclipse.core.basic.Config.PARSER_USE_LOWERCASE_SYMBOLS = true;

			ExprEvaluator util = new ExprEvaluator(false, 100);
			
			IExpr result = util.evaluate("y=PI");
			result = util.evaluate("N(cos(x)^2+cos(y)^2)");
			LOG.info(result.toString());

		} catch (SyntaxError e) {
			// catch Symja parser errors here
			LOG.error(e.getMessage());
		} catch (MathException me) {
			// catch Symja math errors here
			LOG.error(me.getMessage());
		} catch (Exception e) {
			LOG.error(ExceptionUtils.getStackTrace(e));
		}
    }
    
    private static void symjaExample(){
    	try {
			// don't distinguish between lower- and uppercase identifiers
    		org.matheclipse.core.basic.Config.PARSER_USE_LOWERCASE_SYMBOLS = true;

			ExprEvaluator util = new ExprEvaluator(false, 100);
			
			// Show an expression in the Java form:
			// Note: single character identifiers are case sensistive
			// (the "D()" function input must be written as upper case character)
			String javaForm = util.toJavaForm("D(sin(x)*cos(x),x)");
			// prints: D(Times(Sin(x),Cos(x)),x)
			LOG.info(javaForm.toString());

			// Use the Java form to create an expression with F.* static methods:
			IAST function = D(Times(Sin(x), Cos(x)), x);
			IExpr result = util.evaluate(function);
			// print: Cos(x)^2-Sin(x)^2
			LOG.info(result.toString());

			// evaluate the string directly
			// Note "diff" is an alias for the "D" function
			result = util.evaluate("diff(sin(x)*cos(x),x)");
			// print: Cos(x)^2-Sin(x)^2
			LOG.info(result.toString());

			// evaluate the last result ("$ans" should contain the last calculated answer, 
			// but it's not working, so using "%" instead, could also use "Out()".
			result = util.evaluate("%+cos(x)^2");
			// print: 2*Cos(x)^2-Sin(x)^2
			LOG.info(result.toString());

			// evaluate an Integrate[] expression
			result = util.evaluate("integrate(sin(x)^5,x)");
			// print: 2/3*Cos(x)^3-1/5*Cos(x)^5-Cos(x)
			LOG.info(result.toString());

			// set the value of a variable "a" to 10
			// Note: in server mode the variable name must have a preceding '$' character
			result = util.evaluate("a=10");
			// print: 10
			LOG.info(result.toString());

			// do a calculation with variable "a"
			result = util.evaluate("a*3+b");
			// print: 30+b
			LOG.info(result.toString());

			// Do a calculation in "numeric mode" with the N() function
			// Note: single character identifiers are case sensistive
			// (the "N()" function input must be written as upper case character)
			result = util.evaluate("N(sinh(5))");
			// print: 74.20321057778875
			LOG.info(result.toString());

			// define a function with a recursive factorial function definition.
			// Note: fac(0) is the stop condition which must be defined first.
			result = util.evaluate("fac(0)=1;fac(x_IntegerQ):=x*fac(x-1)");
			// now calculate factorial of 10:
			result = util.evaluate("fac(10)");
			// print: 3628800
			LOG.info(result.toString());

		} catch (SyntaxError e) {
			// catch Symja parser errors here
			LOG.error(e.getMessage());
		} catch (MathException me) {
			// catch Symja math errors here
			LOG.error(me.getMessage());
		} catch (Exception e) {
			LOG.error(ExceptionUtils.getStackTrace(e));
		}
    }
    
}