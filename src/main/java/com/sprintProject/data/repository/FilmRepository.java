package com.sprintProject.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sprintProject.data.entity.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer>{
	
	@Query("select film_id from Film f where f.film_id=?1")
	public Film getFilmsById(int id);

}
