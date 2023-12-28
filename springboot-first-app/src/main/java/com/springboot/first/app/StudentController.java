package com.springboot.first.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //which control rest api and web api
public class StudentController {
@GetMapping("/student")
 public Student getStudent() {
	 return new Student("suresh","date");
	 //spring mvc internally uses httpMessageConvertor(jackson2 library) to convert the java object in json object.
 }

@GetMapping("/listofstudents")
public List<Student> getAllStudents(){
	List<Student> students=new ArrayList<>();
	students.add(new Student("ramesh","fadtare"));
	students.add(new Student("rahul","udgir"));
	students.add(new Student("suresh","Date"));
	students.add(new Student("pragati","deshmu  kh"));
	students.add(new Student("kalpak","pawar"));
	return students;
	}

@GetMapping("{FirstName}/{LastName}") //http://localhost:8080/ramesh/fadtare
//@PathVariable annotation //we bind the request url template path variable to the method url
public Student StudentPathVariable(@PathVariable("FirstName")String FirstName,
		@PathVariable("LastName") String LastName) {
	return new Student(FirstName,LastName);
}

//build rest api to handle query parameter
//http://localhost:8000/student?firstName="ramesh"
//@RequestParam annotation use to bind this web request parameter to method variable.

@GetMapping("/student/query")
public Student getQueryParameter(
		@RequestParam(name="FirstName") String FirstName,
		@RequestParam(name="LastName") String LastName
		) {
	return new Student(FirstName,LastName);
	
}


}
