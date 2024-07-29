package com.sprintProject.data.dto;

public class InventoryStoreCount {
	int store_id,manager_staff_id,Address_id;
	long count;
	public int getStore_id() {
		return store_id;
	}
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
	public int getManager_staff_id() {
		return manager_staff_id;
	}
	public void setManager_staff_id(int manager_staff_id) {
		this.manager_staff_id = manager_staff_id;
	}
	public int getAddress_id() {
		return Address_id;
	}
	public void setAddress_id(int address_id) {
		Address_id = address_id;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public InventoryStoreCount(int store_id, int manager_staff_id, int address_id, long count) {
		super();
		this.store_id = store_id;
		this.manager_staff_id = manager_staff_id;
		Address_id = address_id;
		this.count = count;
	}
	
	
}
