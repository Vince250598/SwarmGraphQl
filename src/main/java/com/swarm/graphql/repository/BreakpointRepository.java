package com.swarm.graphql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.swarm.graphql.model.Breakpoint;

public interface BreakpointRepository extends CrudRepository<Breakpoint, Long> {
	
	@Query("Select b from Breakpoint b Where b.type.session.task.id = :taskId order by b.lineNumber")
	List<Breakpoint> findByTaskId(@Param("taskId") Long taskId);

}
