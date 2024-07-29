package com.sprintProject.data.test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sprintProject.data.RestController.StaffRestController;
import com.sprintProject.data.entity.Staff;
import com.sprintProject.data.exception.InvalidException;
import com.sprintProject.data.exception.NotFoundException;
import com.sprintProject.data.service.StaffService;

@SpringBootTest
public class StaffRestControllerTest {
	
	@Mock
	StaffService sservice;
	
	@InjectMocks
	StaffRestController scontroller;
	
	/*positive test cases*/
	
	@Test
	void testForGetStaffByLastname() {
		List<Staff> staffs = new ArrayList<>();
		staffs.add(new Staff(1, "sunil", "patil", 1, "sunil@capgemini.com", true, new Timestamp(0)));
		staffs.add(new Staff(2, "samir", "patil", 1, "samir@capgemini.com", true, new Timestamp(0)));
		
		when(sservice.getStaffByLastname("patil")).thenReturn(staffs);
		ResponseEntity<List<Staff>> response = scontroller.getStaffByLastName("patil");
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(staffs, response.getBody());
        verify(sservice, times(1)).getStaffByLastname("patil");
	}
	
	@Test
	void testForGetStaffByFirstname() {
		
		List<Staff>staffs = new ArrayList<>();
		staffs.add(new Staff(1, "sunil", "patil", 1, "sunil@capgemini.com", true, new Timestamp(0)));
		staffs.add(new Staff(2, "sunil", "sharma", 1, "sunil@capgemini.com", true, new Timestamp(0)));
		staffs.add(new Staff(4, "sunil", "shinde", 1, "sunil@capgemini.com", true, new Timestamp(0)));
		
		when(sservice.getStaffByFirstname("sunil")).thenReturn(staffs);
		ResponseEntity<List<Staff>> response = scontroller.getStaffByFirstName("sunil");
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(staffs, response.getBody());
        verify(sservice, times(1)).getStaffByFirstname("sunil");
	}
	
	@Test
	void testForGetStaffByEmail() {
		Staff s1=new Staff(1, "sunil", "patil", 1, "sunil@capgemini.com", true, new Timestamp(0));
		Staff s2=new Staff(2, "sunil", "sharma", 1, "sunil@capgemini.com", true, new Timestamp(0));
		Staff s3=new Staff(3, "anil", "sharma", 1, "anil@capgemini.com", true, new Timestamp(0));
		Staff s4=new Staff(4, "sunil", "shinde", 1, "sunil@capgemini.com", true, new Timestamp(0));
		
		List<Staff> staffs = new ArrayList<>();
		staffs.add(s1);staffs.add(s2);staffs.add(s4);
		
		when(sservice.getStaffByEmail("sunil@capgemini.com")).thenReturn(staffs);
		ResponseEntity<List<Staff>> response = scontroller.getStaffByEmail("sunil@capgemini.com");
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(staffs, response.getBody());
        verify(sservice, times(1)).getStaffByEmail("sunil@capgemini.com");
	}
	
	
	/*negative test cases*/
	@Test
	void invalidTestForGetStaffByLastname() {
		String lastname = "asdf";
		when(sservice.getStaffByLastname(lastname)).thenThrow(NotFoundException.class);
		
		assertThrows(NotFoundException.class, ()->{scontroller.getStaffByLastName(lastname);});
	}
	
	@Test
	void invalidTestForGetStaffByFirstname() {
		String firstname = "asdf";
		when(sservice.getStaffByFirstname(firstname)).thenThrow(NotFoundException.class);
		
		assertThrows(NotFoundException.class, ()->{scontroller.getStaffByFirstName(firstname);});
	}
	
	@Test
	void invalidTestForGetStaffByEmail() {
		String email = "asdf@gmail.com";
		when(sservice.getStaffByEmail(email)).thenThrow(NotFoundException.class);
		
		assertThrows(NotFoundException.class, ()->{scontroller.getStaffByEmail(email);});
	}
	
	@Test
	void invalidTestForGetStaffByCity() {
		String city = "asdf";
		when(sservice.getStaffByCity(city)).thenThrow(NotFoundException.class);
		
		assertThrows(NotFoundException.class, ()->{scontroller.getStaffByCity(city);});
	}
	
	@Test
	void invalidTestForGetStaffByCountry() {
		String country = "asdf";
		when(sservice.getStaffByCountry(country)).thenThrow(NotFoundException.class);
		
		assertThrows(NotFoundException.class, ()->{scontroller.getStaffByCountry(country);});
	}
	
	@Test
	void invalidTestForGetStaffByPhone() {
		String phone = "00000000000";
		when(sservice.getStaffByPhoneNumber(phone)).thenThrow(InvalidException.class);
		
		assertThrows(InvalidException.class, ()->{scontroller.getStaffByPhone(phone);});
	}
	
	@Test
	void invalidTestForGetStaffByPhoneWithLetter() {
		String phone = "000000a000";
		when(sservice.getStaffByPhoneNumber(phone)).thenThrow(InvalidException.class);
		
		assertThrows(InvalidException.class, ()->{scontroller.getStaffByPhone(phone);});
	}
	
	@Test
	void invalidTestForGetStaffByPhoneNotFound() {
		String phone = "1234567890";
		when(sservice.getStaffByPhoneNumber(phone)).thenThrow(NotFoundException.class);
		
		assertThrows(NotFoundException.class, ()->{scontroller.getStaffByPhone(phone);});
	}
}
