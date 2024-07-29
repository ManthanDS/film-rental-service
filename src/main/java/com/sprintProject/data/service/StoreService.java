package com.sprintProject.data.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.sprintProject.data.entity.Address;
import com.sprintProject.data.entity.Customer;
import com.sprintProject.data.entity.Staff;
import com.sprintProject.data.entity.Store;

public interface StoreService {
	public List<Store> getStoresByCity(String city);
	public List<Store> getStoresByCountry(String country);
	public List<Store> getStoresByPhone(String phone);
	
	public Staff getManagerByStore(int id);
	Store assignManagerToStore(int id, int staff_id);
	Store updatePhoneNumberOfStore(Store store, int id);
	Store addStore(Store store, int manager_staff_id);
	Store assignAddressToStore(int id, int address_id);
	public List<Staff> findAllStaffByStoreId(int storeId);
	public List<Customer> findAllCustomersByStoreId(int storeId);
	//put
	public Store createRental(Store store);
	 public Store updateStoreByAddress(int storeId,Address address);
	
}
