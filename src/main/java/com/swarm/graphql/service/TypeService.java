package com.swarm.graphql.service;

import org.springframework.stereotype.Service;

import com.swarm.graphql.model.Type;
import com.swarm.graphql.repository.TypeRepository;

import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotation.GraphQLApi;

@GraphQLApi
@Service
public class TypeService {

	private TypeRepository typeRepository;

	public TypeService(TypeRepository typeRepository) {
		this.typeRepository = typeRepository;
	}
	
	@GraphQLQuery
	public Iterable<Type> typesBySessionId(Long sessionId){
    	return typeRepository.findBySessionId(sessionId);
    }
	
}
