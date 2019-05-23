package com.swarm.graphql.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.swarm.graphql.model.Developer;

public interface DeveloperRepository extends CrudRepository<Developer, Long> {

	Developer findByNameAllIgnoringCase(@Param("name") String name);

	Page<Developer> findByName(@Param("name") String name, Pageable pageable);
}
