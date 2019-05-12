package com.lekhraj.ms.target;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TargetController {
	
	@Autowired
	Environment env;
	
	@GetMapping("ufund/{ufund}")
	public Target getTargetPercentageDummy(@PathVariable String ufund) {
		return new Target(1001, 80, ufund, Integer.parseInt(env.getProperty("local.server.port")))	;
	}

}
