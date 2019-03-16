package com.swarm.graphql.repository;

import org.springframework.data.repository.CrudRepository;

import com.swarm.graphql.model.Invocation;

public interface InvocationRepository extends CrudRepository<Invocation, Long> {

}
