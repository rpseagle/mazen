package com.mazen.instancemaster.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mazen.common.model.Host;
import com.mazen.instancemaster.service.impl.InstanceMasterConnectionFactory;
import com.mazen.profilebook.model.instancemaster.AbstractInstanceMaster;



@Service
public class InstanceMasterService {

	private static final Logger LOGGER =LoggerFactory.getLogger(InstanceMasterService.class);
	
	@Autowired
	InstanceMasterConnectionFactory connection;
	
	public boolean testConnection(AbstractInstanceMaster instanceMaster) throws Exception {
		
		LOGGER.info("Enter @testConnection into Service :" + instanceMaster.getSupportType().getValue() );
		
		Host host = instanceMaster.getConnectivity().getHost();
		if(host != null) {
			host.setPassword(host.getPassword());
		}
		
		InstanceMasterConnectionService connectionService = connection.getInstance(instanceMaster.getType());
		
		return connectionService.testConnection(instanceMaster.getConnectivity(), instanceMaster.getSupportType().getValue());
	}
	

}
