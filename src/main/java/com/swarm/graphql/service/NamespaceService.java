package com.swarm.graphql.service;

import org.springframework.stereotype.Service;

import com.swarm.graphql.model.Namespace;
import com.swarm.graphql.repository.NamespaceRepository;

import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotation.GraphQLApi;

@GraphQLApi
@Service
public class NamespaceService {
	
	private NamespaceRepository namespaceRepo;
	
	public NamespaceService(NamespaceRepository namespaceRepo) {
		this.namespaceRepo = namespaceRepo;
	}
	
	@GraphQLQuery
	public Namespace namespaceByFullPath(String fullPath){
    	return namespaceRepo.findByFullPath(fullPath);
    }

}
