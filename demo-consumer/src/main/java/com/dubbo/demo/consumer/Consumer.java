package com.dubbo.demo.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dubbo.demo.entity.User;
import com.dubbo.demo.service.UserService;
import com.dubbo.demo.utils.ApplicationContext;

public class Consumer {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Consumer invoke userService.getuser()!!!");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:dubbo-consumer.xml");
        UserService userService = (UserService)context.getBean("userService");
        User user = userService.getUser();
        System.out.println(user);
        
//        userService = (UserService)applicationContext.getBean("userService");
//        user = userService.getUser();
//        System.out.println(user+" step 2");
//        
//        userService = (UserService)applicationContext.getBean("userService");
//        user = userService.getUser();
//        System.out.println(user+" step 3");
	}

}
