package com.sprintProject.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprintProject.data.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

}
