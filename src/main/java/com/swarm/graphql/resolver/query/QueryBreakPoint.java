package com.swarm.graphql.resolver.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.swarm.graphql.model.Breakpoint;
import com.swarm.graphql.repository.BreakpointRepository;

public class QueryBreakPoint  implements GraphQLQueryResolver{

	private BreakpointRepository breakpointRepository;
	
	public QueryBreakPoint(BreakpointRepository breakpointRepository) {
		// TODO Auto-generated constructor stub
		this.breakpointRepository = breakpointRepository;
	}
	
	
    public Iterable<Breakpoint> allBreakpoints() {
        return breakpointRepository.findAll();
    }
    
    public Iterable<Breakpoint> breakpointsByTaskId(Long taskId){
		return breakpointRepository.findByTaskId(taskId);
    }
	
}
