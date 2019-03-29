package com.swarm.graphql.resolver.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.swarm.graphql.model.*;
import com.swarm.graphql.repository.TypeRepository;

public class QueryType  implements GraphQLQueryResolver{
	private TypeRepository typeRepository;


	public QueryType(TypeRepository typeRepository) {
		// TODO Auto-generated constructor stub
		this.typeRepository = typeRepository;
	}

    public Iterable<Type> typesBySessionId(Long sessionId){
    	return typeRepository.findBySessionId(sessionId);
    }
    
}
