package com.akash.maharana.graphql.mutation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akash.maharana.graphql.request.CreateStudentRequest;
import com.akash.maharana.graphql.response.StudentResponse;
import com.akash.maharana.graphql.service.StudentService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

@Service
public class Mutation implements GraphQLMutationResolver{
	
	@Autowired
	StudentService studentService;
	
	/*
	mutation{
		  createStudent(createStudentRequest : {
		    firstName : "Akash"
		    lastName : "Maharana"
		    email : "akashmaharana93@gmail.com"
		    street : "Rourkela"
		    city : "Sundargadh"
				subjectsLearning : [
		      {
		        subjectName : "Math"
		        marksObtained : 93
		      }
		    ]
		  }) {
		    id
		    firstName
		    lastName
		    email
		    street
		    city
		    learningSubjects(subjectNameFilter : All) {
		      id
		      subjectName
		      marksObtained
		    }
		  }
		}
	*/
	public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {
		return new StudentResponse(studentService.createStudent(createStudentRequest));
	}
	
}
