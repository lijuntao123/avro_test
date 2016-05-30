package com.callback.test;

import com.callback.ICumm;

public class TestCallback {

//	public static void main(String[] args) {
//		new TestCallback().test(new CummImpl());
//	}
	private ICumm cummImpl;
	public TestCallback(ICumm cummImpl){
		this.cummImpl=cummImpl;
	}
	
	public void rec(){
		Object o=cummImpl.testA("hello");
		System.out.println("o="+o);
	}
	
	public void run(){
		String msg="";
		if(msg!=null){
			Object o=cummImpl.testA(msg);
		}
	}
	
}
