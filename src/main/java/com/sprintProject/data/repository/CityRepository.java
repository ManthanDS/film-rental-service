package com.sprintProject.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprintProject.data.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

}