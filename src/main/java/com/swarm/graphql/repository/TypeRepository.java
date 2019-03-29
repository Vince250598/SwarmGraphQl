package com.swarm.graphql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.swarm.graphql.model.*;
public interface TypeRepository extends CrudRepository<Type, Long> {
	
	@Query("Select t from Type t Where t.session.id = :sessionId")
	List<Type> findBySessionId(@Param("sessionId") Long sessionId);

	List<Type> findBySession(@Param("session") Session session);
	
	@Query("Select t from Type t Where t.session.task = :task order by t.fullName")
	List<Type> findByTask(@Param("task") Task task);

	@Query("Select t.fullName from Type t Where t.session.task.product = :product group by fullName order by t.fullName")
	List<String> findFullNamesByProduct(@Param("product") Product product);

}
