package com.swarm.graphql.resolver.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

public class Query implements GraphQLQueryResolver {
    
    public String hello() {
    	return "hello";
    }
}
