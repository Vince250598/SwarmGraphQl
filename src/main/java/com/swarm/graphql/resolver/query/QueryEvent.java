package com.swarm.graphql.resolver.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.swarm.graphql.repository.EventRepository;

public class QueryEvent  implements GraphQLQueryResolver{

	private EventRepository eventRepository;

	public QueryEvent(EventRepository eventRepository) {
		 this.eventRepository = eventRepository;
	}
	
	
}
