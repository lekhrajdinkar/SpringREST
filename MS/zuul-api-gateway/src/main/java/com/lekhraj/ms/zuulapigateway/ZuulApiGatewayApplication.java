package com.lekhraj.ms.zuulapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

//Step 30: Enable Zuul
@EnableZuulProxy

//Register with Eureka
@SpringBootApplication
@EnableDiscoveryClient
public class ZuulApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApiGatewayApplication.class, args);
	}
	
	//Step-35 Adding sleuth for getting unique id in logs.
	// will same id in all 3 consoles.
	// will add zipkins to have consildated logs with sam euinque id
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
