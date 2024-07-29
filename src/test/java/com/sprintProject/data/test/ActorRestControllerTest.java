package com.sprintProject.data.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sprintProject.data.RestController.ActorRestController;
import com.sprintProject.data.entity.Actor;
import com.sprintProject.data.service.ActorService;


@SpringBootTest
public class ActorRestControllerTest {
	
	@Mock
	ActorService aservice;
	
	@InjectMocks
	ActorRestController acontroller;
	
	/* rest api testing */
	@Test
	void testGetAllActorsApi() {
		List<Actor> actors = new ArrayList<>();
		actors.add(new Actor(1, "anil", "patil", null));
		actors.add(new Actor(2, "vishal", "kumbhar", null));
		actors.add(new Actor(3, "samir", "patil", null));
		
		when(aservice.getAllActors()).thenReturn(actors);
		
		ResponseEntity<List<Actor>> response = acontroller.getAllActors();
		
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assertions.assertEquals(actors, response.getBody());
		
		verify(aservice, times(1)).getAllActors();
	}
	
	/*negative test cases*/
	@Test
	void testGetAllActorsApiForEmptyList() {
		when(aservice.getAllActors()).thenReturn(new ArrayList<>());
		
		ResponseEntity<List<Actor>> response = acontroller.getAllActors();
		
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assertions.assertEquals(new ArrayList<>(), response.getBody());
		
		verify(aservice, times(1)).getAllActors();
	}
	
}
