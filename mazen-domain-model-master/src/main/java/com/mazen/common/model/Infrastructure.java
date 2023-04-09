package com.mazen.common.model;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Infrastructure implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 184495395907068155L;
	
	@JsonProperty(value="isPartoCluster")
	private boolean isPartoCluster;
	private Cluster cluster;
	private List<Attributes> infraProperties;
	private List<InfraComponents> infraComponents;
	private List<MonitoringMetrics> monitoringMetrics;
	
	public boolean isPartoCluster() {
		return isPartoCluster;
	}
	public void setPartoCluster(boolean isPartoCluster) {
		this.isPartoCluster = isPartoCluster;
	}
	public Cluster getCluster() {
		return cluster;
	}
	public void setCluster(Cluster cluster) {
		this.cluster = cluster;
	}
	public List<Attributes> getInfraProperties() {
		return infraProperties;
	}
	public void setInfraProperties(List<Attributes> infraProperties) {
		this.infraProperties = infraProperties;
	}
	public List<InfraComponents> getInfraComponents() {
		return infraComponents;
	}
	public void setInfraComponents(List<InfraComponents> infraComponents) {
		this.infraComponents = infraComponents;
	}
	public List<MonitoringMetrics> getMonitoringMetrics() {
		return monitoringMetrics;
	}
	public void setMonitoringMetrics(List<MonitoringMetrics> monitoringMetrics) {
		this.monitoringMetrics = monitoringMetrics;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
