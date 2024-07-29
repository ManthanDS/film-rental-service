package com.sprintProject.data.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprintProject.data.dto.FilmAmount;
import com.sprintProject.data.service.PaymentService;

@RestController
@RequestMapping("/api/payment")
public class PaymentRestController {

	@Autowired
	PaymentService pservice;
	
	@GetMapping("/revenue/filmwise")
	public ResponseEntity<List<FilmAmount>> getFilmsAmountRented(){
		return new ResponseEntity<List<FilmAmount>>(pservice.getFilmsAmountRented(),HttpStatus.OK); 
	}
	
	@GetMapping("/revenue/film/{id}")
	public ResponseEntity<List<FilmAmount>> getRevemueOfAFilmAmountRented(@PathVariable("id") int id){
		return new ResponseEntity<List<FilmAmount>>(pservice.getRevemueOfAFilmAmountRented(id),HttpStatus.OK); 
	}
	
	@GetMapping("/revenue/films/store/{id}")
	public ResponseEntity<List<FilmAmount>> getRevenueOfAllFilmsByStore(@PathVariable("id") int id){
		return new ResponseEntity<List<FilmAmount>>(pservice.getRevenueOfAllFilmsByStore(id),HttpStatus.OK); 
	}
}
