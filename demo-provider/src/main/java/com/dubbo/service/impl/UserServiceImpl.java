package com.dubbo.service.impl;

import com.dubbo.demo.consumer.Consumer;
import com.dubbo.demo.entity.User;
import com.dubbo.demo.service.UserService;

public class UserServiceImpl implements UserService{

	public User getUser() {
		// TODO Auto-generated method stub
		System.out.println("UserServiceImpl.getUser() invoked ...");
		User user = new User();
		user.setId(1);
		user.setUsername("wangkai");
		user.setPassword("123456");
		Consumer cons = Consumer.getInstance();
		user.setComp(cons.getCompany());
		return user;
	}

	public String sayHello(String name) {
		// TODO Auto-generated method stub
		return "hello "+name;
	}
}
