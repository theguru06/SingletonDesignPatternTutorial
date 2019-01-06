package com.guru.singlrton.tutorial;

public class SingletonThread {
	


	static SingletonThread soleinstance=null;
	private SingletonThread() {
		}
	
	//lazy initialization of instance
	public static SingletonThread getInstance() {
		if(soleinstance ==null) {
			return new SingletonThread();
		}
		return soleinstance;
	}
	


}
