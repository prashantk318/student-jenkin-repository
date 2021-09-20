package com.prashant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.prashant.entity.Student;
import com.prashant.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Student student1 = new Student( "Prashant", "kalshetti","prashantk318@gmail.com");
		studentRepository.save(student1);
		Student student2 = new Student( "Rohit", "kalshetti","rohitk318@gmail.com");
		studentRepository.save(student2);
		Student student3 = new Student( "Sneha", "kalshetti","Sneha318@gmail.com");
		studentRepository.save(student3);
		Student student4 = new Student( "Abhi", "kalshetti","Abhi18@gmail.com");
		studentRepository.save(student4);
		
		
	}

}
