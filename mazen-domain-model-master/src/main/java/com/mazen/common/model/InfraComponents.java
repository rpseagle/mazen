package com.mazen.common.model;

import java.util.List;

public class InfraComponents {
	
	private String instanceId;
	private String type;
	private List<Attributes> componentProperties;
	public String getInstanceId() {
		return instanceId;
	}
	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<Attributes> getComponentProperties() {
		return componentProperties;
	}
	public void setComponentProperties(List<Attributes> componentProperties) {
		this.componentProperties = componentProperties;
	}
	
	
	@Override
	public String toString() {
		return "InfraComponents [instanceId=" + instanceId + ", type=" + type + ", componentProperties="
				+ componentProperties + ", getInstanceId()=" + getInstanceId() + ", getType()=" + getType()
				+ ", getComponentProperties()=" + getComponentProperties() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
	

}
