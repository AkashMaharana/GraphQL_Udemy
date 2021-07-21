package com.akash.maharana.graphql.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.akash.maharana.graphql.request.SampleRequest;
import com.akash.maharana.graphql.response.StudentResponse;
import com.akash.maharana.graphql.service.StudentService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class Query implements GraphQLQueryResolver{
	
	@Autowired
	StudentService studenService;
	
	public String firstQuery() {
		return "First Query";
	}
	
	public String fullName(String firstName, String lastName) {
		return firstName+" "+lastName;
	}
	
	/*
	query{ 
		fullNameWithSampleRequest(
				sampleRequest : { 
					firstName : "Akash"
					lastName : "Maharana" 
				}
			) 
		}
	 */
	public String fullNameWithSampleRequest(SampleRequest sampleRequest) {
		return sampleRequest.getFirstName()+" "+sampleRequest.getLastName();
	}
	
	/*
	query{
	  student(id : 1){
			  id
			  firstName
			  lastName
			  email
			  street
			  learningSubjects{
	      		id
	      		subjectName
	      		marksObtained
	    	}
		}
	}
	*/
	public StudentResponse student(long id) {
		return new StudentResponse(studenService.getStudentById(id));
	}

}
