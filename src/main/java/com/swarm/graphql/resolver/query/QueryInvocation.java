package com.swarm.graphql.resolver.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.swarm.graphql.model.*;
import com.swarm.graphql.repository.InvocationRepository;

public class QueryInvocation  implements GraphQLQueryResolver{
	
	private InvocationRepository invocationRepository;
	
	public QueryInvocation(InvocationRepository invocationRepository) {
		this.invocationRepository = invocationRepository;
	}
    
    public Iterable<Invocation> invocationsByMethods(Long sessionId, Long invokingId, Long invokedId){
    	return invocationRepository.findByMethods(sessionId, invokingId, invokedId);
    }

}
