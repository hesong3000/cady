package com.dubbo.demo.provider;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

import com.dubbo.demo.service.UserService;
import com.dubbo.service.impl.UserServiceImpl;

public class SelfProvider {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket serverSocket = new ServerSocket(6666);
			while(true)
			{
				Socket socket = serverSocket.accept();
				
				//反射 哪个class 哪个方法  入参类型  入参参数值
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				String className = ois.readUTF();
				String methodNmae = ois.readUTF();
				Class[] parameterTypes = (Class[]) ois.readObject();
				Object[] objs = (Object[]) ois.readObject();
				
				Class clazz = getService(className);
				
				Object result = null;
				try {
					Method method = clazz.getMethod(methodNmae, parameterTypes);
					result = method.invoke(clazz.newInstance(), objs);
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("result: "+result.toString());
				
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				oos.writeObject(result);
				oos.flush();
				
				oos.close();
				ois.close();
				socket.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Class getService(String className){
		Class clazz = null;
		//服务注册
		if(UserService.class.getName().equals(className))
		{
			clazz = UserServiceImpl.class;
		}
		
		return clazz;
	}
}
