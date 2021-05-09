package com.lekhraj.ms.underlyingFund;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.lekhraj.ms.underlyingFund.feign.TargetServiceProxy;
import com.lekhraj.ms.underlyingFund.feign.TargetServiceZuulProxy;
import com.lekhraj.ms.underlyingFund.model.Target;

@RestController
public class UFundController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	Environment env;
	
	@Autowired
	UFundJPARepository repo;
	
	@Autowired
	TargetServiceProxy targetServiceProxy; //feign
	
	@Autowired
	TargetServiceZuulProxy targetServiceZuulProxy; //feign via zuul

	@GetMapping("hardcoded-uf")
	public UFund getHardcodedUFund() {
		
		return new UFund("NPF", env.getProperty("uf.ms.default.fund.name"), true, "dev-1", 
				Integer.parseInt(env.getProperty("local.server.port"))); //notice local word
		
	}
	
	@GetMapping("name/{name}")
	public UFund getUFundByName(@PathVariable String name) {
		
		logger.info("uf-Fund-service --> {}", name);//sleuth id
		
		UFund ufund =  repo.findByName(name);
		
		//Invoke TargetService - way1 - using RestTemplate
		String endpoint = env.getProperty("target.service.endpoint");
		String url = endpoint+"/ufund/"+name;
		ResponseEntity<Target> re = new RestTemplate().getForEntity(url, Target.class);
		Target response = re.getBody();

		//Invoke TargetService - way2.1 - using Feign without gateway... direct
		response = targetServiceProxy.getTargetPercentageDummy(name);
		
		//Invoke TargetService - way2.2 - using Feign via zuul gateway
		response = targetServiceZuulProxy.getTargetPercentageDummy(name);
		
		ufund.setTargetPercent(response.getTargetPercentage());
		ufund.setTargetMSPort(response.getPort());
		return ufund;
	}
}
