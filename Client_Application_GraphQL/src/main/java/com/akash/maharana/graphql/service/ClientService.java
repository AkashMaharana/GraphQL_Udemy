package com.akash.maharana.graphql.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akash.maharana.graphql.request.CreateStudentRequest;
import com.akash.maharana.graphql.response.StudentResponse;

import graphql.kickstart.spring.webclient.boot.GraphQLRequest;
import graphql.kickstart.spring.webclient.boot.GraphQLResponse;
import graphql.kickstart.spring.webclient.boot.GraphQLWebClient;

@Service
public class ClientService {
	
	@Autowired
	GraphQLWebClient graphQLWebClient;
	
	public StudentResponse getStudent(Integer id) {
		String query="query{\r\n" + 
				"	  student(id : "+ id +"){\r\n" + 
				"			  id\r\n" + 
				"			  firstName\r\n" + 
				"			  lastName\r\n" + 
				"			  email\r\n" + 
				"			  street\r\n" + 
				"			  learningSubjects (subjectNameFilter : All) {\r\n" + 
				"	      		id\r\n" + 
				"	      		subjectName\r\n" + 
				"	      		marksObtained\r\n" + 
				"	    	}\r\n" + 
				"		}\r\n" + 
				"	}";
		
		GraphQLRequest request = GraphQLRequest.builder().query(query).build();
		GraphQLResponse graphQLResponse = graphQLWebClient.post(request).block();
		return graphQLResponse.get("student", StudentResponse.class);
	}
	
	public StudentResponse getStudentWithGraphQLVariable(Integer id) {
		Map<String,Object> variables=new HashMap<>();
		variables.put("id", id);
		String query="query student($id : Int){\r\n" + 
				"	  student(id : $id){\r\n" + 
				"			  id\r\n" + 
				"			  firstName\r\n" + 
				"			  lastName\r\n" + 
				"			  email\r\n" + 
				"			  street\r\n" + 
				"			  learningSubjects (subjectNameFilter : All) {\r\n" + 
				"	      		id\r\n" + 
				"	      		subjectName\r\n" + 
				"	      		marksObtained\r\n" + 
				"	    	}\r\n" + 
				"		}\r\n" + 
				"	}";
		
		GraphQLRequest request = GraphQLRequest.builder().query(query).variables(variables).build();
		GraphQLResponse graphQLResponse = graphQLWebClient.post(request).block();
		return graphQLResponse.get("student", StudentResponse.class);
	}
	
	public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {
		String mutation = "mutation{\r\n" + 
				"  createStudent(createStudentRequest : {\r\n" + 
				"    firstName : \"Akash\"\r\n" + 
				"    lastName : \"Maharana\"\r\n" + 
				"    email : \"akashmaharana93@gmail.com\"\r\n" + 
				"    street : \"R ourkela\"\r\n" + 
				"    city : \"Sundargadh\"\r\n" + 
				"		subjectsLearning : [\r\n" + 
				"      {\r\n" + 
				"        subjectName : \"Math\"\r\n" + 
				"        marksObtained : 93\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  }) {\r\n" + 
				"    id\r\n" + 
				"    firstName\r\n" + 
				"    lastName\r\n" + 
				"    email\r\n" + 
				"    street\r\n" + 
				"    city\r\n" + 
				"    learningSubjects(subjectNameFilter : All) {\r\n" + 
				"      id\r\n" + 
				"      subjectName\r\n" + 
				"      marksObtained\r\n" + 
				"    }\r\n" + 
				"  }\r\n" + 
				"}";
		
		GraphQLRequest request = GraphQLRequest.builder().query(mutation).build();
		GraphQLResponse graphQLResponse = graphQLWebClient.post(request).block();
		return graphQLResponse.get("createStudent", StudentResponse.class);
		
	}
}
