package com.swarm.graphql.repository;

import org.springframework.data.repository.CrudRepository;

import com.swarm.graphql.model.Method;

public interface MethodRepository extends CrudRepository<Method, Long> {

}
