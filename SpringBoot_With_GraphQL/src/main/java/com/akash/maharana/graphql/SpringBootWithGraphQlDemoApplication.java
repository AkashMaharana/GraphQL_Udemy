package com.akash.maharana.graphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.akash.maharana.graphql.query , com.akash.maharana.graphql.service , "
		+ "com.akash.maharana.graphql.resolver", "com.akash.maharana.graphql.mutation"})
@EntityScan("com.akash.maharana.graphql.entity")
@EnableJpaRepositories("com.akash.maharana.graphql.repos")
public class SpringBootWithGraphQlDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithGraphQlDemoApplication.class, args);
	}

}
