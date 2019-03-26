package com.swarm.graphql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.swarm.graphql.model.Invocation;

public interface InvocationRepository extends CrudRepository<Invocation, Long> {
	
	@Query("Select i from Invocation i Where i.session.id = :sessionId and i.invoking.id = :invokingId and i.invoked.id = :invokedId")
	List<Invocation> findByMethods(@Param("sessionId") Long sessionId, @Param("invokingId") Long invokingId, @Param("invokedId") Long invokedId);

}
