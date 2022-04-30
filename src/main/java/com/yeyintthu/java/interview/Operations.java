package com.yeyintthu.java.interview;

public enum Operations {
	FAIL("Fail to generate file."), SUCCESS("Successfully generated file.");

	public final String result;

	private Operations(String result) {
		this.result = result;
	}
}
