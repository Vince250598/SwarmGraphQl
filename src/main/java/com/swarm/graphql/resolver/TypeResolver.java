package com.swarm.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.swarm.graphql.model.*;
import com.swarm.graphql.repository.*;

public class TypeResolver implements GraphQLResolver<Type> {
	private NamespaceRepository namespaceRepository;
	private SessionRepository sessionRepository;
	
	public TypeResolver(NamespaceRepository namespaceRepository, SessionRepository sessionRepository) {
        this.namespaceRepository = namespaceRepository;
        this.sessionRepository = sessionRepository;
    }
	
	public Namespace getNamespace(Type type) {
		return namespaceRepository.findOne(type.getNamespace().getId());
	}
	
	public Session getSession(Type type) {
		return sessionRepository.findOne(type.getNamespace().getId());
	}

}
