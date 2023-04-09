package com.mazen.instancemaster.service;

import org.springframework.stereotype.Service;

import com.mazen.exception.InstanceMasterException;
import com.mazen.profilebook.model.common.AbstractConnectivity;


@Service
public abstract class InstanceMasterConnectionService {

	public abstract boolean testConnection(AbstractConnectivity connectivity,String type) throws InstanceMasterException;
	
}
