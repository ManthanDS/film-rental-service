package com.sprintProject.data.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprintProject.data.entity.Address;
import com.sprintProject.data.entity.Customer;
import com.sprintProject.data.entity.Staff;
import com.sprintProject.data.entity.Store;
import com.sprintProject.data.exception.InvalidException;
import com.sprintProject.data.exception.NotFoundException;
import com.sprintProject.data.repository.AddressRepository;
import com.sprintProject.data.repository.StaffRepository;
import com.sprintProject.data.repository.StoreRepository;

@Service
public class StoreServiceImpl implements StoreService{
	
	@Autowired
	StoreRepository srepo;
	
	@Autowired
	AddressRepository arepo;
	
	@Autowired
	StaffRepository staffRepo;
	
	@Override
	public List<Store> getStoresByCity(String city) throws NotFoundException{
		List<Store> check=srepo.getStoresByCity(city);
    	if(check.isEmpty()==true) {
    		throw new NotFoundException("Entered City = "+city+"  is not available");
    	}
		return srepo.getStoresByCity(city);
	}

	@Override
	public List<Store> getStoresByCountry(String country) throws NotFoundException{
		List<Store> check=srepo.getStoresByCountry(country);
    	if(check.isEmpty()==true) {
    		throw new NotFoundException("Entered City = "+country+"  is not available");
    	}
		return srepo.getStoresByCountry(country);
	}

	@Override
	public List<Store> getStoresByPhone(String phone) throws NotFoundException,InvalidException{
		List<Store> check=srepo.getStoresByPhone(phone);
    	
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
		return srepo.getStoresByPhone(phone);
	}

	@Override
	public Staff getManagerByStore(int id) {
		// TODO Auto-generated method stub
		Store check=srepo.findById(id).orElseThrow(()-> new NotFoundException("Store with id="+id+" does not exist"));
		return srepo.getManagerByStore(id);
	}

	@Override
	public Store assignAddressToStore(int id, int address_id) {
		// TODO Auto-generated method stub
		Store updateStore  = srepo.findById(id).get();
		Address address = arepo.findById(address_id).get();
		updateStore.setAddress(address);
		return srepo.save(updateStore);
	}

	@Override
	public Store addStore(Store store,int manager_staff_id) {
		// TODO Auto-generated method stub
		store.setStaff(staffRepo.findById(manager_staff_id).get());
		store.setLast_update(Timestamp.valueOf(LocalDateTime.now()));
		return srepo.save(store);
	}

	@Override
	public Store updatePhoneNumberOfStore(Store store,int id) {
		// TODO Auto-generated method stub
		Store updatePhoneOfStore = srepo.findById(id).get();
		updatePhoneOfStore.getAddress().setPhone(store.getAddress().getPhone());
		return srepo.save(updatePhoneOfStore);
	}

	@Override
	public Store assignManagerToStore(int id, int staff_id) {
		// TODO Auto-generated method stub
		Staff manager = staffRepo.findById(staff_id).get();
		Store updateManagerStore = srepo.findById(id).get();
		updateManagerStore.setStaff(manager);
		return srepo.save(updateManagerStore);
	}

	@Override
	public List<Staff> findAllStaffByStoreId(int storeId) throws NotFoundException{
		List<Staff> check=srepo.findAllStaffByStoreId(storeId);
    	if(check.isEmpty()==true) {
    		throw new NotFoundException("Entered City = "+storeId+"  is not available");
    	}
		return srepo.findAllStaffByStoreId(storeId);
	}

	@Override
	public List<Customer> findAllCustomersByStoreId(int storeId) throws NotFoundException{
		List<Customer> check=srepo.findAllCustomersByStoreId(storeId);
    	if(check.isEmpty()==true) {
    		throw new NotFoundException("Entered City = "+storeId+"  is not available");
    	}
		return srepo.findAllCustomersByStoreId(storeId);
	}

	@Override
	public Store createRental(Store store) {
		// TODO Auto-generated method stub
		return srepo.save(store);
	}

	@Override
	public Store updateStoreByAddress(int storeId, Address address) {
		// TODO Auto-generated method stub
		Store s=srepo.findById(storeId).orElseThrow(()->new NotFoundException("Store with id="+storeId+" does not exist"));
		s.setAddress(address);
		return s;
		
	}


}
