package com.rest_api.service;

import java.awt.PageAttributes.MediaType;
import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rest_api.model.Student;

@Service
public class StudentService {

//	@Autowired
//	RestTemplate restTemplate;
	final String uri = "http://localhost:8080/student/";

	public Student getStudentByRoll(int roll) {
		RestTemplate restTemplate=new RestTemplate();

		ResponseEntity<Student> entity = restTemplate.getForEntity(uri + roll, Student.class);

		return entity.getBody();
	}

	public String postStudent(Student student) {

		RestTemplate restTemplate=new RestTemplate();
		
		  HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList());
	      HttpEntity<Student> entity = new HttpEntity<Student>(student,headers);
	    
		
		return restTemplate.exchange(uri, HttpMethod.POST, entity, String.class).getBody();
	}

}
