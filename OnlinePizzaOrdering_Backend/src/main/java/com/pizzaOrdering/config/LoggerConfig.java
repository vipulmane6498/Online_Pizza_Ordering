package com.pizzaOrdering.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerConfig {
	
	    public static final Logger logger = LoggerFactory.getLogger(LoggerConfig.class);

	    public static void logInfo(String message) {
	        logger.info(message);
	    }

	    public static void logError(String message) {
	        logger.error(message);
	    }	
	    
	    public static void Trace(String message) {
	        logger.trace(message);
	    }

		public static void logWarn(String string) {
		    logger.warn(string);
		}

		public static void logDebug(String string) {
		    logger.debug(string);
			
		}	

}
