package com.lekhraj.ms.underlyingFund;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableFeignClients("com.lekhraj.ms.underlyingFund")
public class UnderlyingFundApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnderlyingFundApplication.class, args);
	}
	
	//Step-35 Adding sleuth for getting unique id in logs.
	// will same id in all 3 consoles.
	// will add zipkins to have consildated logs with sam euinque id
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
