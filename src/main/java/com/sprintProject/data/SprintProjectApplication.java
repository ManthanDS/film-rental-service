package com.sprintProject.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.sprintProject.data.entity com.sprintProject.data.view")
public class SprintProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprintProjectApplication.class, args);
	}

}
