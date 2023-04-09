package com.mazen.service.instancemaster.azureblob;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.mazen.exception.InstanceMasterException;
import com.mazen.instancemaster.service.InstanceMasterConnectionService;
import com.mazen.profilebook.model.common.AbstractConnectivity;
import com.mazen.profilebook.model.instancemaster.azureblob.AzureBlobInstanceConnectivity;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageCredentialsAccountAndKey;



@Lazy
@Service(value = "azureblobinstancemaster")
public class AzureBlobInstanceConnection extends InstanceMasterConnectionService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AzureBlobInstanceConnection.class);
	
	@Override
	public boolean testConnection(AbstractConnectivity connectivity, String type) throws InstanceMasterException {
		
		LOGGER.info("Enter @testConnection of AzureBlob Instance ::" + type);
		
		if(connectivity instanceof AzureBlobInstanceConnectivity) {
			
			AzureBlobInstanceConnectivity azureBlobInstanceConnectivity = (AzureBlobInstanceConnectivity) connectivity;
			
			try {
				StorageCredentialsAccountAndKey storageCredentials = new StorageCredentialsAccountAndKey(azureBlobInstanceConnectivity.getStorageAccountName(),azureBlobInstanceConnectivity.getAccessKey());
				CloudStorageAccount storageAccount = new CloudStorageAccount(storageCredentials);
				storageAccount.createCloudBlobClient();
				LOGGER.info("Azure Blob Instance Connected Successfully");
			return true;
			}
			catch (Exception e) {
				LOGGER.error("Error While Connected Azure Blob Instance", e);
				e.printStackTrace();
				return false;
			}
		}

		return false;
	}	

}
