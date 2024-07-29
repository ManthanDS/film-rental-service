package com.sprintProject.data.service;

import java.util.Iterator;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprintProject.data.entity.Staff;
import com.sprintProject.data.entity.Store;
import com.sprintProject.data.exception.InvalidException;
import com.sprintProject.data.exception.NotFoundException;
import com.sprintProject.data.repository.StaffRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StaffServiceImpl implements StaffService{


	@Autowired
	StaffRepository srepo;

	    @Override
	    public List<Staff> getStaffByLastname(String ln) throws NotFoundException{
	    	List<Staff> check=srepo.getByLastName(ln);
	    	if(check.isEmpty()) {
	    		throw new NotFoundException("Entered Lastname = "+ln+"  is not present.");
	    	}
	        return srepo.getByLastName(ln);
	    }
	 
	    @Override
	    public List<Staff> getStaffByFirstname(String fn) throws NotFoundException{
	    	List<Staff> check=srepo.getByFirstName(fn);
	    	if(check.isEmpty()) {
	    		throw new NotFoundException("Entered Firstname = "+fn+"  is not present.");
	    	}
	        return srepo.getByFirstName(fn);
	    }
	 

	    @Override
	    public List<Staff> getStaffByEmail(String email) throws NotFoundException{
	    	List<Staff> check=srepo.getByEmail(email);
	    	if(check.isEmpty()) {
	    		throw new NotFoundException("Entered email_id = "+ email+"  is not present.");
	    	}
	        return srepo.getByEmail(email);
	    }

	    @Override
	    public List<Staff> getStaffByCity(String city) throws NotFoundException{
	    	List<Staff> check=srepo.getByCity(city);
	    	if(check.isEmpty()==true) {
	    		throw new NotFoundException("Entered City = "+city+"  is not available");
	    	}
	        return srepo.getByCity(city);
	    }
	 
	    @Override
	    public List<Staff> getStaffByCountry(String country) throws NotFoundException{
	    	List<Staff> check=srepo.getByCountry(country);
	    	if(check.isEmpty()==true) {
	    		throw new NotFoundException("Entered country = "+country+" is not available");
	    	}
	        return srepo.getByCountry(country);
	    }
	
	    @Override
	    public List<Staff> getStaffByPhoneNumber(String phone) throws NotFoundException,InvalidException{
	    	List<Staff> check=srepo.getByPhone(phone);
	    	
	    		String ch=phone;
	    		if(ch.length()<10 || ch.length()>10) {
	    			throw new InvalidException("Invalid Phone : number of digits in phone must be 10");
	    		}
	    		for(int i=0;i<ch.length();i++) {
					if((ch.codePointAt(i)>=65 && ch.codePointAt(i)<=90) || (ch.codePointAt(i)>=97 && ch.codePointAt(i)<=122)) {
						throw new InvalidException("Invalid Phone: character=" +ch.charAt(i)+" is not allowed. It can only contain values from 0 to 1");
					}
					
				}
	    	
	    	
	    	if(check.isEmpty()==true) {
	    		throw new NotFoundException("Entered phone = "+phone+" is not available");
	    	}
	        return srepo.getByPhone(phone);
	    }

		@Override
		public Staff updateStaffByFirstName(int id, Staff staff) throws NotFoundException{
			// TODO Auto-generated method stub
			
			String check=staff.getFirst_name();
			for(int i=0;i<staff.getFirst_name().length();i++) {
				if((check.codePointAt(i)>=65 && check.codePointAt(i)<=90) || (check.codePointAt(i)>=97 && check.codePointAt(i)<=122)) {
					continue;
				}
				else {
					throw new InvalidException("Invalid Name: character=" +check.charAt(i)+" is not allowed");
				}
			}
			Staff s=srepo.findById(id).orElseThrow(()->new NotFoundException("Staff with id="+id+" does not exist"));
			s.setFirst_name(staff.getFirst_name());
			return s;
		}
		
		@Override
		public Staff updateLastNameOfStaff(int StaffId, Staff Staff) throws NotFoundException,InvalidException{
			
			String check=Staff.getLast_name();
			for(int i=0;i<Staff.getLast_name().length();i++) {
				if((check.codePointAt(i)>=65 && check.codePointAt(i)<=90) || (check.codePointAt(i)>=97 && check.codePointAt(i)<=122)) {
					continue;
				}
				else {
					throw new InvalidException("Invalid Name: character=" +check.charAt(i)+" is not allowed");
				}
			}
			Staff s=srepo.findById(StaffId).orElseThrow(()->new NotFoundException("Staff with id="+StaffId+" does not exist"));
		s.setLast_name(Staff.getLast_name());
		return s;
		}

		@Override
		public Staff updateEmailOfStaff(int StaffId, Staff Staff) {
		Staff staffToUpdate=srepo.findById(StaffId).get();
		staffToUpdate.setEmail(Staff.getEmail());
		return staffToUpdate;

		}

		@Override
		public Staff createStaff(Staff staff) {
			// TODO Auto-generated method stub
			return srepo.save(staff);
			
		}
	
    

   
}
