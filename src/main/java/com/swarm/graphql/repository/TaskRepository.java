package com.swarm.graphql.repository;

import org.springframework.data.repository.CrudRepository;

import com.swarm.graphql.model.Task;

public interface TaskRepository extends CrudRepository<Task, Long> {

}
