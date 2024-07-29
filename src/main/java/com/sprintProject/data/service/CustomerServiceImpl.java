package com.sprintProject.data.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprintProject.data.entity.Actor;
import com.sprintProject.data.entity.Address;
import com.sprintProject.data.entity.Customer;
import com.sprintProject.data.entity.Staff;
import com.sprintProject.data.entity.Store;
import com.sprintProject.data.exception.InvalidException;
import com.sprintProject.data.exception.NotFoundException;
import com.sprintProject.data.exception.NullClassException;
import com.sprintProject.data.repository.AddressRepository;
import com.sprintProject.data.repository.CustomerRepository;
import com.sprintProject.data.repository.StoreRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository crepo;
	
	@Autowired
	StoreRepository srepo;
	
	@Autowired
	AddressRepository addrepo;
	
	
	@Override
	public List<Customer> getCustomerByLastname(String last_name) throws NotFoundException{
		List<Customer> check=crepo.getCustomerByLastname(last_name);
		if(check.isEmpty()) {
			throw new NotFoundException("Given customer lastname="+last_name+" does not exist");
		}
		
		for(int i=0;i<last_name.length();i++) {
			if((last_name.codePointAt(i)>=65 && last_name.codePointAt(i)<=90) || (last_name.codePointAt(i)>=97 && last_name.codePointAt(i)<=122)) {
				continue;
			}
			else {
				throw new InvalidException("Invalid customer name: character=" +last_name.charAt(i)+" is not allowed. Please enter valid name.");
			}
		}
		return crepo.getCustomerByLastname(last_name);
	}

	@Override
	public List<Customer> getCustomerByFirstname(String first_name) {
		List<Customer> check=crepo.getCustomerByFirstname(first_name);
		if(check.isEmpty()) {
			throw new NotFoundException("Given customer firstname="+first_name+" does not exist");
		}
		
		for(int i=0;i<first_name.length();i++) {
			if((first_name.codePointAt(i)>=65 && first_name.codePointAt(i)<=90) || (first_name.codePointAt(i)>=97 && first_name.codePointAt(i)<=122)) {
				continue;
			}
			else {
				throw new InvalidException("Invalid customer name : character=" +first_name.charAt(i)+" is not allowed. Please enter valid name.");
			}
		}
		return crepo.getCustomerByFirstname(first_name);
	}

	@Override
	public List<Customer> getCustomerByEmail(String email) {
		List<Customer> check=crepo.getCustomerByEmail(email);
		if(check.isEmpty()) {
			throw new NotFoundException("Given customer Email Id="+email+" does not exist");
		}
		return crepo.getCustomerByEmail(email);
	}

	@Override
	public List<Customer> getCustomerWhichAreActive() {
		return crepo.getCustomerWhichAreActive();
	}

	@Override
	public List<Customer> getCustomerWhichAreInActive() {
		return crepo.getCustomerWhichAreInActive();
	}

	@Override
	public List<Customer> getCustomerByPhoneNumber(String phone) {
		List<Customer> check=crepo.getCustomerByPhoneNumber(phone);
    	
		String ch=phone;
		if(ch.length()<10 || ch.length()>10) {
			throw new InvalidException("Invalid customer Phone : number of digits in phone must be 10");
		}
		for(int i=0;i<ch.length();i++) {
			if((ch.codePointAt(i)>=65 && ch.codePointAt(i)<=90) || (ch.codePointAt(i)>=97 && ch.codePointAt(i)<=122)) {
				throw new InvalidException("Invalid customer Phone: character=" +ch.charAt(i)+" is not allowed. It can only contain values from 0 to 1");
			}
			
		}
	
	
	if(check.isEmpty()==true) {
		throw new NotFoundException("Entered customer phone = "+phone+" is not available");
	}
		return crepo.getCustomerByPhoneNumber(phone);
	}

	@Override
	public List<Customer> getCustomerByCity(String city) {
		List<Customer> check=crepo.getCustomerByCity(city);
		if(check.isEmpty()) {
			throw new NotFoundException("Given customer city="+city+" does not exist");
		}
		return crepo.getCustomerByCity(city);
	}

	@Override
	public List<Customer> getCustomerByCountry(String country) {
		List<Customer> check=crepo.getCustomersByCountry(country);
		if(check.isEmpty()) {
			throw new NotFoundException("Given customer country="+country+" does not exist");
		}
		return crepo.getCustomersByCountry(country);
	}

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return crepo.save(customer);
	}

	   @Override
	    public Customer updateCustomerEmail(Customer cust, int id) {

	        Customer customer = crepo.findById(id).get();

	        customer.setEmail(cust.getEmail());
	        crepo.save(cust);
	        return cust;

	    }

	@Override
	public Customer updateCustomerLastName(String lastname, int id) {
		// TODO Auto-generated method stub
	
		for(int i=0;i<lastname.length();i++) {
			if((lastname.codePointAt(i)>=65 && lastname.codePointAt(i)<=90) || (lastname.codePointAt(i)>=97 && lastname.codePointAt(i)<=122)) {
				continue;
			}
			else {
				throw new InvalidException("Invalid Name: character=" +lastname.charAt(i)+" is not allowed");
			}
		}
		Customer s=crepo.findById(id).orElseThrow(()->new NotFoundException("Staff with id="+id+" does not exist"));
		s.setLast_name(lastname);
		crepo.save(s);
		return s;
	}

	@Override
	public Customer updateCustomerFirstName(String firstname, int id) {
		// TODO Auto-generated method stub
		for(int i=0;i<firstname.length();i++) {
			if((firstname.codePointAt(i)>=65 && firstname.codePointAt(i)<=90) || (firstname.codePointAt(i)>=97 && firstname.codePointAt(i)<=122)) {
				continue;
			}
			else {
				throw new InvalidException("Invalid Name: character=" +firstname.charAt(i)+" is not allowed");
			}
		}
		Customer s=crepo.findById(id).orElseThrow(()->new NotFoundException("Staff with id="+id+" does not exist"));
		s.setFirst_name(firstname);
		crepo.save(s);
		return s;
	}

	@Override
	public Customer updateCustomerAssignStoreToCustomer(int store_id, int cust_id) throws NotFoundException{
		// TODO Auto-generated method stub
		Customer customer=crepo.findById(cust_id).orElseThrow(()->new NotFoundException("Customer with id="+cust_id+" does not exist."));
		Store s=srepo.findById(store_id).orElseThrow(()-> new NotFoundException("Store with id="+store_id+" does not exist"));
		customer.setStore(s);
		crepo.save(customer);
		return customer;
	}
	
	@Override

	public Customer updateCustomerPhone(String phone, int id) throws NullClassException,NotFoundException{

		Customer customer = crepo.findById(id).orElseThrow(()->new NotFoundException("Given id="+id+" does not exist"));

		Address add = customer.getAddress();
		if(add.getAddress_Id()==0) {
			throw new NullClassException();
		}
		
    	
		String ch=phone;
		if(ch.length()<10 || ch.length()>10) {
			throw new InvalidException("Invalid Phone : number of digits in phone must be 10");
		}
		for(int i=0;i<ch.length();i++) {
			if((ch.codePointAt(i)>=65 && ch.codePointAt(i)<=90) || (ch.codePointAt(i)>=97 && ch.codePointAt(i)<=122)) {
				throw new InvalidException("Invalid Phone: character=" +ch.charAt(i)+" is not allowed. It can only contain values from 0 to 1");
			}
			
		}
	
	
		
		add.setPhone(phone);
		
		customer.setAddress(add);

		crepo.save(customer);

		return customer;

	}

	@Override
	public Customer updateCustomerAssignAddressToCustomer(int address_id, int cust_id) {
		// TODO Auto-generated method stub
		Customer customer=crepo.findById(cust_id).orElseThrow(()->new NotFoundException("Customer with id="+cust_id+" does not exist."));
		Address adds=addrepo.findById(address_id).orElseThrow(()-> new NotFoundException("Store with id="+address_id+" does not exist"));
		customer.setAddress(adds);
		crepo.save(customer);
		return customer ;
	}

	

	
	

	

}
