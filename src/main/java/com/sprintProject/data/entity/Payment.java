package com.sprintProject.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "PAYMENT")
public class Payment{

	@Id
	@Column(name = "PAYMENT_ID",nullable = false, columnDefinition="smallint(5) unsigned")
	private int payment_id;

	@Column(name = "AMOUNT",nullable = false, columnDefinition="decimal(5,2)")
	private int amount;

	@Column(name = "PAYMENT_DATE", nullable = false,columnDefinition = "datetime")
	private Timestamp payemnt_date;

	@Column(name = "LAST_UPDATE",nullable = false, columnDefinition="timestamp")
	private Timestamp last_update;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="CUSTOMER_ID",referencedColumnName = "CUSTOMER_ID",nullable=false)
	private Customer customer;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="staff_id",referencedColumnName = "STAFF_ID",nullable=false)
	private Staff staff;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="Rental_Id",referencedColumnName = "RENTAL_ID")
	private Rental rental;
	
	public Payment() {
		super();
	}

	public Payment(int payment_id, int amount, Timestamp payemnt_date,
			Timestamp last_update) {
		super();
		this.payment_id = payment_id;
		this.amount = amount;
		this.payemnt_date = payemnt_date;
		this.last_update = last_update;
	}

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Timestamp getPayemnt_date() {
		return payemnt_date;
	}

	public void setPayemnt_date(Timestamp payemnt_date) {
		this.payemnt_date = payemnt_date;
	}

	public Timestamp getLast_update() {
		return last_update;
	}

	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
	}
	
	
}
