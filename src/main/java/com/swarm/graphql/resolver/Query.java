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

    public Iterable<Session> findAllSessions() {
        return sessionRepository.findAll();
    }

    public Iterable<Developer> findAllDevelopers() {
        return developerRepository.findAll();
    }
    
    public Iterable<Task> findAllTasks() {
        return taskRepository.findAll();
    }
    
    public Iterable<Product> findAllProducts() {
        return productRepository.findAll();
    }
    
    public Iterable<Namespace> findAllNamespaces() {
        return namespaceRepository.findAll();
    }
    
    public Iterable<Type> findAllTypes() {
        return typeRepository.findAll();
    }
    
    public Iterable<Breakpoint> findAllBreakpoints() {
        return breakpointRepository.findAll();
    }
    
    public Iterable<Method> findAllMethods() {
        return methodRepository.findAll();
    }
    
    public Iterable<Invocation> findAllInvocations() {
        return invocationRepository.findAll();
    }
    
    public Iterable<Event> findAllEvents() {
        return eventRepository.findAll();
    }
}
