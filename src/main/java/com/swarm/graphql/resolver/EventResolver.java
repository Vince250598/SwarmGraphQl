package com.swarm.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.swarm.graphql.model.*;
import com.swarm.graphql.repository.*;

public class EventResolver implements GraphQLResolver<Event> {
	private SessionRepository sessionRepository;
    private MethodRepository methodRepository;
    
    public EventResolver(SessionRepository sessionRepository, MethodRepository methodRepository) {
        this.sessionRepository = sessionRepository;
        this.methodRepository = methodRepository;
	}
	
	public Session getSession(Event event) {
		return sessionRepository.findOne(event.getSession().getId());
    }
    
    public Method getMethod(Event event) {
    	return methodRepository.findOne(event.getMethod().getId());
    }

}
