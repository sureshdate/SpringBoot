package net.javaguide.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguide.sms.entity.Student;
import net.javaguide.sms.service.StudentService;

@Controller //this annotation specifies its a class of controller. in this class we write all rest apis.
public class StudentController {
	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	// handler method to handle list students and return mode and view

	//getiing all students from the database
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}
	
	//whenever we click on add student the this mapping will be done
	@GetMapping("/students/new")
    public String createStudentForm(Model model) {
		
		// create student object to hold student form data
		Student student=new Student();
		model.addAttribute("student",student);//object and attribute value
		return "create_student";
	}
	
	//when we click on submit then this mapping will be done
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	//THIS IS FOR GET STUDENT BY ID AFTER CLICK ON UPDATE FORM
	@GetMapping("/students/edit/{id}")
	public String editStudentform(@PathVariable Long id,Model model) {
		model.addAttribute("student",studentService.getStudentById(id));
		return "edit_student";
		
	}
	// this mapping is used for updating student by id
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id,@ModelAttribute("student") Student student) {
		
		// get student from database by id //set student in database by id
		Student existingStudent =studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		studentService.updateStudent(existingStudent);
		return "redirect:/students";
		
	}
	//this mapping  done for deleteing the student
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}





	

	

	
	
	
	
	
	
	
	
	
	
	
	

}
//SpringBean use only one constructor then u can omit autowired annotation.
//studentRepository provide crud methods crud methods.