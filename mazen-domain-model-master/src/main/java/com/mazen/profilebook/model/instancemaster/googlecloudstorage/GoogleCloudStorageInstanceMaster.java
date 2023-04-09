package com.mazen.profilebook.model.instancemaster.googlecloudstorage;

import com.mazen.profilebook.model.instancemaster.AbstractInstanceMaster;

public class GoogleCloudStorageInstanceMaster extends AbstractInstanceMaster {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3977255065158493706L;
	
	public GoogleCloudStorageInstanceConnectivity getConnectivity() {
		
		return (GoogleCloudStorageInstanceConnectivity) connectivity;
	}
	
	public void setConnectivity(GoogleCloudStorageInstanceConnectivity connectivity) {
		this.connectivity = connectivity;
	}

	@Override
	public String getType() {
		return "GoogleCloudStorageInstanceMaster";
	}
}
