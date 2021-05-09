package com.lekhraj.sb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.lekhraj.sb.*")
public class SbConceptApplication {
	
	

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SbConceptApplication.class, args);
		System.out.println(context);
		
		
		
	}

}
