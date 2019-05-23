package com.swarm.graphql.service;

import org.springframework.stereotype.Service;

import com.swarm.graphql.model.Developer;
import com.swarm.graphql.repository.DeveloperRepository;

import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotation.GraphQLApi;

@GraphQLApi
@Service
public class DeveloperService {

	private DeveloperRepository developerRepo;
	
	public DeveloperService(DeveloperRepository developerRepo) {
		this.developerRepo = developerRepo;
	}
	
	@GraphQLQuery
	public Iterable<Developer> allDevelopers() {
		return developerRepo.findAll();
	}
		
}
