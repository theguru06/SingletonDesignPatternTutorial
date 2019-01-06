package com.guru.singlrton.tutorial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestMain {
	
	public static void main(String[] args) throws ClassNotFoundException, 
	                       NoSuchMethodException, SecurityException, InstantiationException, 
	                       IllegalAccessException, IllegalArgumentException, InvocationTargetException, CloneNotSupportedException, FileNotFoundException, IOException {
		Singleton st1= Singleton.getInstance();
		Singleton st2= Singleton.getInstance();
		
		//General
		System.out.println(st1 +"   > "+st1.hashCode());
		System.out.println(st2 +"   > "+st2.hashCode());
		
		//Serialization -Deserialization
		SingletonSerilize st6=SingletonSerilize.getInstance();
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("test.ser"));
		oos.writeObject(st6);
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream("test.ser"));
		SingletonSerilize st7=(SingletonSerilize)ois.readObject();
		System.out.println(st6 +" Ser-Deser  > "+st6.hashCode());
		System.out.println(st7 +" Ser-Deser > "+st7.hashCode());
		oos.close();
		ois.close();
		
		//Reflection
		Class clazz=Class.forName("com.guru.singlrton.tutorial.Singleton");
		Constructor<Singleton> cons=clazz.getDeclaredConstructor();
		cons.setAccessible(true);
	    Singleton st3=cons.newInstance();
	    System.out.println(st3 +"   > "+st3.hashCode());
	    
	    //Clone
	    SingletonClone st4=SingletonClone.getInstance();
	    SingletonClone st5=(SingletonClone) st4.clone();
	    System.out.println(st4 +"   > "+st4.hashCode());
	    System.out.println(st5 +"   > "+st5.hashCode());
	    
	    
	}
}
