package com.guru.singlrton.tutorial;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestMainThread {
	
	static void useSingletonThread() {
		SingletonFinal st1=SingletonFinal.getInstance();
		System.out.println(st1 +"  thread  > "+st1.hashCode());
	}
	
	public static void main(String[] args) {
		ExecutorService service=Executors.newFixedThreadPool(2);
		service.submit(TestMainThread :: useSingletonThread);
		service.submit(TestMainThread :: useSingletonThread);
		service.shutdown();
		
	}

}
