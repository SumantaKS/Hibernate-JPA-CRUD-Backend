package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		//below is custom code for CommandLineRunner interface provided by Spring
		return runner -> {
			createStudent(studentDAO);
		};
	}

	void createStudent(StudentDAO studentDAO){

		System.out.println("Creating student......");
		Student theStudent = new Student("Sumanta", "Singh", "singhsumanta@gmail.com");

		System.out.println("Saving student.....");
		studentDAO.save(theStudent);

		System.out.println("Getting student id.... Student ID: " + theStudent.getId());

	}
}
