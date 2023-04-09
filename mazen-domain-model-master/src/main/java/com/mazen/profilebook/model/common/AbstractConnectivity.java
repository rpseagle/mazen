package com.mazen.profilebook.model.common;

import java.io.Serializable;

import com.mazen.common.model.Host;


public abstract class AbstractConnectivity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 855004254357409378L;
	
	private Host host;

	public Host getHost() {
		return host;
	}

	public void setHost(Host host) {
		this.host = host;
	}

	@Override
	public String toString() {
		return "AbstractConnectivity [host=" + host + "]";
	}
	
	
	
	

}
