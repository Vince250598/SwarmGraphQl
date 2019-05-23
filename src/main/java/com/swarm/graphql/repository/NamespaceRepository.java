package com.swarm.graphql.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.swarm.graphql.model.Namespace;

public interface NamespaceRepository extends CrudRepository<Namespace, Long> {

	Namespace findByFullPath(@Param("fullPath") String fullPath);

}
