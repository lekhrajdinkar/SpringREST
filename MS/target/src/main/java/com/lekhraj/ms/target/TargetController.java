package com.lekhraj.ms.target;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TargetController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass()); //sleuth id
	
	@Autowired
	Environment env;
	
	@GetMapping("ufund/{ufund}")
	public Target getTargetPercentageDummy(@PathVariable String ufund) {
		logger.info("target-service --> {}", ufund);
		return new Target(1001, Integer.parseInt(env.getProperty("default.percentage")), ufund, Integer.parseInt(env.getProperty("local.server.port")))	;
	}

}
