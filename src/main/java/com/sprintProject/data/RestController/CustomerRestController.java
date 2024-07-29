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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sprintProject.data.entity.Actor;
import com.sprintProject.data.entity.Customer;
import com.sprintProject.data.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {
	
	@Autowired
	CustomerService cservice;
	
	 @PostMapping("/post")

	  public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {

		  return new ResponseEntity<>("Record Created Successfully",HttpStatus.OK);

	  }
	
	@GetMapping("/lastname/{ln}")
	public ResponseEntity<List<Customer>> getCustomerByLastName(@PathVariable("ln") String ln){
		List<Customer> customers = cservice.getCustomerByLastname(ln);
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	
	@GetMapping("/firstname/{fn}")
	public ResponseEntity<List<Customer>> getCustomerByFirstName(@PathVariable("fn") String fn){
		List<Customer> customers = cservice.getCustomerByFirstname(fn);
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<List<Customer>> getCustomerByEmail(@PathVariable("email") String email){
		List<Customer> customers = cservice.getCustomerByEmail(email);
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	
	@GetMapping("/active")
	public ResponseEntity<List<Customer>> getCustomerWhichAreActive(){
		List<Customer> customers = cservice.getCustomerWhichAreActive();
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	
	@GetMapping("/inactive")
	public ResponseEntity<List<Customer>> getCustomerWhichAreInActive(){
		List<Customer> customers = cservice.getCustomerWhichAreInActive();
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	
	@GetMapping("/phone/{phone}")
	public ResponseEntity<List<Customer>> getCustomerByPhoneNumber(@PathVariable("phone") String phone){
		List<Customer> customers = cservice.getCustomerByPhoneNumber(phone);
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	
	@GetMapping("/city/{city}")
	public ResponseEntity<List<Customer>> getCustomerByCity(@PathVariable("city") String city){
		List<Customer> customers = cservice.getCustomerByCity(city);
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	
	@GetMapping("/country/{country}")
	public ResponseEntity<List<Customer>> getCustomersByCountry(@PathVariable("country") String country){
		List<Customer> customers = cservice.getCustomerByCountry(country);
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	
	/*
	 * @PostMapping("/post") public ResponseEntity<String> addCustomer(@RequestBody
	 * Customer customer){ cservice.addCustomer(customer); return new
	 * ResponseEntity<>("Record Created Successfully", HttpStatus.CREATED); }
	 */
	
	@PutMapping("/update/email/{id}")
    public ResponseEntity<Customer> updateCustomerByEmail(@RequestBody Customer customer ,@PathVariable("id") int id){
        Customer cust = cservice.updateCustomerEmail(customer, id);
        return new ResponseEntity<Customer>(cust, HttpStatus.CREATED);

    }
	
	@PutMapping("/update/fn/{id}")
    public ResponseEntity<String> updateCustomerByFirsstName(@RequestBody String customer ,@PathVariable("id") int id){
        Customer cust = cservice.updateCustomerFirstName(customer, id);
        return new ResponseEntity<String>("Record Update Successfully", HttpStatus.CREATED);
    }
	
	@PutMapping("/update/store/{id}")
    public ResponseEntity<String> updateCustomerAssignStoreToCustomer(@RequestBody int store ,@PathVariable("id") int id){
        Customer cust = cservice.updateCustomerAssignStoreToCustomer(store, id);
        return new ResponseEntity<String>("Record Update Successfully", HttpStatus.CREATED);
    }
	
	@PutMapping("/update/phone/{id}")
    public ResponseEntity<Customer> updateCustomerPhone(@RequestBody String phone,@PathVariable("id") int id){
        Customer cust = cservice.updateCustomerPhone(phone, id);
        return new ResponseEntity<Customer>(cust, HttpStatus.OK);
    }
	
	@PutMapping("/{id}/address")
    public ResponseEntity<String> updateCustomerAssignAddressToCustomer(@RequestBody int address ,@PathVariable("id") int id){
        Customer cust = cservice.updateCustomerAssignStoreToCustomer(address, id);
        return new ResponseEntity<String>("Adreess Update Successfully", HttpStatus.CREATED);
    }
	
	@PutMapping("/update/ln/{id}")
    public ResponseEntity<String> updateCustomerByLastName(@RequestBody String customer ,@PathVariable("id") int id){
        Customer cust = cservice.updateCustomerLastName(customer, id);
        return new ResponseEntity<String>("Record Update Successfully", HttpStatus.CREATED);
    }
}
