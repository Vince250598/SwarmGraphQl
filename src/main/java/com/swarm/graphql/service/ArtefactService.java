package com.swarm.graphql.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.swarm.graphql.model.Artefact;
import com.swarm.graphql.repository.ArtefactRepository;

import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotation.GraphQLApi;

@GraphQLApi
@Service
public class ArtefactService {
	
	private ArtefactRepository artefactRepository;
	
	public ArtefactService(ArtefactRepository artefactRepository) {
		this.artefactRepository = artefactRepository;
	}
	
	@GraphQLQuery
	public Iterable<Artefact> allArtefacts() {
        return artefactRepository.findAll();
    }
	
	@GraphQLQuery
	public Optional<Artefact> ArtefactById(Long artefactId) {
		return artefactRepository.findById(artefactId);
	}

}
