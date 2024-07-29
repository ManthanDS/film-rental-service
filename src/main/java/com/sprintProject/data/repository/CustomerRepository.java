	package com.sprintProject.data.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sprintProject.data.entity.Address;
import com.sprintProject.data.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	@Query("select c from Customer c where c.last_name=?1")
	List<Customer> getCustomerByLastname(String last_name);
	
	@Query("select c from Customer c where c.first_name=?1")
	List<Customer> getCustomerByFirstname(String first_name);
	
	@Query("select c from Customer c where c.email=?1")
	List<Customer> getCustomerByEmail(String email);
	
	@Query("select c from Customer c where c.active=1")
	List<Customer> getCustomerWhichAreActive();
	
	@Query("select c from Customer c where c.active=0")
	List<Customer> getCustomerWhichAreInActive();
	
	
	@Query("select c from Customer c where c.address.phone=?1")
	//@Query("select c from Customer c where c.address.address_Id = (select address_Id from Address a where a.phone=?1)")
	List<Customer> getCustomerByPhoneNumber(String phone);
	
	@Query("select c from Customer c where c.address.city.city=?1")
	//@Query("select c from Customer c where c.address.address_Id in (select address_Id from Address a where a.city.city_Id = (select city_Id from City ci where ci.city=?1))")
	List<Customer> getCustomerByCity(String city);
	
	@Query("select c from Customer c where c.address.city.country.country=?1")
	//@Query("select c from Customer c where c.address.address_Id IN (select address_Id from Address a where a.city.city_Id IN (select city_Id from City ci where ci.country.country_id = (select country_id from Country cou where cou.country=?1)))")
	List<Customer> getCustomersByCountry(String country);
	
	
	
	
}
