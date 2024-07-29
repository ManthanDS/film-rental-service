package com.sprintProject.data.RestController;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprintProject.data.dto.CustomerDto;
import com.sprintProject.data.dto.FilmDto;
import com.sprintProject.data.entity.Customer;
import com.sprintProject.data.entity.Film;
import com.sprintProject.data.entity.Rental;
import com.sprintProject.data.service.RentalService;

@RestController
@RequestMapping("/api/rental")
public class RentalRestController {

	@Autowired
	RentalService rservice;

	@PostMapping("/add")
	public ResponseEntity<String> rentFilm(@RequestBody Rental rental) {
		return new ResponseEntity<>("Record Created Successfully", HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Rental> getAllRentalById(@PathVariable("id") int id) {
		return new ResponseEntity<Rental>(rservice.getAllRentalById(id), HttpStatus.OK);
	}

	@GetMapping("/customer/{id}")
	public ResponseEntity<List<FilmDto>> getAllFilmsRentedToCustomer(@PathVariable("id") int id) {
		return new ResponseEntity<List<FilmDto>>(rservice.getAllFilmsRentedToCustomer(id), HttpStatus.OK);
	}

	@GetMapping("/toptenfilms")
	public ResponseEntity<List<FilmDto>> getTopTenFilmsRentedToCustomer() {
		return new ResponseEntity<List<FilmDto>>(rservice.getTopTenFilmsRentedToCustomer(), HttpStatus.OK);
	}

	@GetMapping("/toptenfilms/store/{id}")
	public ResponseEntity<List<FilmDto>> getTopTenFilmsRentedOfAStore(@PathVariable("id") int id) {
		return new ResponseEntity<List<FilmDto>>(rservice.getTopTenFilmsRentedOfAStore(id), HttpStatus.OK);
	}

	@GetMapping("/due")
	public ResponseEntity<List<CustomerDto>> getCustomerWhoHaveNotReturnedTheFilm() {
		return new ResponseEntity<List<CustomerDto>>(rservice.getCustomerWhoHaveNotReturnedTheFilm(), HttpStatus.OK);
	}
	
	@PutMapping("/update/returndate/{id}/{date}")
	 public ResponseEntity<String> updateRentalByReturnDate(@PathVariable("date") Timestamp rental ,@PathVariable("id") int id){
        Rental re = rservice.updateRentalReturnDate(rental, id);
        return new ResponseEntity<String>("Record Update Successfully", HttpStatus.CREATED);
	}
}
