package com.sprintProject.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sprintProject.data.entity.Customer;
import com.sprintProject.data.entity.Staff;
import com.sprintProject.data.entity.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer>{
	
	@Query("select s from Store s where s.address.city.city=?1")
	//@Query("select s from Store s where s.address.address_Id in (select address_Id from Address a where a.city.city_Id = (select city_Id from City ci where ci.city=?1))")
	public List<Store> getStoresByCity(String city);
	
	@Query("select c from Store c where c.address.address_Id IN (select address_Id from Address a where a.city.city_Id IN (select city_Id from City ci where ci.country.country_id = (select country_id from Country cou where cou.country=?1)))")	
	public List<Store> getStoresByCountry(String country);
	
	@Query("select c from Store c where c.address.address_Id IN (select address_Id from Address a where a.phone=?1)")
	public List<Store> getStoresByPhone(String phone);
	
	
	@Query("select c from Staff c where c.store.store_id IN (select s.staff.staff_id from Store s where s.store_id=?1)")
	public Staff getManagerByStore(int id);
	
	@Query("SELECT s FROM Staff s WHERE s.store.id = :storeId")
    List<Staff> findAllStaffByStoreId(@Param("storeId") int storeId);
	
	@Query("SELECT c FROM Customer c WHERE c.store.id = :storeId")
	List<Customer> findAllCustomersByStoreId(@Param("storeId") int storeId);
	
}
