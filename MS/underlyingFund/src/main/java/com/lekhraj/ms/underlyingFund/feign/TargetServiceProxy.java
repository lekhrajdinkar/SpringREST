package com.lekhraj.ms.underlyingFund.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.lekhraj.ms.underlyingFund.model.Target;


@FeignClient(name="target-service" , url="localhost:8100")
public interface TargetServiceProxy {
	
	@GetMapping("ufund/{ufund}")
	public Target getTargetPercentageDummy(@PathVariable String ufund);

}
