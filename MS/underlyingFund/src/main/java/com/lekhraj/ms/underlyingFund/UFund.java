package com.lekhraj.ms.underlyingFund;

public class UFund {
	private String name;
	private String parentFund;
	private boolean active;
	private String env;
	private int port;
	
	
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
	
	
	
	

}
