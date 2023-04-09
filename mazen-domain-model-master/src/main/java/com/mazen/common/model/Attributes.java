package com.mazen.common.model;

import java.io.Serializable;

public class Attributes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4362106530059972137L;
	
	private String name;
	private String value;
	
	public Attributes() {
		
	}

	public Attributes(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Attributes [name=" + name + ", value=" + value + "]";
	}
	
}
