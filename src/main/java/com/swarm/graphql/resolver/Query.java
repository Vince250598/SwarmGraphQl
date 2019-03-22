package com.swarm.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.swarm.graphql.model.*;
import com.swarm.graphql.repository.*;

public class Query implements GraphQLQueryResolver {
    private SessionRepository sessionRepository;
    private DeveloperRepository developerRepository;
    private TaskRepository taskRepository;
    private ProductRepository productRepository;
    private NamespaceRepository namespaceRepository;
    private TypeRepository typeRepository;
    private BreakpointRepository breakpointRepository;
    private MethodRepository methodRepository;
    private InvocationRepository invocationRepository;
    private EventRepository eventRepository;

    public Query(DeveloperRepository developerRepository, 
    		SessionRepository sessionRepository, 
    		TaskRepository taskRepository, 
    		ProductRepository productRepository,
    		NamespaceRepository namespaceRepository,
    		TypeRepository typeRepository,
    		BreakpointRepository breakpointRepository,
    		MethodRepository methodRepository,
    		InvocationRepository invocationRepository,
    		EventRepository eventRepository) {
    	
        this.developerRepository = developerRepository;
        this.sessionRepository = sessionRepository;
        this.taskRepository = taskRepository;
        this.productRepository = productRepository;
        this.namespaceRepository = namespaceRepository;
        this.typeRepository = typeRepository;
        this.breakpointRepository = breakpointRepository;
        this.methodRepository = methodRepository;
        this.invocationRepository = invocationRepository;
        this.eventRepository = eventRepository;
    }
    
    // Breakpoint
    
    public Iterable<Breakpoint> allBreakpoints() {
        return breakpointRepository.findAll();
    }
    
    public Iterable<Breakpoint> breakpointsByTaskId(Long taskId){
		return breakpointRepository.findByTaskId(taskId);
    }
    
    // Task
    
    public Iterable<Task> allTasks() {
        return taskRepository.findAll();
    }
    
    // Type
    
    public Iterable<Type> typesBySessionId(Long sessionId){
    	return typeRepository.findBySessionId(sessionId);
    }
}
