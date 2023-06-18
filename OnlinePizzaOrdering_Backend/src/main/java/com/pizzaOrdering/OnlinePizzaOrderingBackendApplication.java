package com.pizzaOrdering;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pizzaOrdering.config.LoggerConfig;

@SpringBootApplication
public class OnlinePizzaOrderingBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlinePizzaOrderingBackendApplication.class, args);
		
	    // Log messages using custom logger
        LoggerConfig.logInfo("This is an informational message");
        
        LoggerConfig.logError("This is an error message");
        
        LoggerConfig.logWarn("This is warning message");
        
        LoggerConfig.logDebug("This is debug message");
        
	}

}
