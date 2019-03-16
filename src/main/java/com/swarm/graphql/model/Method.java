package com.swarm.graphql.model;

import javax.persistence.*;

@Entity
public class Method {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	@ManyToOne(optional = false)
	private Type type;

	String key;

	String name;

	String signature;
	
	public Method() {
	}
	
	public Method(Type type, String key, String name, String signature) {
		this.type = type;
		this.key = key;
		this.name = name;
		this.signature = signature;
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

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Method method = (Method) o;

        return id.equals(method.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
	
    @Override
	public String toString() {
		return type.getFullName() +"." +  this.name;
	}

}
