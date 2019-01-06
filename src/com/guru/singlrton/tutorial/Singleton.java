package com.guru.singlrton.tutorial;

public class Singleton {

	static Singleton soleinstance=new Singleton();
	private Singleton() {
		}
	
	public static Singleton getInstance() {
		return soleinstance;
	}
	
}
