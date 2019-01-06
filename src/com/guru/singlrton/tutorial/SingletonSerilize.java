package com.guru.singlrton.tutorial;

import java.io.Serializable;

public class SingletonSerilize implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static SingletonSerilize soleinstance=new SingletonSerilize();
	private SingletonSerilize() {
		}
	
	public static SingletonSerilize getInstance() {
		return soleinstance;
	}
	

}
