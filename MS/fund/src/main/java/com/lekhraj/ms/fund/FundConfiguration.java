package com.lekhraj.ms.fund;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//convinient way to read from  appl.properties

@Component
@ConfigurationProperties("fund-ms")
public class FundConfiguration {
	
	private String name;
	private String objective;
	private int type;
	private boolean active;
	private String env;
	
	//getter
	public String getEnv() {
		return env;
	}
	public String getName() {
		return name;
	}
	public String getObjective() {
		return objective;
	}
	public int getType() {
		return type;
	}
	public boolean isActive() {
		return active;
	}
	//setter
	public void setEnv(String env) {
		this.env = env;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setObjective(String objective) {
		this.objective = objective;
	}
	public void setType(int type) {
		this.type = type;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
	

}
