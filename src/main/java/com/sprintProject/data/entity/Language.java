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

import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="LANGUAGE")
public class Language {
    
	@Id
    @Column(name="LANGUAGE_ID",columnDefinition="tinyint(3) unsigned")
    private int languageId;
    
    @Column(name="NAME",nullable = false,columnDefinition="char(20)")
    private String languageName;
    
    @Column(name="LAST_UPDATE",nullable = false, columnDefinition="timestamp")
    private Timestamp timestamp;

    @JsonIgnore
    @OneToMany(mappedBy = "language", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Film> films;

//    @OneToMany(mappedBy = "originalLanguage", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    private Set<Film> original_language_films;
    
	public Set<Film> getFilms() {
		return films;
	}

	public void setFilms(Set<Film> films) {
		this.films = films;
	}


	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public Language(int languageId, String languageName, Timestamp timestamp) {
		super();
		this.languageId = languageId;
		this.languageName = languageName;
		this.timestamp = timestamp;
	}

	public Language() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(films, languageId, languageName, timestamp);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Language other = (Language) obj;
		return Objects.equals(films, other.films) && languageId == other.languageId
				&& Objects.equals(languageName, other.languageName) && Objects.equals(timestamp, other.timestamp);
	}
    
    
}
