package com.lekhraj.ms.underlyingFund;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.lekhraj.ms.underlyingFund.model.Target;

@RestController
public class UFundController {
	
	@Autowired
	Environment env;
	
	@Autowired
	UFundJPARepository repo;

	@GetMapping("hardcoded-uf")
	public UFund getHardcodedUFund() {
		
		return new UFund("NPF", env.getProperty("uf.ms.default.fund.name"), true, "dev-1", 
				Integer.parseInt(env.getProperty("local.server.port"))); //notice local word
		
	}
	
	@GetMapping("name/{name}")
	public UFund getUFundByName(@PathVariable String name) {
		UFund ufund =  repo.findByName(name);
		
		//set target
		String endpoint = env.getProperty("target.service.endpoint");
		String url = endpoint+"/ufund/"+name;
		
		//Invoke TargetService
		ResponseEntity<Target> re = new RestTemplate().getForEntity(url, Target.class);
		Target response = re.getBody();
		ufund.setTargetPercent(response.getTargetPercentage());
		ufund.setTargetMSPort(response.getPort());
		return ufund;
	}
}
