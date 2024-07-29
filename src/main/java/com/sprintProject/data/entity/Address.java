package com.sprintProject.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "address")
public class Address {
	
	@Id
	@Column(name = "ADDRESS_ID",columnDefinition="smallint(5) unsigned")
	private int address_Id;
	
	@Column(name = "address",nullable=false,columnDefinition="varchar(50)")
	private String address;

	@Column(name = "address2",columnDefinition="varchar(50)")
	private String address2;

	@Column(name = "district",nullable=false,columnDefinition="varchar(20)")
	private String district;
	
	@Column(name = "postal_code", nullable = false,columnDefinition="varchar(10)")
	private String postal_code;

	@Column(name = "phone",nullable=false,columnDefinition="varchar(20)")
	private String phone;

	@Column(name = "last_update",nullable=false,columnDefinition="timestamp")
	private Timestamp last_Update;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="CITY_ID",referencedColumnName = "CITY_ID",nullable=false)
	private City city;
	 

	@OneToMany(mappedBy = "address",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<Customer> customer;

	 

	@OneToMany(mappedBy = "address",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<Staff> staff;
	 

	@OneToMany(mappedBy = "address",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<Store> store;
	
	public int getAddress_Id() {
		return address_Id;
	}
	public void setAddress_Id(int address_Id) {
		this.address_Id = address_Id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Timestamp getLast_Update() {
		return last_Update;
	}
	public void setLast_Update(Timestamp last_Update) {
		this.last_Update = last_Update;
	}
	public Address(int address_Id, String address, String address2, String district, String postal_code, String phone, Timestamp last_Update) {
		super();
		this.address_Id = address_Id;
		this.address = address;
		this.address2 = address2;
		this.district = district;
		this.postal_code = postal_code;
		this.phone = phone;
		this.last_Update = last_Update;
	}

	public Address() {
		super();
	}

}
