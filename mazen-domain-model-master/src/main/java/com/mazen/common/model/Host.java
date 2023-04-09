package com.mazen.common.model;

import java.io.Serializable;
import java.util.Objects;

public class Host implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4514097571138169167L;
	
	private String hostName;
	private int portNo;
	private String userName;
	private String password;
	private String instanceName;
	private String privateIp;
	private String publicIp;
	private boolean sslEnabled;
	private String displayName;
	private Infrastructure infrastructure;
	
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public int getPortNo() {
		return portNo;
	}
	public void setPortNo(int portNo) {
		this.portNo = portNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getInstanceName() {
		return instanceName;
	}
	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}
	public String getPrivateIp() {
		return privateIp;
	}
	public void setPrivateIp(String privateIp) {
		this.privateIp = privateIp;
	}
	public String getPublicIp() {
		return publicIp;
	}
	public void setPublicIp(String publicIp) {
		this.publicIp = publicIp;
	}
	public boolean isSslEnabled() {
		return sslEnabled;
	}
	public void setSslEnabled(boolean sslEnabled) {
		this.sslEnabled = sslEnabled;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public Infrastructure getInfrastructure() {
		return infrastructure;
	}
	public void setInfrastructure(Infrastructure infrastructure) {
		this.infrastructure = infrastructure;
	}
	
	@Override
	public String toString() {
		return "Host [hostName=" + hostName + ", portNo=" + portNo + ", userName=" + userName + ", password=" + password
				+ ", instanceName=" + instanceName + ", privateIp=" + privateIp + ", publicIp=" + publicIp
				+ ", sslEnabled=" + sslEnabled + ", displayName=" + displayName + "]";
	}
	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hostName == null) ? 0 : hostName.hashCode());
		result = prime * result + portNo;
		return result;
		
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Host other = (Host) obj;
		return sslEnabled == other.sslEnabled;
	}
	
}
