package com.sprintProject.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sprintProject.data.entity.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer>{
	@Query("select c from Staff c where c.last_name=?1")

    List<Staff> getByLastName(String ln);

    

    @Query("select c from Staff c where c.first_name=?1")

    List<Staff> getByFirstName(String fn);

    

    @Query("select c from Staff c where c.email=?1")

    List<Staff> getByEmail(String email);

    

    @Query("select c from Staff c where c.address.address_Id in (select address_Id from Address a where a.city.city_Id = (select city_Id from City ci where ci.city=?1))")

    List<Staff> getByCity(String city);

    

    @Query("select c from Staff c where c.address.address_Id IN (select address_Id from Address a where a.city.city_Id IN (select city_Id from City ci where ci.country.country_id = (select country_id from Country cou where cou.country=?1)))")

    List<Staff> getByCountry(String country);

    

    @Query("select c from Staff c where c.address.address_Id=(select address_Id from Address a where a.phone=?1)")

    List<Staff> getByPhone(String phone);

}
