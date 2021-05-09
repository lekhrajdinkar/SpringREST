package com.lekhraj.ms.fund;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FundController {
	
	@Autowired
	private FundConfiguration fundConfig ;
	
	@GetMapping("fund-test")
	public FundConfiguration getTestFund() {
		System.out.println(fundConfig);
		return fundConfig;
	}
	

}
