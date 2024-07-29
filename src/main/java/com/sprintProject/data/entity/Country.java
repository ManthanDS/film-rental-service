package com.sprintProject.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name="COUNTRY")
public class Country{
	@Id
	@Column(name="COUNTRY_ID",columnDefinition="smallint(5) unsigned")
	private int country_id;
	
	@Column(name="COUNTRY",nullable=false,columnDefinition="varchar(50)")
	private String country;
	
	@Column(name="LAST_UPDATE",nullable=false,columnDefinition="timestamp")
	private Timestamp last_update;

	@OneToMany(mappedBy="country",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Set<City> cities;
	
	
	public Country() {
		super();
	}

	public Country(int country_id, String country, Timestamp last_update) {
		super();
		this.country_id = country_id;
		this.country = country;
		this.last_update = last_update;
	}

	public int getCountry_id() {
		return country_id;
	}

	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Timestamp getLast_update() {
		return last_update;
	}

	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
	}
	
	
}
