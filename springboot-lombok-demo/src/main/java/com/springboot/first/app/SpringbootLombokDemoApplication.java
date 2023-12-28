package com.springboot.first.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootLombokDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootLombokDemoApplication.class, args);
		Student student=new Student();
		student.setId(1);
		student.setFirstName("ramesh");
		student.setLastName("fadtare");
		
		System.out.println(student.getId());
		System.out.println(student.getFirstName());
		
	}

}
