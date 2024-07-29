package com.sprintProject.data.exception;

public class ActorNotFoundException extends Exception{

	String msg;
	int id;
	public ActorNotFoundException(String msg, int id) {
		super();
		this.msg = msg;
		this.id = id;
	}
	public String getMsg() {
		return msg;
	}

	public int getId() {
		return id;
	}

	
}
