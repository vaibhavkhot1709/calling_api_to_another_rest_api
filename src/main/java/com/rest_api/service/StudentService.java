package com.rest_api.service;

import java.awt.List;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rest_api.model.Student;

@Service
public class StudentService {

//	@Autowired
//	RestTemplate restTemplate;
	@Value("${baseUrl}")
	String uri;
	
	RestTemplate restTemplate=new RestTemplate();

	public Student getStudentByRoll(int roll) {

		ResponseEntity<Student> entity = restTemplate.getForEntity(uri + roll, Student.class);
		
//	List l=restTemplate.getForObject(uri+roll, List.class);
	
		return entity.getBody();
	}


	
	public String deleteStudentByRoll(int roll) {

//		RestTemplate restTemplate=new RestTemplate();
		
		HttpHeaders headers=new HttpHeaders();
		
		HttpEntity<Student> entity=new HttpEntity(headers);
		
		return restTemplate.exchange(uri+roll, HttpMethod.DELETE, entity, String.class).getBody();
	}
	
	
	public String postStudent(Student student) {
		
//		RestTemplate restTemplate=new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList());
		HttpEntity<Student> entity = new HttpEntity<Student>(student,headers);
		
		
		return restTemplate.exchange(uri, HttpMethod.POST, entity, String.class).getBody();
	}

	public String updateById(Student student) {
		
//		RestTemplate restTemplate=new RestTemplate();
		
		HttpHeaders headers =new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Student> entity=new HttpEntity(student,headers);
		
		return restTemplate.exchange(uri, HttpMethod.PUT, entity, String.class).getBody();

	
	}

}
