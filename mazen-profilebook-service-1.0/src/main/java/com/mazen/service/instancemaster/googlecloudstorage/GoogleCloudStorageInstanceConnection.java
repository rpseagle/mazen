package com.mazen.service.instancemaster.googlecloudstorage;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.gson.Gson;
import com.mazen.exception.InstanceMasterException;
import com.mazen.instancemaster.service.InstanceMasterConnectionService;
import com.mazen.profilebook.model.common.AbstractConnectivity;
import com.mazen.profilebook.model.instancemaster.googlecloudstorage.GoogleCloudStorageInstanceConnectivity;

@Lazy
@Service(value = "googlecloudstorageinstancemaster")
public class GoogleCloudStorageInstanceConnection extends InstanceMasterConnectionService {

	private static final Logger LOGGER = LoggerFactory.getLogger(GoogleCloudStorageInstanceConnection.class);
	
	@Override
	public boolean testConnection(AbstractConnectivity connectivity, String type) throws InstanceMasterException {

		LOGGER.info("Enter into testConnection Method of GoogleCloudStorage Insatnce :"+ type);
		
		if(connectivity instanceof GoogleCloudStorageInstanceConnectivity) {
			
			GoogleCloudStorageInstanceConnectivity googleCloudStorageInstanceConnectivity = (GoogleCloudStorageInstanceConnectivity) connectivity;
			
			Gson gson = new Gson();
			String json = gson.toJson(googleCloudStorageInstanceConnectivity);
			InputStream is = new ByteArrayInputStream(json.getBytes());
			
			try
			{
				Storage cred = StorageOptions
						.newBuilder()
						.setCredentials(ServiceAccountCredentials.fromStream(is))
						.build()
						.getService();
				LOGGER.info("Google Cloud Storage Instance Connected Successfully");
				return true;
			}
			catch(IOException e)
			{
				LOGGER.error("Error While Connected Google Cloud Storage Instance", e);
				e.printStackTrace();
				return false;
			}
		}
		
		return false;
	}

	
}
