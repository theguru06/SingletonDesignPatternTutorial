package com.guru.singlrton.tutorial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestMainFinal {
	
	static void useSingletonThread() {
		SingletonFinal st4=SingletonFinal.getInstance();
		System.out.println(st4 +"  thread  > "+st4.hashCode());
	}

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, FileNotFoundException, IOException {
		
		SingletonFinal st1=SingletonFinal.getInstance();
		System.out.println(st1 +"   > "+st1.hashCode());
		
		//Reflection
		/*Class clazz=Class.forName("com.guru.singlrton.tutorial.SingletonFinal");
		Constructor<SingletonFinal> cons=clazz.getDeclaredConstructor();
		cons.setAccessible(true);
		SingletonFinal st2=cons.newInstance();
		System.out.println(st2 +"   > "+st2.hashCode());*/
		
		/*//Clone
		SingletonFinal st3=(SingletonFinal)st1.clone();
		System.out.println(st3 +"   > "+st3.hashCode());*/
		
		/*//Thread
		ExecutorService service=Executors.newFixedThreadPool(2);
		service.submit(TestMainThread :: useSingletonThread);
		service.submit(TestMainThread :: useSingletonThread);
		service.shutdown();*/
		
		//Serialization -Deserialization
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("test.ser"));
		oos.writeObject(st1);
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream("test.ser"));
		SingletonFinal st7=(SingletonFinal)ois.readObject();
		System.out.println(st7 +" Ser-Deser > "+st7.hashCode());
		oos.close();
		ois.close();
		
	}
}
