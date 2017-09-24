package com.dubbo.demo.entity;

import java.io.Serializable;

public class User implements Serializable{

	public String toString() {
		// TODO Auto-generated method stub
		return "userid: "+this.id + " username: "+this.username+" password: "+this.password
				+" company name: "+comp.getName()+" company address: "+comp.getAddress();
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	private static final long serialVersionUID = -836644917847357713L;
	private int id;
	private String username;
	private String password;
	private Company comp;
	public Company getComp() {
		return comp;
	}

	public void setComp(Company comp) {
		this.comp = comp;
	}
}
