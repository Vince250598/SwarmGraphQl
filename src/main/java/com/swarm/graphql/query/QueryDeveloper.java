package com.swarm.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.swarm.graphql.repository.DeveloperRepository;
import com.swarm.graphql.repository.SessionRepository;

public class QueryDeveloper  implements GraphQLQueryResolver{
	
	private DeveloperRepository developerRepository;
	
	public QueryDeveloper(DeveloperRepository developerRepository) {
		this.developerRepository = developerRepository;
	}

}
