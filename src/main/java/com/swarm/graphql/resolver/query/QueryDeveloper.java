package com.swarm.graphql.resolver.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.swarm.graphql.repository.DeveloperRepository;
import com.swarm.graphql.repository.SessionRepository;

public class QueryDeveloper  implements GraphQLQueryResolver{
	
	private DeveloperRepository developerRepository;
	
	public QueryDeveloper(DeveloperRepository developerRepository) {
		// TODO Auto-generated constructor stub
		this.developerRepository = developerRepository;
	}

}
