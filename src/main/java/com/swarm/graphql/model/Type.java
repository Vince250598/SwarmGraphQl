package com.swarm.graphql.model;

import javax.persistence.*;

@Entity
public class Type {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	@ManyToOne(optional = false)
	private Namespace namespace;
	
	@ManyToOne(optional = false)
	private Session session;

	String fullName;
	
	String fullPath;
	
	String name;
	
	String source;
	
	public Type() {
	}
	
	public Type(Namespace namespace, Session session, String fullName, String fullPath, String name, String source) {
		this.namespace = namespace;
		this.session = session;
		this.fullName = fullName;
		this.fullPath = fullPath;
		this.name = name;
		this.source = source;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Namespace getNamespace() {
		return namespace;
	}

	public void setNamespace(Namespace namespace) {
		this.namespace = namespace;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getFullPath() {
		return fullPath;
	}

	public void setFullPath(String fullPath) {
		this.fullPath = fullPath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Type type = (Type) o;

        return id.equals(type.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
		return id + ": " + fullName;
	}

}
