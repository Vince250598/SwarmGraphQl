package com.swarm.graphql.model;

import javax.persistence.*;

@Entity
public class Invocation {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	@ManyToOne(optional = false)
	private Method invoking;

	@ManyToOne(optional = false)
	private Method invoked;

	@ManyToOne(optional = false)
	private Session session;
	
	public Invocation() {
	}
	
	public Invocation(Method invoking, Method invoked, Session session) {
		this.invoking = invoking;
		this.invoked = invoked;
		this.session = session;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Method getInvoking() {
		return invoking;
	}

	public void setInvoking(Method invoking) {
		this.invoking = invoking;
	}

	public Method getInvoked() {
		return invoked;
	}

	public void setInvoked(Method invoked) {
		this.invoked = invoked;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Invocation invocation = (Invocation) o;

        return id.equals(invocation.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
	
    @Override
	public String toString() {
		return invoking.getId() + ": " + invoking.getKey() + " -> " + invoked.getId() + ": " + invoked.getKey();
	}

}
