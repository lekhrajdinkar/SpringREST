package com.lekhraj.ms.target;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication

// Step 26 - Enable Eureka naming service
@EnableDiscoveryClient
public class TargetApplication {

	public static void main(String[] args) {
		SpringApplication.run(TargetApplication.class, args);
	}
	
	//Step-35 Adding sleuth for getting unique id in logs.
		// will same id in all 3 consoles.
		// will add zipkins to have consildated logs with sam euinque id
		@Bean
		public Sampler defaultSampler() {
			return Sampler.ALWAYS_SAMPLE;
		}


}
