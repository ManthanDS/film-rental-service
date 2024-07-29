	package com.sprintProject.data.RestController;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprintProject.data.entity.Actor;
import com.sprintProject.data.entity.Film;
import com.sprintProject.data.service.ActorService;

@RestController
@RequestMapping("/api/actors")
public class ActorRestController {

	@Autowired
	ActorService aservice;

	@GetMapping("/all")
	public ResponseEntity<List<Actor>> getAllActors() {
		return new ResponseEntity<>(aservice.getAllActors(), HttpStatus.OK);
	}

	@GetMapping("/{actorid}")
	public ResponseEntity<Actor> getActorById(@PathVariable("actorid") int actorId) {
		return new ResponseEntity<>(aservice.getActorById(actorId), HttpStatus.OK);
	}

	@PostMapping("/post")
	public ResponseEntity<String> addActor(@RequestBody Actor actor) {
		aservice.addActor(actor);
		return new ResponseEntity<>("Record Created Successfully", HttpStatus.CREATED);
	}

	@GetMapping("/firstname/{fn}")
	public ResponseEntity<List<Actor>> getActorsByFirstName(@PathVariable("fn") String firstName) {
		return new ResponseEntity<>(aservice.getActorsByFirstName(firstName), HttpStatus.OK);
	}

	@GetMapping("/lastname/{ln}")
	public ResponseEntity<List<Actor>> getActorsByLastName(@PathVariable("ln") String lastName) {
		return new ResponseEntity<>(aservice.getActorsByLastName(lastName), HttpStatus.OK);
	}

	@PutMapping("/update/firstname/{actorId}")
	public ResponseEntity<Actor> updateFirstNameOfActor(@RequestBody Actor actor,
			@PathVariable("actorId") int actorId) {

		return new ResponseEntity<Actor>(aservice.updateFirstNameOfActor(actorId, actor), HttpStatus.CREATED);
	}

	@PutMapping("/update/lastname/{actorId}")
	public ResponseEntity<Actor> updateLastNameOfActor(@RequestBody Actor actor, @PathVariable("actorId") int actorId) {
		return new ResponseEntity<Actor>(aservice.updateLastNameOfActor(actorId, actor), HttpStatus.CREATED);
	}

	@GetMapping("/{actor_id}/films")
	public ResponseEntity<List<Actor>> getFilmsByActorId(@PathVariable("actor_id") int actor_id) {
		return new ResponseEntity<>(aservice.getFilmsByActorId(actor_id), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteActor(@PathVariable int id) {
        aservice.deleteActorByactor_id(id);
        return new ResponseEntity<>("Actor deleted successfully", HttpStatus.OK);
    }
	
	

}
