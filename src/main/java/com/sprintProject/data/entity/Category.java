package com.sprintProject.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name="CATEGORY")
public class Category{
	
    @Id
    @Column(name="CATEGORY_ID",columnDefinition="tinyint(3) unsigned")
    private int category_id;
    
    @Column(name="NAME",nullable=false,columnDefinition="varchar(25)")
    private String name;
    
    @Column(name="LAST_UPDATE",nullable=false,columnDefinition="timestamp")
    private Timestamp last_update;

	public Category() {
		super();
	}

	public Category(int category_id, String name, Timestamp last_update) {
		super();
		this.category_id = category_id;
		this.name = name;
		this.last_update = last_update;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getLast_update() {
		return last_update;
	}

	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
	}
    
	
    
}
