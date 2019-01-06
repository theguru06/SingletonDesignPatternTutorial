package com.guru.singlrton.tutorial;

public class SingletonHolder {

	static SingletonHolder soleinstance=null;
	private SingletonHolder() {
		}
	
	//singleton holder
	static class Holder{
		static final SingletonHolder soleinstance=new SingletonHolder();
	}
	//lazy initialization of instance
	public static SingletonHolder getInstance() {
		return Holder.soleinstance;
		}
	



}
