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

import com.sprintProject.data.entity.Staff;
import com.sprintProject.data.entity.Store;
import com.sprintProject.data.service.StaffService;

import com.sprintProject.data.service.StaffService;

@RestController
@RequestMapping("/api/staff")
public class StaffRestController {


	@Autowired

    StaffService sservice;

	@PostMapping("/post")
	public ResponseEntity<String> addstaff(@RequestBody Staff staff) {
		return new ResponseEntity<>("Record Created Successfully", HttpStatus.OK);

	}

    @GetMapping("/lastname/{ln}")

    public ResponseEntity<List<Staff>> getStaffByLastName(@PathVariable("ln") String ln){

        List<Staff> staff = sservice.getStaffByLastname(ln);

        return new ResponseEntity<List<Staff>>(staff, HttpStatus.OK);

    }

    

    @GetMapping("/firstname/{fn}")

    public ResponseEntity<List<Staff>> getStaffByFirstName(@PathVariable("fn") String ln){

        List<Staff> staff = sservice.getStaffByFirstname(ln);

        return new ResponseEntity<List<Staff>>(staff, HttpStatus.OK);

    }

    

    @GetMapping("/email/{email}")

    public ResponseEntity<List<Staff>> getStaffByEmail(@PathVariable("email") String email){

        List<Staff> staff = sservice.getStaffByEmail(email);

        return new ResponseEntity<List<Staff>>(staff, HttpStatus.OK);

    }

    

    @GetMapping("/city/{city}")

    public ResponseEntity<List<Staff>> getStaffByCity(@PathVariable("city") String city){

        List<Staff> staff = sservice.getStaffByCity(city);

        return new ResponseEntity<List<Staff>>(staff, HttpStatus.OK);

    }

    

    @GetMapping("/country/{country}")

    public ResponseEntity<List<Staff>> getStaffByCountry(@PathVariable("country") String country){

        List<Staff> staff = sservice.getStaffByCountry(country);

        return new ResponseEntity<List<Staff>>(staff, HttpStatus.OK);

    }

    

    @GetMapping("/phone/{phone}")

    public ResponseEntity<List<Staff>> getStaffByPhone(@PathVariable("phone") String phone){

        List<Staff> staff = sservice.getStaffByPhoneNumber(phone);

        return new ResponseEntity<List<Staff>>(staff, HttpStatus.OK);

    }
    
    @PutMapping("update/fn/{id}")
    public ResponseEntity<Staff> updatStaffFirstName(@RequestBody Staff staff,@PathVariable("id") int id){
    	Staff staffs=sservice.updateStaffByFirstName(id, staff);
    	return new ResponseEntity<Staff>(staffs,HttpStatus.OK);
    }
    
    @PutMapping("/update/ln/{id}")
    public ResponseEntity<Staff> updateLastNameOfStaff(@RequestBody Staff Staff,@PathVariable("id") int staffId ){
    return new ResponseEntity<Staff>(sservice.updateLastNameOfStaff(staffId, Staff), HttpStatus.CREATED);
    }

    @PutMapping("/update/email/{id}")

    public ResponseEntity<Staff> updateEmailOfStaff(@RequestBody Staff Staff,@PathVariable("id") int staffId ){

     

    return new ResponseEntity<Staff>(sservice.updateEmailOfStaff(staffId, Staff), HttpStatus.CREATED);

     

    }

 
}


