package com.lekhraj.ms.underlyingFund.feign;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.lekhraj.ms.underlyingFund.model.Target;

//1st connecting to localhost:8100 instance
//@FeignClient(name="target-service" , url="localhost:8100")

//2nd - connecting tom multiple instance of same ms
@FeignClient(name="target-service")
@RibbonClient(name="target-service")
public interface TargetServiceProxy {
	
	@GetMapping("ufund/{ufund}")
	public Target getTargetPercentageDummy(@PathVariable String ufund);

}
