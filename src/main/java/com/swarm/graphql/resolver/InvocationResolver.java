package com.swarm.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.swarm.graphql.model.*;
import com.swarm.graphql.repository.*;

public class InvocationResolver implements GraphQLResolver<Invocation> {
	private SessionRepository sessionRepository;
    private MethodRepository methodRepository;
    
    public InvocationResolver(SessionRepository sessionRepository, MethodRepository methodRepository) {
        this.sessionRepository = sessionRepository;
        this.methodRepository = methodRepository;
	}
	
	public Session getSession(Invocation invocation) {
		return sessionRepository.findOne(invocation.getSession().getId());
    }
    
    public Method getMethodInvoked(Invocation invocation) {
    	return methodRepository.findOne(invocation.getInvoked().getId());
    }
    
    public Method getMethodInvoking(Invocation invocation) {
    	return methodRepository.findOne(invocation.getInvoking().getId());
    }

}
