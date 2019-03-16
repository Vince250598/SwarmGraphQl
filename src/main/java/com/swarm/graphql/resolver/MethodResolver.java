package com.swarm.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.swarm.graphql.model.*;
import com.swarm.graphql.repository.*;

public class MethodResolver implements GraphQLResolver<Method> {
	private TypeRepository typeRepository;
    
    public MethodResolver(TypeRepository typeRepository) {
		this.typeRepository = typeRepository;
	}
	
	public Type getType(Method method) {
		return typeRepository.findOne(method.getType().getId());
	}

}
