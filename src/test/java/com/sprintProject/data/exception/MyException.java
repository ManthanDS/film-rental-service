package com.sprintProject.data.exception;

public class MyException extends Exception{

	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public MyException(String msg) {
		super();
		this.msg = msg;
	}
	
	
}
