package com.swarm.graphql.repository;

import org.springframework.data.repository.CrudRepository;

import com.swarm.graphql.model.Session;

public interface SessionRepository extends CrudRepository<Session, Long> {

}
