package com.rest_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest_api.model.Student;
import com.rest_api.service.StudentService;

@RestController
@RequestMapping("/calling")
public class CallStudentController {

	@Autowired
	StudentService service;


	@GetMapping("/student/{roll}")
	public Student getStudentByRoll(@PathVariable("roll") int roll){
		return service.getStudentByRoll(roll);
	}

	
	@PostMapping("/student")
	public String postStudent(@RequestBody Student student){
		return service.postStudent(student);
	}
	
	
	@DeleteMapping("/student/{roll}")
	public String deleteStudentByRoll(@PathVariable("roll") int roll){
		return service.deleteStudentByRoll(roll);
	}
	
	
	
}
