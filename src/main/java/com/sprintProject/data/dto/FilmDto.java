package com.sprintProject.data.dto;

import java.sql.Timestamp;
import java.util.Set;

import com.sprintProject.data.entity.Inventory;
import com.sprintProject.data.entity.Language;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

public class FilmDto {

	 
	    public int film_id;
	    public String title;
	    public String description;
	    public int releaseYear;
	    public int rentalRate;
	    public String rating;
	    public String specialFeatures;
	    public Language language;
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
		public int getRentalRate() {
			return rentalRate;
		}
		public void setRentalRate(int rentalRate) {
			this.rentalRate = rentalRate;
		}
		public String getRating() {
			return rating;
		}
		public void setRating(String rating) {
			this.rating = rating;
		}
		public String getSpecialFeatures() {
			return specialFeatures;
		}
		public void setSpecialFeatures(String specialFeatures) {
			this.specialFeatures = specialFeatures;
		}
		public Language getLanguage() {
			return language;
		}
		public void setLanguage(Language language) {
			this.language = language;
		}
		public FilmDto(int film_id, String title, String description, int releaseYear, int rentalRate, String rating,
				String specialFeatures, Language language) {
			super();
			this.film_id = film_id;
			this.title = title;
			this.description = description;
			this.releaseYear = releaseYear;
			this.rentalRate = rentalRate;
			this.rating = rating;
			this.specialFeatures = specialFeatures;
			this.language = language;
		}
		
	    
}
