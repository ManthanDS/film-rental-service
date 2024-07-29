package com.sprintProject.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "INVENTORY")
public class Inventory{
    
	@Id
    @Column(name = "INVENTORY_ID",columnDefinition="mediumint(8) unsigned")
    private int inventory_id;

    @Column(name = "LAST_UPDATE",nullable=false,columnDefinition="timestamp")
    private Timestamp last_update;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "film_id", referencedColumnName = "film_id",nullable = false)
    private Film film;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id", referencedColumnName = "store_id",nullable = false)
    private Store store;

    @OneToMany(mappedBy = "inventory", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Rental> rentals;

	public int getInventory_id() {
		return inventory_id;
	}

	public void setInventory_id(int inventory_id) {
		this.inventory_id = inventory_id;
	}

	public Timestamp getLast_update() {
		return last_update;
	}

	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
	}

//	public Film getFilm() {
//		return film;
//	}
//
//	public void setFilm(Film film) {
//		this.film = film;
//	}

//	public Store getStore() {
//		return store;
//	}
//
//	public void setStore(Store store) {
//		this.store = store;
//	}
//
//	public Set<Rental> getRentals() {
//		return rentals;
//	}
//
//	public void setRentals(Set<Rental> rentals) {
//		this.rentals = rentals;
//	}

	public Inventory(int inventory_id, Timestamp last_update, Film film, Store store, Set<Rental> rentals) {
		super();
		this.inventory_id = inventory_id;
		this.last_update = last_update;
		this.film = film;
		this.store = store;
		this.rentals = rentals;
	}
	
	public Inventory() {
		super();
	}
    
}
