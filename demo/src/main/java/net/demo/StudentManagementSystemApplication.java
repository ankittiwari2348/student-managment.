package net.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.demo.entity.Student;
import net.demo.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public void run(String... args) throws Exception {
	
		/*
		 * // TODO Auto-generated method stub Student student1 =new Student student1=new
		 * Student("dinesh","tiwari","dinesh@gmail.com");
		 * studentRepository.save(student1);
		 * 
		 * Student student2 =new Student("ankit","tiwari","ankit@gmail.com");
		 * studentRepository.save(student2);
		 * 
		 * Student student3 =new Student("aman","tiwari","aman@gmail.com");
		 * studentRepository.save(student3);
		 */
	}

}
