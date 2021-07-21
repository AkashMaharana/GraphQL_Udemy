package com.akash.maharana.graphql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akash.maharana.graphql.request.CreateStudentRequest;
import com.akash.maharana.graphql.response.StudentResponse;
import com.akash.maharana.graphql.service.ClientService;

@RestController
@RequestMapping("/api/student")
public class ClientController {
	
	@Autowired
	ClientService clientService;
	
	@GetMapping("/get/{id}")
	public StudentResponse getStudent(@PathVariable Integer id) {
		return clientService.getStudent(id);
	}
	
	@PostMapping("/create")
	public StudentResponse createStudent(@RequestBody CreateStudentRequest createStudentRequest) {
		return clientService.createStudent(createStudentRequest);
	}
}
