package com.sprintProject.data.dto;

import java.sql.Date;
import java.sql.Timestamp;

import jakarta.persistence.Column;

public class CustomerDto {

	private int customer_id;
	private String first_name;
	private String last_name;
	private String email;
	private int active;
	private Date create_date;
	private Timestamp last_update;
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Timestamp getLast_update() {
		return last_update;
	}
	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
	}
	public CustomerDto(int customer_id, String first_name, String last_name, String email, int active, Date create_date,
			Timestamp last_update) {
		super();
		this.customer_id = customer_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.active = active;
		this.create_date = create_date;
		this.last_update = last_update;
	}
	
	

}
