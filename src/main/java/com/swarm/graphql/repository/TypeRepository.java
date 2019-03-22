package com.swarm.graphql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.swarm.graphql.model.Type;

public interface TypeRepository extends CrudRepository<Type, Long> {
	
	@Query("Select t from Type t Where t.session.id = :sessionId")
	List<Type> findBySessionId(@Param("sessionId") Long sessionId);

}
