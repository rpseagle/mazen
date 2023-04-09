package com.mazen.profilebook.model.instancemaster.azureblob;

import com.mazen.profilebook.model.instancemaster.AbstractInstanceMaster;

public class AzureBlobInstanceMaster extends AbstractInstanceMaster {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3977255065158493706L;
	
	public AzureBlobInstanceConnectivity getConnectivity() {
		
		return (AzureBlobInstanceConnectivity) connectivity;
	}
	
	public void setConnectivity(AzureBlobInstanceConnectivity connectivity) {
		this.connectivity = connectivity;
	}

	@Override
	public String getType() {
		return "AzureBlobInstanceMaster";
	}
}
