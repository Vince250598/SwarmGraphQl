package com.swarm.graphql.repository;

import org.springframework.data.repository.CrudRepository;

import com.swarm.graphql.model.Developer;

public interface DeveloperRepository extends CrudRepository<Developer, Long> {

}
