package com.swarm.graphql.repository;

import org.springframework.data.repository.CrudRepository;

import com.swarm.graphql.model.Namespace;

public interface NamespaceRepository extends CrudRepository<Namespace, Long> {

}
