package com.luv2code.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	//below runs after the app starts
	@Bean
	public CommandLineRunner commandLineRunner(String[] args){
		//below is custom code for CommandLineRunner interface provided by Spring
		return runner -> {
			System.out.println("Hello World");
		};
	}

}
