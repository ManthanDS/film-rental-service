package com.sprintProject.data.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="STORE")
public class Store{
	
	@Id
	@Column(name = "STORE_ID",nullable=false,columnDefinition="tinyint(3) unsigned")
	private int store_id;

	@Column(name = "LAST_UPDATE",nullable = false,columnDefinition = "timestamp")
	private Timestamp last_update;
	
	@JsonIgnore
	@OneToMany(mappedBy="store",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<Inventory> inventories;
	
	@JsonIgnore
	@OneToMany(mappedBy="store",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<Customer> customers;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "address_id",nullable = false)
	private Address address;
	
	@JsonIgnore
	@OneToMany(mappedBy="store", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<Staff> staffs;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "manager_staff_id",referencedColumnName="staff_id",unique = true,nullable = false)
	private Staff staff;
	
	public int getStore_id() {
		return store_id;
	}
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
	
	public Timestamp getLast_update() {
		return last_update;
	}
	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
	}
	
	public Store(int store_id, Timestamp last_update) {
		super();
		this.store_id = store_id;
		
		this.last_update = last_update;
	}
	
	public Store() {
		super();
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////
//	public Set<Inventory> getInventories() {
//		return inventories;
//	}
//	public void setInventories(Set<Inventory> inventories) {
//		this.inventories = inventories;
//	}
//	public Set<Customer> getCustomers() {
//		return customers;
//	}
//	public void setCustomers(Set<Customer> customers) {
//		this.customers = customers;
//	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
//	public Set<Staff> getStaffs() {
//		return staffs;
//	}
	public void setStaffs(Set<Staff> staffs) {
		this.staffs = staffs;
	}
//	public Staff getStaff() {
//		return staff;
//	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
//	

	
	
	
}
