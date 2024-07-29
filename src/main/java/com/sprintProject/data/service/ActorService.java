package com.sprintProject.data.service;


import java.util.List;

import java.util.Set;

import com.sprintProject.data.entity.Actor;
import com.sprintProject.data.entity.Customer;
import com.sprintProject.data.entity.Film;

public interface ActorService {
	List<Actor> getAllActors();
	Actor getActorById(int actorId);
	
	Actor addActor(Actor actor);
	
	List<Actor> getActorsByFirstName(String firstName);
	List<Actor> getActorsByLastName(String lastName);
	Actor updateFirstNameOfActor(int actorId , Actor actor);
	Actor updateLastNameOfActor(int actorId , Actor actor); 

	List<Actor> getFilmsByActorId(int actor_id);
	// get top 10 films method
	
	public void deleteActorByactor_id(int actorId);
}
