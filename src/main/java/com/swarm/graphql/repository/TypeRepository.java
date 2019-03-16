package com.swarm.graphql.repository;

import org.springframework.data.repository.CrudRepository;

import com.swarm.graphql.model.Type;

public interface TypeRepository extends CrudRepository<Type, Long> {

}
