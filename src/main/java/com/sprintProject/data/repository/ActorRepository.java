package com.sprintProject.data.repository;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sprintProject.data.entity.Actor;
import com.sprintProject.data.entity.Film;

import jakarta.transaction.Transactional;



@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {

	
	@Query("select u from Actor u where u.first_name = ?1")
    List<Actor> getActorsByFirstName(String firstName);

    @Query("select u from Actor u where u.last_name = ?1")
    List<Actor> getActorsByLastName(String lastName);

	/*
	 * @Query(
	 * value="select f.* from film f join film_actor fa on f.film_id=fa.film_id where fa.actor_id=?1"
	 * ,nativeQuery = true) List<Film> getFilmsByActorId(int actorId);
	 */	
    
    @Query("select f from Actor f where f.actor_id = ?1")
    List<Actor> getFilmsByActorId(int actor_id);
    
   
}
