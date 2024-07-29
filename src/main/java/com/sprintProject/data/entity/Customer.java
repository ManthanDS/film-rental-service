package com.sprintProject.data.entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

import java.sql.Timestamp;
import java.util.Set;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "customer")
public class Customer{
	@Id
	@Column(name = "customer_id",columnDefinition="smallint(5) unsigned")
	private int customer_id;
	
	@Column(name = "first_name",nullable=false,columnDefinition="varchar(45)")
	private String first_name;
	
	@Column(name = "last_name",nullable=false,columnDefinition="varchar(45)")
	private String last_name;
	
	@Column(name = "email",columnDefinition="varchar(50)")
	private String email;
	
	@Column(name = "Active",nullable=false,columnDefinition="tinyint(1) default 1")
	private int active;

	@Column(name = "create_date",nullable=false,columnDefinition="datetime null")
	private Date create_date;

	@Column(name = "last_update",nullable=false,columnDefinition="timestamp")
	private Timestamp last_update;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="address_id",referencedColumnName = "ADDRESS_ID",nullable =false)
	private Address address;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="store_id",referencedColumnName = "STORE_ID",nullable = false)
	private Store store;
	
	/*
	 * @OneToMany(mappedBy= "customer",fetch = FetchType.LAZY,cascade =
	 * CascadeType.ALL) private Set<Payment> payment;
	 * 
	 * @OneToMany(mappedBy= "customer",fetch = FetchType.LAZY,cascade =
	 * CascadeType.ALL) private Set<Rental> rental;
	 */
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

	public Customer() {super();}
	
	public Customer(int customer_id, String first_name, String last_name, String email, char active, Date create_date,
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
	public void setStore(Store store) { this.store = store; }
	public void setAddress(Address address) { this.address = address; }

	public Address getAddress() { return address; }
	//public Store getStore() { return store; }
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * public Set<Payment> getPayment() { return payment; }
	 * 
	 * public void setPayment(Set<Payment> payment) { this.payment = payment; }
	 * 
	 * public Set<Rental> getRental() { return rental; }
	 * 
	 * public void setRental(Set<Rental> rental) { this.rental = rental; }
	 */

	
	
}