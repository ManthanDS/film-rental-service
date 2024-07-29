package com.sprintProject.data.service;

import java.util.List;

import com.sprintProject.data.entity.Address;
import com.sprintProject.data.entity.Customer;
import com.sprintProject.data.entity.Store;

public interface CustomerService {
	public List<Customer> getCustomerByLastname(String last_name);
	public List<Customer> getCustomerByFirstname(String first_name);
	public List<Customer> getCustomerByEmail(String email);	
	public List<Customer> getCustomerWhichAreActive();
	public List<Customer> getCustomerWhichAreInActive();
	public List<Customer> getCustomerByPhoneNumber(String phone);
	public List<Customer> getCustomerByCity(String city);
	public List<Customer> getCustomerByCountry(String country);
	public Customer addCustomer(Customer customer);//not running
	Customer updateCustomerEmail(Customer cust, int id);
	Customer updateCustomerLastName(String lastname, int id);
	Customer updateCustomerFirstName(String lastname, int id);
	Customer updateCustomerAssignStoreToCustomer(int store,int cust_id);
	public Customer updateCustomerPhone(String phone, int id);
	public Customer updateCustomerAssignAddressToCustomer(int address_id,int cust_id);
}
