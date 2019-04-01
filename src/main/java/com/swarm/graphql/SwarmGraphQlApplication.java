package com.swarm.graphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SwarmGraphQlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwarmGraphQlApplication.class, args);
	}
	
	public static void stop() {
		System.exit(0);
	}
	
}
