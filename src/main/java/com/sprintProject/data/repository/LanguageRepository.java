package com.sprintProject.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprintProject.data.entity.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer>{

}
