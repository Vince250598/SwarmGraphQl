package com.swarm.graphql.model;

import javax.persistence.*;

@Entity
public class Session {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

	@ManyToOne
	private Developer developer;
	
	@ManyToOne
	private Task task;
	
	String description;	

	String label;	
	
	String purpose;
	
	String project;
	
	public Session() {
	}
	
	public Session(Developer developer, Task task, String description, String label, String purpose, String project) {
		this.developer = developer;
		this.task = task;
		this.description = description;
		this.label = label;
		this.purpose = purpose;
		this.project = project;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Developer getDeveloper() {
		return developer;
	}

	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task project) {
		this.task = project;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Session session = (Session) o;

        return id.equals(session.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
		return id + ": " + description;
	}

}
