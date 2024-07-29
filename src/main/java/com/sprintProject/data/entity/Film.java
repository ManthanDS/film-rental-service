package com.sprintProject.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;

import java.io.Serializable;
import java.sql.*;
import java.time.Year;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.DialectOverride.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sprintProject.data.enums.Rating;
import com.sprintProject.data.enums.Special_Features;

import io.micrometer.common.lang.NonNull;

@Entity
@Table(name="FILM")
public class Film implements Serializable{
	
    @Id
    @Column(name="FILM_ID",nullable=false,columnDefinition="smallint(5) unsigned")
    private int film_id;

    @Column(name="TITLE",nullable=false)
    private String title;

    @Column(name="DESCRIPTION",columnDefinition="TEXT")
    private String description;

    @Column(name="RELEASE_YEAR",columnDefinition="SMALLINT(4)",nullable = false)
    private int releaseYear;

	@Column(name="RENTAL_DURATION",nullable=false,columnDefinition="tinyint(3) unsigned default 3")
    private int rentalDuration;

    @Column(name="RENTAL_RATE",nullable=false,columnDefinition="decimal(4,2) default 4.99")
    private int rentalRate;

    @Column(name="LENGTH",columnDefinition="SMALLINT(5)")
    private int length;

    @Column(name="REPLACEMENT_COST",nullable=false,columnDefinition="decimal(5,2) default 19.99")
    private double replacementCost;

    @Column(name="RATING")
    private String rating;

//    @Enumerated(value = EnumType.STRING)
//    @Column(name="RATING",columnDefinition = "enum('G','NC_17','PG','PG_13','R') default G")
//    private Rating rating;
    
//      @Enumerated(EnumType.STRING)
//      @Column(name = "SPECIAL_FEATURES",columnDefinition = "SET('Trailers','Commentaries','Deleted Scenes','Behind the Scenes')")
//      private Set<Special_Features> specialFeatures;
//      
    @Column(name = "SPECIAL_FEATURES")
    private String specialFeatures;
      
    @Column(name="LAST_UPDATE",nullable=false,columnDefinition="Timestamp")
    private Timestamp lastUpdate;

    @OneToMany(mappedBy="film",fetch =FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Inventory> inventories;
    
    //@JsonIgnore
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="language_id",referencedColumnName = "language_id",nullable = false)
    private Language language;

//    @ManyToOne(cascade=CascadeType.ALL)
//    @JoinColumn(name="original_language_id",referencedColumnName="language_id",nullable = false)
//    private Language originalLanguage;

    //@PrimaryKeyJoinColumn
    //@JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Film_Actor"
    	,joinColumns = {@JoinColumn
    			(name = "film_id",referencedColumnName = "film_id")
    	},inverseJoinColumns = {@JoinColumn
    			(name = "actor_id",referencedColumnName = "actor_id"),
    	}
    )
    private List<Actor> actors;
    
    //@PrimaryKeyJoinColumn
    //@JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Film_Category"
    	,joinColumns = {@JoinColumn
    			(name = "film_id",referencedColumnName = "film_id",nullable = false),
    	},inverseJoinColumns = {@JoinColumn
    			(name = "category_id",referencedColumnName = "category_id",nullable = false)
    	}
    )
    private List<Category> categories;

	public int getFilm_id() {
		return film_id;
	}

	public void setFilm_id(int film_id) {
		this.film_id = film_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public int getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(int rentalRate) {
		this.rentalRate = rentalRate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

//	public Set<Inventory> getInventories() {
//		return inventories;
//	}
//
//	public void setInventories(Set<Inventory> inventories) {
//		this.inventories = inventories;
//	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public int getIntegerRating(String rating) {
		int res = 0;
		if(rating.equals("G")) {
			res = 1;
		}
		if(rating.equals("NC_17")) {
			res = 2;
		}
		if(rating.equals("PG")) {
			res = 3;
		}
		if(rating.equals("PG_13")) {
			res = 4;
		}
		if(rating.equals("R")) {
			res = 5;
		}
		return res;
	}
	
	
	


	
}
