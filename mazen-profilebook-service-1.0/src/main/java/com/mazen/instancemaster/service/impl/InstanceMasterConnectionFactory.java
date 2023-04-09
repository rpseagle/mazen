package com.mazen.instancemaster.service.impl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.mazen.instancemaster.service.InstanceMasterConnectionService;


@Service
public class InstanceMasterConnectionFactory implements ApplicationContextAware {

	@Autowired
	private ApplicationContext context;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		
		this.context = applicationContext;
	}
	
	public InstanceMasterConnectionService getInstance(String type) {
		
		return (InstanceMasterConnectionService) context.getBean(type.toLowerCase());
	}
	

}
