package com.mazen.instancemaster.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mazen.common.model.Host;
import com.mazen.instancemaster.repository.InstanceMasterRepository;
import com.mazen.instancemaster.service.impl.InstanceMasterConnectionFactory;
import com.mazen.profilebook.model.instancemaster.AbstractInstanceMaster;



@Service
public class InstanceMasterService {

	private static final Logger LOGGER =LoggerFactory.getLogger(InstanceMasterService.class);
	
	@Autowired
	InstanceMasterConnectionFactory connection;
	
	@Autowired
	InstanceMasterRepository instanceMasterRepository;
	
	public boolean testConnection(AbstractInstanceMaster instanceMaster) throws Exception {
		
		LOGGER.info("Enter @testConnection into Service :" + instanceMaster.getSupportType().getValue() );
		
		Host host = instanceMaster.getConnectivity().getHost();
		if(host != null) {
			host.setPassword(host.getPassword());
		}
		
		InstanceMasterConnectionService connectionService = connection.getInstance(instanceMaster.getType());
		
		return connectionService.testConnection(instanceMaster.getConnectivity(), instanceMaster.getSupportType().getValue());
	}
	
	public AbstractInstanceMaster saveInstanceMaster(AbstractInstanceMaster instanceMaster) throws Exception {
		
		LOGGER.info("Enter @saveInstanceMaster");
		
		AbstractInstanceMaster exisAbstractInstanceMaster = findById(instanceMaster.getInstanceName());
		
		return instanceMasterRepository.save(instanceMaster);
		
		}

 	public AbstractInstanceMaster findById(String instanceName) {
 		
 		LOGGER.info("Enter into @findById Instance  by name "+ instanceName);
 		AbstractInstanceMaster instance = instanceMasterRepository.findById(instanceName).orElse(null);
 		LOGGER.info("Enter to get Instance" + instance);
 		return instance;
 	}
 	
 	public List<AbstractInstanceMaster> findAllInstance() throws Exception {
 		List<AbstractInstanceMaster> allInstances = instanceMasterRepository.findAll();
 		return allInstances;
 	}
 	
 	public void deleteInstance(String instanceName) {
 		
 		LOGGER.info("Enter into @deleteInstance Instance  by name "+ instanceName);
 		instanceMasterRepository.deleteById(instanceName);
 		LOGGER.info("Enter to deleted Instance" + instanceName);
 	}
 	
}