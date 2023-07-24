package com.app.springfirst.configuration.config_bean;

public class Test {
	private String txt;

	public Test() {
		super();
	}

	public Test(String txt) {
		this.txt = txt;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}
	
	public String info() {
		return "INFO: " + txt;
	}
}
