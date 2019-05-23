package com.swarm.graphql.repository;

import org.springframework.data.repository.CrudRepository;

import com.swarm.graphql.model.Artefact;

public interface ArtefactRepository extends CrudRepository<Artefact, Long> {

}
