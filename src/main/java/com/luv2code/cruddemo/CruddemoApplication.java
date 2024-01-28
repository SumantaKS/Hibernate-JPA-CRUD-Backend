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
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
		};
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating multiple student......");
		Student theStudent1 = new Student("Sumanta", "Singh", "singhsumanta@gmail.com");
		Student theStudent2 = new Student("Nathan", "Drake", "athief@gmail.com");
		Student theStudent3 = new Student("Sam", "Drake", "bigbro@gmail.com");

		System.out.println("Saving the students.....");
		studentDAO.save(theStudent1);
		studentDAO.save(theStudent2);
		studentDAO.save(theStudent3);

		System.out.println("Getting student ids....");
		System.out.println("Student ID " + theStudent1.getId() + ": " + theStudent1.getFirstName() + " " + theStudent1.getLastName() );
		System.out.println("Student ID " + theStudent2.getId() + ": " + theStudent2.getFirstName() + " " + theStudent2.getLastName() );
		System.out.println("Student ID " + theStudent3.getId() + ": " + theStudent3.getFirstName() + " " + theStudent3.getLastName() );
	}

	void createStudent(StudentDAO studentDAO){

		System.out.println("Creating student......");
		Student theStudent = new Student("Sumanta", "Singh", "singhsumanta@gmail.com");

		System.out.println("Saving student.....");
		studentDAO.save(theStudent);

		System.out.println("Getting student id.... Student ID: " + theStudent.getId());

	}
}
