package com.swarm.graphql.service;

import org.springframework.stereotype.Service;

import com.swarm.graphql.model.Invocation;
import com.swarm.graphql.repository.InvocationRepository;

import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotation.GraphQLApi;

@GraphQLApi
@Service
public class InvocationService {

	private InvocationRepository invocationRepository;
	
	public InvocationService(InvocationRepository invocationRepository) {
		this.invocationRepository = invocationRepository;
	}
	
	@GraphQLQuery
	public Iterable<Invocation> invocationsByMethods(Long sessionId, Long invokingId, Long invokedId){
    	return invocationRepository.findByMethods(sessionId, invokingId, invokedId);
    }
	
}
