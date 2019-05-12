package com.lekhraj.ms.target;

//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;

//@Entity
//@Table(name="target")
public class Target {
	int id;
	float targetPercentage;
	String fundName;
	int port;
	
	public Target() {	}
	
	public Target(int id, float targetPercentage, String fundName, int port) {
		super();
		this.id = id;
		this.targetPercentage = targetPercentage;
		this.fundName = fundName;
		this.port = port;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getTargetPercentage() {
		return targetPercentage;
	}
	public void setTargetPercentage(float targetPercentage) {
		this.targetPercentage = targetPercentage;
	}
	public String getFundName() {
		return fundName;
	}
	public void setFundName(String fundName) {
		this.fundName = fundName;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	
	

}
