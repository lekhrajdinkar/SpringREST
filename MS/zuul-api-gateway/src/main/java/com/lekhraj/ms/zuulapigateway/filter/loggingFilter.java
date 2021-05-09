package com.lekhraj.ms.zuulapigateway.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class loggingFilter  extends ZuulFilter{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean shouldFilter() {
		// no business logic, run for all
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// logging logic
		
		//1. get currentHttpRequest
		HttpServletRequest req = RequestContext.getCurrentContext().getRequest();
		logger.info("reg --> {} , req.uri --> {}", req, req.getRequestURI() );
		return null;
	}

	@Override
	public String filterType() {
		// pre, post, error
		return "pre";
	}

	@Override
	public int filterOrder() {
		// decide order among multip[le request
		return 0;
	}

}
