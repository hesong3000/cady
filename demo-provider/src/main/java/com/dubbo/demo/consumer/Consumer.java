package com.dubbo.demo.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dubbo.demo.entity.Company;
import com.dubbo.demo.service.CompanyService;
import com.dubbo.demo.utils.ApplicationContext;

public class Consumer implements ConsumerInterface{
	
	private static Consumer instance;
	private Consumer(){
	}
	
	public static Consumer getInstance(){
		if(instance == null){
			instance = new Consumer();
			return instance;
		}
		else
			return instance;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	public Company getCompany() {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:dubbo-consumer.xml");
		CompanyService comps = (CompanyService) context.getBean("companyService");
		return comps.getCompany();
	}

}
