package com.lekhraj.springREST.REST1;

public class FirstBean {

	String beanName;

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public FirstBean(String string) {
		this.beanName = string;
	}

}
