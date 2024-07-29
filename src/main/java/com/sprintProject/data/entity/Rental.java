package com.sprintProject.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "RENTAL")
public class Rental{

    @Id
    @Column(name = "RENTAL_ID")
    private int Rental_Id;

    @Column(name = "RENTAL_DATE",nullable = false,columnDefinition = "datetime")
    private Timestamp Rental_Date;

   

    @Column(name = "RETURN_DATE",columnDefinition = "datetime")
    private Timestamp Return_Date;

   

    @Column(name = "LAST_UPDATE",nullable = false,columnDefinition = "timestamp")
    private Timestamp Last_Update;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "inventory_id", referencedColumnName = "INVENTORY_ID",nullable = false)
    private Inventory inventory;
     

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "CUSTOMER_ID",nullable=false)
    private Customer customer;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Staff_Id", referencedColumnName = "STAFF_ID", nullable =false)
    private Staff staff;

//    @OneToMany(mappedBy = "rental", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private Set<Payment> payments;
   
	public Rental() {
		super();
	}

	public Rental(int rental_Id, Timestamp rental_Date, Timestamp return_Date,
			Timestamp last_Update) {
		super();
		Rental_Id = rental_Id;
		Rental_Date = rental_Date;
		
		Return_Date = return_Date;
		
		Last_Update = last_Update;
	}

	public int getRental_Id() {
		return Rental_Id;
	}

	public void setRental_Id(int rental_Id) {
		Rental_Id = rental_Id;
	}

	public Timestamp getRental_Date() {
		return Rental_Date;
	}

	public void setRental_Date(Timestamp rental_Date) {
		Rental_Date = rental_Date;
	}

		

	public Timestamp getReturn_Date() {
		return Return_Date;
	}

	public void setReturn_Date(Timestamp return_Date) {
		Return_Date = return_Date;
	}

	

	public Timestamp getLast_Update() {
		return Last_Update;
	}

	public void setLast_Update(Timestamp last_Update) {
		Last_Update = last_Update;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

    
}
