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

//3. via Zuul gateway
@FeignClient(name="zuul-api-gateway")
@RibbonClient(name="target-service")
public interface TargetServiceZuulProxy {
	
	//Added service anme in url
	//@GetMapping("ufund/{ufund}") - older
	@GetMapping("target-service/ufund/{ufund}")
	public Target getTargetPercentageDummy(@PathVariable String ufund);

}

/*

http://localhost:8765/uf-fund-service/name/NPF
http://localhost:8000/name/NPF	

Both are same... with  and without Zuul.

**************************
APPLICATION FAILED TO START
***************************

Description:

Field targetServiceZuulProxy in com.lekhraj.ms.underlyingFund.UFundController 
required a bean of type 'com.lekhraj.ms.underlyingFund.feign.TargetServiceZuulProxy' that could not be found.

The injection point has the following annotations:
	- @org.springframework.beans.factory.annotation.Autowired(required=true)


Action:

Consider defining a bean of type 'com.lekhraj.ms.underlyingFund.feign.TargetServiceZuulProxy' in your configuration.

*/

