package com.mazen.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cluster {
	
	private String clusterID;
	private String clusterName;
	@JsonProperty(value="isLoadBalanced")
	private boolean isLoadBalanced;
	@JsonProperty(value="isAutoScalingEnabled")
	private boolean isAutoScalingEnabled;
	public String getClusterID() {
		return clusterID;
	}
	public void setClusterID(String clusterID) {
		this.clusterID = clusterID;
	}
	public String getClusterName() {
		return clusterName;
	}
	public void setClusterName(String clusterName) {
		this.clusterName = clusterName;
	}
	public boolean isLoadBalanced() {
		return isLoadBalanced;
	}
	public void setLoadBalanced(boolean isLoadBalanced) {
		this.isLoadBalanced = isLoadBalanced;
	}
	public boolean isAutoScalingEnabled() {
		return isAutoScalingEnabled;
	}
	public void setAutoScalingEnabled(boolean isAutoScalingEnabled) {
		this.isAutoScalingEnabled = isAutoScalingEnabled;
	}
	
	@Override
	public String toString() {
		return "Cluster [clusterID=" + clusterID + ", clusterName=" + clusterName + ", isLoadBalanced=" + isLoadBalanced
				+ ", isAutoScalingEnabled=" + isAutoScalingEnabled + ", getClusterID()=" + getClusterID()
				+ ", getClusterName()=" + getClusterName() + ", isLoadBalanced()=" + isLoadBalanced()
				+ ", isAutoScalingEnabled()=" + isAutoScalingEnabled() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	
}
