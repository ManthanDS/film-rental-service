package com.sprintProject.data.service;

import java.util.List;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprintProject.data.entity.Actor;
import com.sprintProject.data.entity.Customer;
import com.sprintProject.data.entity.Film;
import com.sprintProject.data.entity.Store;
import com.sprintProject.data.exception.NotFoundException;
import com.sprintProject.data.repository.ActorRepository;
import com.sprintProject.data.repository.FilmRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ActorServiceImpl implements ActorService {
	@Autowired
	ActorRepository arepo;
	
	@Autowired
	FilmRepository filmRepository;

	@Override

	public List<Actor> getAllActors() {

		return arepo.findAll();

	}

	@Override

	public Actor getActorById(int actorId) {

		return arepo.findById(actorId).get();

	}

	@Override

	public List<Actor> getActorsByFirstName(String firstName) {

		return arepo.getActorsByFirstName(firstName);

	}

	@Override

	public List<Actor> getActorsByLastName(String lastName) {

		return arepo.getActorsByLastName(lastName);

	}

	@Override

	public Actor updateFirstNameOfActor(int actorId, Actor actor) {

		Actor actorToUpdate = arepo.findById(actorId).get();

		actorToUpdate.setFirst_name(actor.getFirst_name());

		return actorToUpdate;

	}

	@Override

	public Actor updateLastNameOfActor(int actorId, Actor actor) {

		Actor actorToUpdate = arepo.findById(actorId).get();

		actorToUpdate.setLast_name(actor.getLast_name());

		return actorToUpdate;

	}

	@Override
	public Actor addActor(Actor actor) {

		return arepo.save(actor);
	}
	
	@Override
	public List<Actor> getFilmsByActorId(int actor_id) {
	    List<Actor> films = arepo.getFilmsByActorId(actor_id);
	    if (films.isEmpty()) {
	       throw new NotFoundException("Films not found for actor with ID: " + actor_id);
	    }
	    return films;
	}

	@Override
	public void deleteActorByactor_id(int actorId) {
		// TODO Auto-generated method stub
		arepo.deleteById(actorId);
	}

	
	
	
}
