package com.swarm.graphql.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.swarm.graphql.model.Method;
import com.swarm.graphql.model.Session;
import com.swarm.graphql.repository.MethodRepository;
import com.swarm.graphql.repository.SessionRepository;

import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotation.GraphQLApi;

@GraphQLApi
@Service
public class MethodService {
	
	private MethodRepository methodRepository;
	private SessionRepository sessionRepository;
	
	public MethodService(MethodRepository methodRepository, SessionRepository sessionRepository) {
		this.methodRepository = methodRepository;
		this.sessionRepository = sessionRepository;
	}
	
	@GraphQLQuery
	public Iterable<Method> methodsByTypeId(Long typeId){
    	return methodRepository.findByTypeId(typeId);
    }
    
	@GraphQLQuery
    public Iterable<Method> startingMethodsBySessionId(Long sessionId){
    	Optional<Session> session = sessionRepository.findById(sessionId);
    	return methodRepository.getStartingMethods(session);
    }
    
	@GraphQLQuery
    public Iterable<Method> endingMethodsBySessionId(Long sessionId){
    	Optional<Session> session = sessionRepository.findById(sessionId);
    	return methodRepository.getEndingMethods(session);
    }

}
