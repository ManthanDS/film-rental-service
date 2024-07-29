package com.sprintProject.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprintProject.data.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

}