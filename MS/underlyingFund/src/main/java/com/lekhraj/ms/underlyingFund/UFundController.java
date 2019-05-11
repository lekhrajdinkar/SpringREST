package com.lekhraj.ms.underlyingFund;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UFundController {
	
	@Autowired
	Environment env;

	@GetMapping("hardcoded-uf")
	public UFund getHardcodedUFund() {
		
		return new UFund("NPF", env.getProperty("uf.ms.default.fund.name"), true, "dev-1", 
				Integer.parseInt(env.getProperty("local.server.port"))); //notice local word
		
	}
}
