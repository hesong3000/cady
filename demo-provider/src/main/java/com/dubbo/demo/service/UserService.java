package com.dubbo.demo.service;

import com.dubbo.demo.entity.User;

public interface UserService {
	public User getUser();
	public String sayHello(String name);
}
