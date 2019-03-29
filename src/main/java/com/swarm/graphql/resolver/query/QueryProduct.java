package com.swarm.graphql.resolver.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.swarm.graphql.repository.ProductRepository;

public class QueryProduct implements GraphQLQueryResolver{
	
	private ProductRepository productRepository;
	
	public QueryProduct(ProductRepository productRepository) {
		// TODO Auto-generated constructor stub
		this.productRepository = productRepository;
	}

}
