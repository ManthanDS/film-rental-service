package com.sprintProject.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "City")
public class City{
	
	@Id
	@Column(name = "CITY_ID",columnDefinition="smallint(5) unsigned")
	private int city_Id;

	@Column(name = "CITY",nullable=false,columnDefinition="varchar(50)")
	private String city;

	@Column(name = "LAST_UPDATE",nullable = false,columnDefinition="timestamp")
	private Timestamp last_Update;

	@OneToMany(mappedBy = "city", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Address> addresses;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="COUNTRY_ID",referencedColumnName = "COUNTRY_ID",nullable= false)
	private Country country;
	
	
	public City() {
		super();
	}

	public City(int city_Id, String city, Timestamp last_Update) {
		super();
		this.city_Id = city_Id;
		this.city = city;
		this.last_Update = last_Update;
	}

	public int getCity_Id() {
		return city_Id;
	}

	public void setCity_Id(int city_Id) {
		this.city_Id = city_Id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	public Timestamp getLast_Update() {
		return last_Update;
	}

	public void setLast_Update(Timestamp last_Update) {
		this.last_Update = last_Update;
	}
	
	

}