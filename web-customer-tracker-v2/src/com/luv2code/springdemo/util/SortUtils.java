package com.luv2code.springdemo.util;

public enum SortUtils {
	FIRST_NAME(0), LAST_NAME(1), EMAIL(2);
	
	private int value;
	
	private SortUtils(int value) {
		this.value=value;
	}
	
	public int getValue() {
		return value;
	}
}
