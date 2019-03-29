package com.swarm.graphql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.swarm.graphql.model.Breakpoint;
import com.swarm.graphql.model.*;

public interface BreakpointRepository extends CrudRepository<Breakpoint, Long> {
	
	@Query("Select b from Breakpoint b Where b.type = :type order by b.lineNumber")
	List<Breakpoint> findByType(@Param("type") Type type);
	
	@Query("Select b from Breakpoint b Where b.type.session.task = :task and b.type.fullName = :fullName order by b.lineNumber")
	List<Breakpoint> findByTaskAndType(@Param("task") Task task, @Param("fullName") String fullName);

	@Query("Select b from Breakpoint b Where b.type.fullName = :fullName order by b.lineNumber")
	List<Breakpoint> findByTypeFullName(@Param("fullName") String fullName);
	
	@Query("Select count(b) from Breakpoint b Where b.type.session.task = :task and b.type.fullName = :fullName")
	int countByTaskAndType(@Param("task") Task task, @Param("fullName") String fullName);
	
	int countByType(Type type);

	@Query("Select b from Breakpoint b Where b.type.session.task.id = :taskId order by b.lineNumber")
	List<Breakpoint> findByTaskId(@Param("taskId") Long taskId);
	
	@Query("Select b from Breakpoint b Where b.type.session.task.product = :product order by b.lineNumber")
	List<Breakpoint> findByProduct(@Param("product") Product product);

}
