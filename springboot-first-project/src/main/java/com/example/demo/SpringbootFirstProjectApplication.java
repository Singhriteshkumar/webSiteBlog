package com.example.demo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.service.CategoryServiceImpl;

@SpringBootApplication
public class SpringbootFirstProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootFirstProjectApplication.class, args);
		System.out.println("Application Started");
		
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
