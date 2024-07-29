package com.sprintProject.data.RestController;

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

import com.sprintProject.data.entity.Address;
import com.sprintProject.data.entity.Customer;
import com.sprintProject.data.entity.Staff;
import com.sprintProject.data.entity.Store;
import com.sprintProject.data.service.StoreService;

@RestController
@RequestMapping("/api/store")
public class StoreRestController {
	
	@Autowired
	StoreService sservice;
	
	@PostMapping("/post")
	public ResponseEntity<String> rentFilm(@RequestBody Store store) {
		return new ResponseEntity<>("Record Created Successfully", HttpStatus.OK);

	}
	
	@GetMapping("/city/{city}")
	public ResponseEntity<List<Store>> getStoreByCity(@PathVariable("city") String city){
		List<Store> stores=sservice.getStoresByCity(city);
		return new ResponseEntity<List<Store>>(stores, HttpStatus.OK);
	}
	
	@GetMapping("/country/{country}")
	public ResponseEntity<List<Store>> getStoresByCountry(@PathVariable("country") String country){
		List<Store> stores=sservice.getStoresByCountry(country);
		return new ResponseEntity<List<Store>>(stores,HttpStatus.OK);
	}
	
	@GetMapping("/phone/{phone}")
	public ResponseEntity<List<Store>> getStoresByPhone(@PathVariable("phone") String phone){
		List<Store> stores=sservice.getStoresByPhone(phone);
		return new ResponseEntity<List<Store>>(stores,HttpStatus.OK);
	}
	
	@GetMapping("/staff/{id}")
	public ResponseEntity<List<Staff>> findAllStaffByStoreId(@PathVariable("id") int id){
		List<Staff> staff=sservice.findAllStaffByStoreId(id);
		return new ResponseEntity<List<Staff>>(staff,HttpStatus.OK);
	}
	
	@GetMapping("/manager/{id}")
	public ResponseEntity<Staff> getStaffByStore(@PathVariable("id") int id){
		Staff staff=sservice.getManagerByStore(id);
		return new ResponseEntity<Staff>(staff,HttpStatus.OK);
	}	
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<List<Customer>> findAllCustomersByStoreId(@PathVariable("id") int id){
		List<Customer> customer=sservice.findAllCustomersByStoreId(id);
		return new ResponseEntity<List<Customer>>(customer,HttpStatus.OK);
	}
	
	 @PutMapping("/update/address/{id}")
	 public ResponseEntity<String> updateStoreByAddress(@RequestBody Address address,@PathVariable("id") int staffId ){
	    return new ResponseEntity<String>("Record Update Successfully", HttpStatus.CREATED);
	 }
	
	
}
