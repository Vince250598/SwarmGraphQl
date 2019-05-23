package com.swarm.graphql.service;

import org.springframework.stereotype.Service;

import com.swarm.graphql.repository.EventRepository;

import io.leangen.graphql.spqr.spring.annotation.GraphQLApi;

@GraphQLApi
@Service
public class EventService {
	
	private EventRepository eventRepository;
	
	public EventService(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}

}
