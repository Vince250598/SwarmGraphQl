package com.swarm.graphql.resolver.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.swarm.graphql.model.Task;
import com.swarm.graphql.repository.TaskRepository;

public class QueryTask  implements GraphQLQueryResolver{
	
	private TaskRepository taskRepository;
	
	public QueryTask(TaskRepository taskRepository) {
		// TODO Auto-generated constructor stub
		this.taskRepository = taskRepository;
	}

    public Iterable<Task> allTasks() {
        return taskRepository.findAll();
    }
	

}
