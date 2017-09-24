package com.dubbo.demo.utils;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContext {
	private static ApplicationContext appcontext = new ApplicationContext();
	private final ClassPathXmlApplicationContext context;
	private ApplicationContext(){
		context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	}
	
	public static ApplicationContext getInstance(){
		return appcontext;
	}
	
	public ClassPathXmlApplicationContext getAppContext(){
		return context;
	}
}
