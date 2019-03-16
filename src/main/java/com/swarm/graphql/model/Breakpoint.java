package com.swarm.graphql.model;

import javax.persistence.*;

@Entity
public class Breakpoint {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	@ManyToOne(optional = false)
	private Type type;

	String charStart;
	
	String charEnd;
	
	Integer lineNumber;
	
	public Breakpoint() {
	}
	
	public Breakpoint(Type type, String charStart, String charEnd, Integer lineNumber) {
		this.type = type;
		this.charStart = charStart;
		this.charEnd = charEnd;
		this.lineNumber = lineNumber;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getCharStart() {
		return charStart;
	}

	public void setCharStart(String charStart) {
		this.charStart = charStart;
	}

	public String getCharEnd() {
		return charEnd;
	}

	public void setCharEnd(String charEnd) {
		this.charEnd = charEnd;
	}

	public Integer getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(Integer lineNumber) {
		this.lineNumber = lineNumber;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Breakpoint breakpoint = (Breakpoint) o;

        return id.equals(breakpoint.id);
    }
	
	@Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
		return id + ": " + lineNumber;
	}

}
