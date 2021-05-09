package com.lekhraj.springREST.REST1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.lekhraj.springREST" })
@SpringBootApplication
public class Rest1Application {

	public static void main(String[] args) {
		System.out.println("Inside Main");
		ApplicationContext applicationContext =SpringApplication.run(Rest1Application.class, args);
		
		for (String name: applicationContext.getBeanDefinitionNames()) {
            // Print All Beans
			//System.out.println(name);
        }
	}

}

