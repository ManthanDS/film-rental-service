package com.sprintProject.data.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.sql.*;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="STAFF")
@JsonIgnoreProperties(value = { "picture" })
public class Staff{
	@Id
	@Column(name="STAFF_ID",nullable = false, columnDefinition="tinyint(3) unsigned")
	private int staff_id;
	
	@Column(name="FIRST_NAME",nullable = false, columnDefinition = "varchar(45)")
	private String first_name;
	
	@Column(name="LAST_NAME",nullable = false, columnDefinition = "varchar(45)")
	private String last_name;
	
	
	@Column(name="EMAIL",columnDefinition = "varchar(50)")
	private String email;
	
	@Column(name="PICTURE", columnDefinition = "blob")
	private Blob picture;
	
	@Column(name="ACTIVE",nullable=false, columnDefinition="tinyint(1)")
	private boolean active;

	
	@Column(name="LAST_UPDATE",nullable=false, columnDefinition="timestamp")
	private Timestamp last_update;
	
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "",joinColumns = {
//			@JoinColumn(name="manager_staff_id",referencedColumnName = "staff_id")
//			},inverseJoinColumns = {
//			@JoinColumn(name="store_id",referencedColumnName = "store_id")
//	})
//	private List<Store> stores;
//	@OneToMany(mappedBy="staff", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//	private Set<Rental> rentals;
//	
//	@OneToMany(mappedBy = "staff",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//	private Set<Payment> payments;
//	
//	@OneToMany(mappedBy="staff", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//	private Set<Store> stores;
//	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "store_id",referencedColumnName="store_id", nullable =false)
	private Store store;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="address_id", referencedColumnName = "address_id",nullable  = false)
	private Address address;
	
	
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
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
	public Blob getPicture() {
		return picture;
	}
	public void setPicture(Blob picture) {
		this.picture = picture;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public Timestamp getLast_update() {
		return last_update;
	}
	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
	}
	public Staff(int staff_id, String first_name, String last_name, int address_id, String email, Blob picture,
			boolean active, Timestamp last_update) {
		super();
		this.staff_id = staff_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.picture = picture;
		this.active = active;
		this.last_update = last_update;
	}
	
	public Staff(int staff_id, String first_name, String last_name, int address_id, String email, boolean active,

            Timestamp last_update) {
        super();
        this.staff_id = staff_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.active = active;
        this.last_update = last_update;
    }
	public Staff() {
		super();
	}
	
	
	
	
	
}
