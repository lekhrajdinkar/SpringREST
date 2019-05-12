package com.lekhraj.ms.underlyingFund;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="u_fund")
public class UFund {
	
	@Id private int id;
	private String name;
	private String parentFund;
	private boolean active;
	private String env;
	private int port;
	
	//private float targetPercent;
	
	
	public UFund(String name, String parentFund, boolean active, String env, int port) {
		super();
		this.name = name;
		this.parentFund = parentFund;
		this.active = active;
		this.env = env;
		this.port = port;
	}

	public UFund() {} //default const
	
	//g n s
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentFund() {
		return parentFund;
	}

	public void setParentFund(String parentFund) {
		this.parentFund = parentFund;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getEnv() {
		return env;
	}

	public void setEnv(String env) {
		this.env = env;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public float getTargetPercent() {
//		return targetPercent;
//	}
//
//	public void setTargetPercent(float targetPercent) {
//		this.targetPercent = targetPercent;
//	}
	
	
	
	

}
