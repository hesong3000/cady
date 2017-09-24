package com.dubbo.demo.entity;

import java.io.Serializable;

public class Company implements Serializable{
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private static final long serialVersionUID = 5788457138684756976L;
	private String name;
	private String address;
	
}
