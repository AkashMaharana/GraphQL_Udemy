package com.akash.maharana.graphql.resolver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.akash.maharana.graphql.entity.Subject;
import com.akash.maharana.graphql.enums.SubjectNameFilter;
import com.akash.maharana.graphql.response.StudentResponse;
import com.akash.maharana.graphql.response.SubjectResponse;
import com.coxautodev.graphql.tools.GraphQLResolver;

@Service
public class StudentResponseResolver implements GraphQLResolver<StudentResponse> {

	public List<SubjectResponse> getLearningSubjects(StudentResponse studentResponse,
			SubjectNameFilter subjectNameFilter) {
		List<SubjectResponse> learningSubjects = new ArrayList<SubjectResponse>();
		if (studentResponse.getStudent().getLearningSubjects() != null) {
			for (Subject subject : studentResponse.getStudent().getLearningSubjects()) {
				if(subjectNameFilter.name().equalsIgnoreCase("ALL")) {
					learningSubjects.add(new SubjectResponse(subject));
				}else if(subjectNameFilter.name().equalsIgnoreCase(subject.getSubjectName())) {
					learningSubjects.add(new SubjectResponse(subject));
				}
			}
		}
		return learningSubjects;
	}

}
