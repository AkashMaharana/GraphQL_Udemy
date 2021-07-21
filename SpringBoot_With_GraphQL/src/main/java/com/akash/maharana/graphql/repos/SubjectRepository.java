package com.akash.maharana.graphql.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akash.maharana.graphql.entity.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
