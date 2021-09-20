package com.prashant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prashant.entity.Student;
import com.prashant.repository.StudentRepository;
import com.prashant.service.StudentService;

@Controller
public class StudentController {
	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	// handler method to handle list students and return mode and view
		@GetMapping("/students")
		public String listStudents(Model model) {
			model.addAttribute("students", studentService.getAllStudents());
			return "students";
		}
		
		@GetMapping("/students/new")
		public String createstudentForm(Model m) {
			//create student object to hold students data
			Student student  = new Student();
			m.addAttribute("student", student);
			
			return "create_student";
		}
		
		@PostMapping("/students")
		public String saveStudents(@ModelAttribute("student")Student student) {
			
		studentService.saveStudent(student);
		
		return "redirect:/students";
			
		}
		
		@GetMapping("/students/edit/{id}")
		public String editStudentForm(@PathVariable("id")Long id,Model m) {
			Student student1 = studentService.getStudentById(id);
			
			m.addAttribute("student", student1);
			return "edit_student";
		}
		
		@PostMapping("/students/{id}")
		public String updateStudent(@PathVariable Long id, @ModelAttribute("student")Student student, Model m) {
			//get students from database by id;
			
			Student existingStudents = studentService.getStudentById(id);
			
			existingStudents.setId(student.getId());
			existingStudents.setFirstName(student.getFirstName());
			existingStudents.setLastName(student.getLastName());
			existingStudents.setEmail(student.getEmail());
			
			//save updated student Objects
			
			 studentService.updateStudent(existingStudents);
			return "redirect:/students";
		}
		// handler method to handle delete student request
		
		@GetMapping("/students/{id}")
		public String deleteStudent(@PathVariable Long id) {
			studentService.deleteStudentById(id);
			return "redirect:/students";
		}
		
	
}
