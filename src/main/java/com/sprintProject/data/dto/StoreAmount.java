package com.sprintProject.data.dto;

import java.sql.Timestamp;

import com.sprintProject.data.entity.Address;


public class StoreAmount {

	private int store_id;
	
	private double amount;

	public int getStore_id() {
		return store_id;
	}

	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public StoreAmount(int store_id, double amount) {
		super();
		this.store_id = store_id;
		this.amount = amount;
	}
	
	
}
