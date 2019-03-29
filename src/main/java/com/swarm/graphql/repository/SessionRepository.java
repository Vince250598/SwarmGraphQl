package com.swarm.graphql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.swarm.graphql.model.Session;

public interface SessionRepository extends CrudRepository<Session, Long> {
	
	@Query("Select s from Session s Where task.id = :taskId and developer.id = :developerId ")
	List<Session> findByTaskAndDeveloper(@Param("taskId") Long taskId, @Param("developerId") Long developerId);
	
	@Query("Select s from Session s Where task.id = :taskId")
	List<Session> findByTask(@Param("taskId") Long taskId);

}
