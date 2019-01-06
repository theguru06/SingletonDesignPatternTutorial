package com.guru.singlrton.tutorial;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class SingletonFinal implements Cloneable,Serializable{
	
	//volatile keyword makes sure change to variable published only change is complete
	
	private static final long serialVersionUID = 1L;
	//lazy initialization of instance
	private static volatile SingletonFinal soleinstance=null;
	
	private SingletonFinal() {
		if(soleinstance !=null) {
			throw new RuntimeException("can not create instance like this,use method get instance");
		}
		System.out.println("Creating..");

	}
	
	//lazy initialization of instance
	public static SingletonFinal getInstance() {
		//Double check locking.
		if(null == soleinstance) {   //check 1
			synchronized (SingletonFinal.class) {
				if(soleinstance ==null) { //check 2
					soleinstance= new SingletonFinal();
				}
			}

		}
		return soleinstance;
	}
	

    @Override
    protected Object clone() {
    	throw new RuntimeException("Clone is not allowed");
    }

    private Object readResolve() throws ObjectStreamException{
    	System.out.println("....read resolve..");
    	return soleinstance; 
    }

}
