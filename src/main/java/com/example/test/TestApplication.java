package com.example.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestApplication{
	
	private static final Logger logger = LogManager.getLogger(TestApplication.class);
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		logger.info("Running the App");
		SpringApplication.run(TestApplication.class, args);
		logger.info("App is running");
	}

}
