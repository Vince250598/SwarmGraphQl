package com.swarm.graphql.resolver.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.swarm.graphql.model.Session;
import com.swarm.graphql.repository.SessionRepository;

public class QuerySession  implements GraphQLQueryResolver{
	private SessionRepository sessionRepository;
	
	
	public QuerySession(SessionRepository sessionRepository) {
		// TODO Auto-generated constructor stub
		this.sessionRepository = sessionRepository;
	}

    public Iterable<Session> sessionsByTaskIdAndDeveloperId(Long taskId, Long developerId){
    	return sessionRepository.findByTaskAndDeveloper(taskId, developerId);
    }

}
