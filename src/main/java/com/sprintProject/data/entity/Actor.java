package com.sprintProject.data.entity;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name="Actor")
public class Actor{
	
	@Id
	@Column(name="ACTOR_ID",columnDefinition="smallint(5) unsigned")
	private int actor_id;
	
	@Column(name="FIRST_NAME",nullable=false,columnDefinition="varchar(45)")
	private String first_name;
	
	@NotNull
	@Column(name="LAST_NAME",nullable=false,columnDefinition="varchar(45)")
	private String last_name;
	
	@Column(name="LAST_UPDATE",nullable=false,columnDefinition="timestamp")
	private Timestamp last_update;
	
	public Actor() {super();}
	
	public Actor(int actor_id, String first_name, String last_name, Timestamp last_update) {
		super();
		this.actor_id = actor_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.last_update = last_update;
	}

	public int getActor_id() {
		return actor_id;
	}

	public void setActor_id(int actor_id) {
		this.actor_id = actor_id;
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

	public Timestamp getLast_update() {
		return last_update;
	}

	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
	}
	
	
	
	
	
}
