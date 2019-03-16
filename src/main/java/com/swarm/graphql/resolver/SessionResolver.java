package com.swarm.graphql.resolver;


import com.coxautodev.graphql.tools.GraphQLResolver;
import com.swarm.graphql.model.*;
import com.swarm.graphql.repository.*;

public class SessionResolver implements GraphQLResolver<Session> {
    private DeveloperRepository developerRepository;
    private TaskRepository taskRepository;

    public SessionResolver(DeveloperRepository developerRepository, TaskRepository taskRepository) {
        this.developerRepository = developerRepository;
        this.taskRepository = taskRepository;
    }

    public Developer getDeveloper(Session session) {
        return developerRepository.findOne(session.getDeveloper().getId());
    }
    
    public Task getTask(Session session) {
        return taskRepository.findOne(session.getTask().getId());
    }
}
