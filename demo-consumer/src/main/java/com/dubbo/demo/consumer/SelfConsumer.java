package com.dubbo.demo.consumer;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

import com.dubbo.demo.service.UserService;

public class SelfConsumer {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserService user = (UserService) remote(UserService.class);
		String result = user.sayHello("wangkai");
		System.out.println("客户端收到结果："+result);
	}

	private static Object remote(final Class clazz) {
		// TODO Auto-generated method stub
		//动态代理Proxy创建对象，字节码
		return Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new InvocationHandler(){

			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				// TODO Auto-generated method stub
				Socket socket = new Socket("127.0.0.1",6666);
				
				//反射 哪个class 哪个方法  入参类型  入参参数值
				
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				oos.writeUTF(clazz.getName());
				oos.writeUTF(method.getName());
				oos.writeObject(method.getParameterTypes());
				oos.writeObject(args);
				oos.flush();
				
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());	
				Object obj = ois.readObject();
				
				ois.close();
				oos.close();
				socket.close();
				return obj;
			}
			
		});
	}
	
	
}
