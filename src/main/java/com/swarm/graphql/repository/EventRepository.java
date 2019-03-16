package com.swarm.graphql.repository;

import org.springframework.data.repository.CrudRepository;

import com.swarm.graphql.model.Event;

public interface EventRepository extends CrudRepository<Event, Long> {

}
