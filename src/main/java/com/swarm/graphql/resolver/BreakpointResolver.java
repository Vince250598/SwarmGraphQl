package com.swarm.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.swarm.graphql.model.*;
import com.swarm.graphql.repository.*;

public class BreakpointResolver implements GraphQLResolver<Breakpoint> {
	private TypeRepository typeRepository;
	
	public BreakpointResolver(TypeRepository typeRepository) {
		this.typeRepository = typeRepository;
	}
	
	public Type getType(Breakpoint breakpoint) {
		return typeRepository.findOne(breakpoint.getType().getId());
	}

}
