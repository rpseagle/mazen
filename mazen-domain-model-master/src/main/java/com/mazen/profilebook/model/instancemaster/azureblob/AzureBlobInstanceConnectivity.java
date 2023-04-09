package com.mazen.profilebook.model.instancemaster.azureblob;

import com.mazen.profilebook.model.common.AbstractConnectivity;

public class AzureBlobInstanceConnectivity extends AbstractConnectivity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7972396869147372376L;
	
	private String storageAccountName;
	private String accessKey;
	private String containerName;
	
	public String getStorageAccountName() {
		return storageAccountName;
	}
	public void setStorageAccountName(String storageAccountName) {
		this.storageAccountName = storageAccountName;
	}
	public String getAccessKey() {
		return accessKey;
	}
	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}
	public String getContainerName() {
		return containerName;
	}
	public void setContainerName(String containerName) {
		this.containerName = containerName;
	}
	
	@Override
	public String toString() {
		return "AzureBlobInstanceConnectivity [storageAccountName=" + storageAccountName + ", accessKey=" + accessKey
				+ ", containerName=" + containerName + "]";
	}
	
	
	
	
	

}
