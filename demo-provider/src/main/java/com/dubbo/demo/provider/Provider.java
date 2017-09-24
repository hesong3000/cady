package com.dubbo.demo.provider;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.dubbo.demo.utils.ApplicationContext;

public class Provider {
	 private static final Logger logger = LoggerFactory.getLogger(Provider.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("UserService Provider Start");
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:dubbo-provider.xml");
            context.start();
            System.out.println("UserService Provider Start End!!!");
        } catch (Exception e) {
            logger.error("== Provider context start error:",e);
        }
        synchronized (Provider.class) {
            while (true) {
                try {
                    Provider.class.wait();
                } catch (InterruptedException e) {
                    logger.error("== synchronized error:",e);
                }
            }
        }
	}

}
