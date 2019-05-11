package com.lekhraj.ms.underlyingFund;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UFundController {

	@GetMapping
	public UFund getHardcodedUFund() {
		
		return new UFund("NPF", "TDF10", true, "dev-1", 8000);
		
	}
}
