package com.mazen.inframonitoring.model;

public class MonitoringMetrics {
	
	private String metricId;
	private String metricDisplayName;
	private String metricUOM;
	private String metricType;
	private String metricDimension;
	private String applicableComponents;
	private String thresholdCondition;
	private String warningThresholdValue;
	private String criticalThresholdValue;
	public String getMetricId() {
		return metricId;
	}
	public void setMetricId(String metricId) {
		this.metricId = metricId;
	}
	public String getMetricDisplayName() {
		return metricDisplayName;
	}
	public void setMetricDisplayName(String metricDisplayName) {
		this.metricDisplayName = metricDisplayName;
	}
	public String getMetricUOM() {
		return metricUOM;
	}
	public void setMetricUOM(String metricUOM) {
		this.metricUOM = metricUOM;
	}
	public String getMetricType() {
		return metricType;
	}
	public void setMetricType(String metricType) {
		this.metricType = metricType;
	}
	public String getMetricDimension() {
		return metricDimension;
	}
	public void setMetricDimension(String metricDimension) {
		this.metricDimension = metricDimension;
	}
	public String getApplicableComponents() {
		return applicableComponents;
	}
	public void setApplicableComponents(String applicableComponents) {
		this.applicableComponents = applicableComponents;
	}
	public String getThresholdCondition() {
		return thresholdCondition;
	}
	public void setThresholdCondition(String thresholdCondition) {
		this.thresholdCondition = thresholdCondition;
	}
	public String getWarningThresholdValue() {
		return warningThresholdValue;
	}
	public void setWarningThresholdValue(String warningThresholdValue) {
		this.warningThresholdValue = warningThresholdValue;
	}
	public String getCriticalThresholdValue() {
		return criticalThresholdValue;
	}
	public void setCriticalThresholdValue(String criticalThresholdValue) {
		this.criticalThresholdValue = criticalThresholdValue;
	}
	@Override
	public String toString() {
		return "MonitoringMetrics [metricId=" + metricId + ", metricDisplayName=" + metricDisplayName + ", metricUOM="
				+ metricUOM + ", metricType=" + metricType + ", metricDimension=" + metricDimension
				+ ", applicableComponents=" + applicableComponents + ", thresholdCondition=" + thresholdCondition
				+ ", warningThresholdValue=" + warningThresholdValue + ", criticalThresholdValue="
				+ criticalThresholdValue + "]";
	}
	
	

}
