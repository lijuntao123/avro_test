package com.callback.test;

import com.callback.ICumm;

public class CummImpl implements ICumm {

	@Override
	public Object testA(Object obj) {
		System.out.println("obj=="+obj);
		return "returnValue";
	}

}
