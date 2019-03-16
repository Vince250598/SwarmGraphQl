package com.swarm.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.swarm.graphql.model.Product;
import com.swarm.graphql.model.Task;
import com.swarm.graphql.repository.ProductRepository;

public class TaskResolver implements GraphQLResolver<Task> {
	private ProductRepository productRepository;
	
	public TaskResolver(ProductRepository productRepository) {
        this.productRepository = productRepository;
	}

    public Product getProduct(Task task) {
        return productRepository.findOne(task.getProduct().getId());
    }

}
