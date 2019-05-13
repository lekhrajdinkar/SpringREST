package com.lekhraj.ms.underlyingFund.feign;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.lekhraj.ms.underlyingFund.model.Target;

//1st connecting to localhost:8100 instance
//@FeignClient(name="target-service" , url="localhost:8100")

//2nd - connecting to multiple instance of same ms. Add Ribbon on top of feign with urls of target-service
// 2.1. urls are added/hardcoded in prop files
// 2.2. Register target-service with eureka naming server. Ribbon will automatically talk to it and get the urls.
// NOTE: CHECK SERVICE NAME IN Eureka, put same name below

@FeignClient(name="target-service")
@RibbonClient(name="target-service")
public interface TargetServiceProxy {
	
	@GetMapping("ufund/{ufund}")
	public Target getTargetPercentageDummy(@PathVariable String ufund);

}
