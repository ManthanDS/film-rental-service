package com.sprintProject.data.test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sprintProject.data.RestController.CustomerRestController;
import com.sprintProject.data.entity.Customer;
import com.sprintProject.data.exception.InvalidException;
import com.sprintProject.data.exception.NotFoundException;
import com.sprintProject.data.service.CustomerService;

@SpringBootTest
public class CustomerRestControllerTest {

	@Mock
	CustomerService cservice;

	@InjectMocks
	CustomerRestController ccontroller;

	@Test
	void testGetCustomerByLastname() {
		Customer c1 = new Customer(1, "sunil", "sharma", "ababba@gmail.com", '1', new Date(0), new Timestamp(0));
		Customer c2 = new Customer(2, "vishal", "patil", "ababba@gmail.com", '1', new Date(0), new Timestamp(0));
		Customer c3 = new Customer(3, "amar", "patil", "ababba@gmail.com", '1', new Date(0), new Timestamp(0));
		Customer c4 = new Customer(4, "sunil", "patil", "ababba@gmail.com", '1', new Date(0), new Timestamp(0));

		List<Customer> customers = new ArrayList<>();
		customers.add(c2);
		customers.add(c3);
		customers.add(c4);

		when(cservice.getCustomerByLastname("patil")).thenReturn(customers);
		ResponseEntity<List<Customer>> response = ccontroller.getCustomerByLastName("patil");
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assertions.assertEquals(customers, response.getBody());
		verify(cservice, times(1)).getCustomerByLastname("patil");
	}

	@Test
	void testGetCustomerByFirstname() {
		Customer c1 = new Customer(1, "sunil", "sharma", "ababba@gmail.com", '1', new Date(0), new Timestamp(0));
		Customer c2 = new Customer(2, "vishal", "patil", "ababba@gmail.com", '1', new Date(0), new Timestamp(0));
		Customer c3 = new Customer(3, "sunil", "patil", "ababba@gmail.com", '1', new Date(0), new Timestamp(0));
		Customer c4 = new Customer(4, "sunil", "sinha", "ababba@gmail.com", '1', new Date(0), new Timestamp(0));

		List<Customer> customers = new ArrayList<>();
		customers.add(c1);
		customers.add(c3);
		customers.add(c4);

		when(cservice.getCustomerByFirstname("sunil")).thenReturn(customers);
		ResponseEntity<List<Customer>> response = ccontroller.getCustomerByFirstName("sunil");
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assertions.assertEquals(customers, response.getBody());
		verify(cservice, times(1)).getCustomerByFirstname("sunil");
	}

	@Test
	void testGetCustomerByEmail() {

		Customer c1 = new Customer(1, "anil", "patil", "ababba@gmail.com", '1', new Date(0), new Timestamp(0));
		Customer c2 = new Customer(2, "vishal", "sharma", "adadaaa@gmail.com", '1', new Date(0), new Timestamp(0));
		Customer c3 = new Customer(3, "anil", "patil", "ababba@gmail.com", '1', new Date(0), new Timestamp(0));

		List<Customer> customers = new ArrayList<>();
		customers.add(c1);
		customers.add(c3);

		when(cservice.getCustomerByEmail("ababba@gmail.com")).thenReturn(customers);
		ResponseEntity<List<Customer>> response = ccontroller.getCustomerByEmail("ababba@gmail.com");
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assertions.assertEquals(customers, response.getBody());
		verify(cservice, times(1)).getCustomerByEmail("ababba@gmail.com");
	}

	@Test
	void testGetCustomerWhichAreActive() {

		Customer c1 = new Customer(1, "anil", "patil", "ababba@gmail.com", '1', new Date(0), new Timestamp(0));
		Customer c2 = new Customer(2, "ashish", "seth", "ababba@gmail.com", '0', new Date(0), new Timestamp(0));
		Customer c3 = new Customer(3, "vikram", "sharma", "ababba@gmail.com", '0', new Date(0), new Timestamp(0));
		Customer c4 = new Customer(4, "vishal", "sinha", "ababba@gmail.com", '1', new Date(0), new Timestamp(0));

		List<Customer> customers = new ArrayList<>();
		customers.add(c1);
		customers.add(c4);

		when(cservice.getCustomerWhichAreActive()).thenReturn(customers);
		ResponseEntity<List<Customer>> response = ccontroller.getCustomerWhichAreActive();
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assertions.assertEquals(customers, response.getBody());
		verify(cservice, times(1)).getCustomerWhichAreActive();
	}

	@Test
	void testGetCustomerWhichAreInActive() {

		Customer c1 = new Customer(1, "anil", "patil", "ababba@gmail.com", '1', new Date(0), new Timestamp(0));
		Customer c2 = new Customer(2, "ashish", "seth", "ababba@gmail.com", '0', new Date(0), new Timestamp(0));
		Customer c3 = new Customer(3, "vikram", "sharma", "ababba@gmail.com", '0', new Date(0), new Timestamp(0));
		Customer c4 = new Customer(4, "vishal", "sinha", "ababba@gmail.com", '1', new Date(0), new Timestamp(0));
		List<Customer> customers = new ArrayList<>();
		customers.add(c1);
		customers.add(c4);

		when(cservice.getCustomerWhichAreInActive()).thenReturn(customers);
		ResponseEntity<List<Customer>> response = ccontroller.getCustomerWhichAreInActive();
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assertions.assertEquals(customers, response.getBody());
		verify(cservice, times(1)).getCustomerWhichAreInActive();
	}
	
	/*negative test cases*/

    @Test
    void invalidTestForGetCustomerByLastname() {
        String lastname = "asdf";
        when(cservice.getCustomerByLastname(lastname)).thenThrow(NotFoundException.class);
        assertThrows(NotFoundException.class, ()->{ccontroller.getCustomerByLastName(lastname);});
    }
    
    @Test
    void invalidTestForGetCustomerByFirstname() {
        String firstname = "asdf";
        when(cservice.getCustomerByFirstname(firstname)).thenThrow(NotFoundException.class);
        assertThrows(NotFoundException.class, ()->{ccontroller.getCustomerByFirstName(firstname);});
    }
    
    @Test
    void invalidTestForGetCustomerByEmail() {
        String email = "asdf@gmail.com";
        when(cservice.getCustomerByEmail(email)).thenThrow(NotFoundException.class);
        assertThrows(NotFoundException.class, ()->{ccontroller.getCustomerByEmail(email);});
    }
    
    @Test
    void invalidTestForGetCustomerByCity() {
        String city = "city";
        when(cservice.getCustomerByCity(city)).thenThrow(NotFoundException.class);
        assertThrows(NotFoundException.class, ()->{ccontroller.getCustomerByCity(city);});
    }
    
    @Test
    void invalidTestForGetCustomerByCountry() {
        String country = "country";
        when(cservice.getCustomerByCountry(country)).thenThrow(NotFoundException.class);
        assertThrows(NotFoundException.class, ()->{ccontroller.getCustomersByCountry(country);});
    }
    
    @Test
    void invalidTestForGetCustomerByPhone() {
        String phone = "00000000000";
        when(cservice.getCustomerByPhoneNumber(phone)).thenThrow(InvalidException.class);
        assertThrows(InvalidException.class, ()->{ccontroller.getCustomerByPhoneNumber(phone);});
    }

    @Test
    void invalidTestForGetCustomerByPhoneWithLetter() {
        String phone = "000000a000";
        when(cservice.getCustomerByPhoneNumber(phone)).thenThrow(InvalidException.class);
        assertThrows(InvalidException.class, ()->{ccontroller.getCustomerByPhoneNumber(phone);});
    }

    @Test
    void invalidTestForGetCustomerByPhoneNotFound() {
        String phone = "1234567890";
        when(cservice.getCustomerByPhoneNumber(phone)).thenThrow(NotFoundException.class);
        assertThrows(NotFoundException.class, ()->{ccontroller.getCustomerByPhoneNumber(phone);});
    }
}
