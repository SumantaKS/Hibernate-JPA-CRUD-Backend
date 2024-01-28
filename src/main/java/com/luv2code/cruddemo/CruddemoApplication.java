package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Struct;
import java.util.List;

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

			//createMultipleStudents(studentDAO);

			//readStudent(studentDAO);

			//queryForStudents(studentDAO);

			//findByLastName(studentDAO);

			updateStudent(studentDAO);
		};
	}


	void createStudent(StudentDAO studentDAO){

		System.out.println("Creating student......");
		Student theStudent = new Student("Sumanta", "Singh", "singhsumanta@gmail.com");

		System.out.println("Saving student.....");
		studentDAO.save(theStudent);

		System.out.println("Getting student id.... Student ID: " + theStudent.getId());

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

	private void readStudent(StudentDAO studentDAO){

		System.out.println("Creating the student....");
		Student theStudent4 = new Student("Lara", "Croft", "lara@gmail.com");

		System.out.println("Saving the student....");
		studentDAO.save(theStudent4);

		System.out.println("Getting id.... ID: " + theStudent4.getId());
		Integer studentId = theStudent4.getId();

		System.out.println("Getting the student by ID....");
		Student student = studentDAO.findById(studentId);
		System.out.println(student.toString());
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
		for(Student student : students){
			System.out.println(student);
		}
	}

	private void findByLastName(StudentDAO studentDAO){
		List<Student> students = studentDAO.findByLastName("Drake");
		for(Student student : students){
			System.out.println(student);
		}

	}

	private void updateStudent(StudentDAO studentDAO) {

		Integer studentId = 1;
		Student student = studentDAO.findById(studentId);
		System.out.println("Finding student by ID.....");

		System.out.println("Making changes.....");
		student.setFirstName("Sully");

		System.out.println("Updating the student in the database...");
		studentDAO.update(student);
		System.out.println(student);
	}
}
