package com.swarm.graphql.repository;

import org.springframework.data.repository.CrudRepository;

import com.swarm.graphql.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
