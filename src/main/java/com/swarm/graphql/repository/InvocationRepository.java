package com.swarm.graphql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.swarm.graphql.model.Invocation;
import com.swarm.graphql.model.*;

public interface InvocationRepository extends CrudRepository<Invocation, Long> {
	
	@Query("Select i from Invocation i Where i.session.id = :sessionId and i.invoking.id = :invokingId and i.invoked.id = :invokedId")
	List<Invocation> findByMethods(@Param("sessionId") Long sessionId, @Param("invokingId") Long invokingId, @Param("invokedId") Long invokedId);

	@Query("Select count(i) from Invocation i where i.session = :session and (i.invoking = :method or i.invoked = :method)")
	int countInvocations(@Param("session") Session session, @Param("method") Method method);

	@Query("from Invocation as i where i.session = :session order by i.id")
	List<Invocation> findBySession(@Param("session") Session session);

	int countBySession(Session session);

	@Query("from Invocation as i where i.session.task = :task order by i.id")
	List<Invocation> findBySession(@Param("task") Task task);
	
	
	@Query("from Invocation as i Where i.session.task.product = :product")
	List<Invocation> findByProduct(@Param("product") Product product);

}
