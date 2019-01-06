package com.guru.singlrton.tutorial;

public class SingletonClone implements Cloneable{

	static SingletonClone soleinstance=new SingletonClone();
	private SingletonClone() {
		}
	
	public static SingletonClone getInstance() {
		return soleinstance;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
