package com.mazen.instancemaster.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mazen.common.model.ResponseObject;
import com.mazen.instancemaster.service.InstanceMasterService;
import com.mazen.profilebook.model.instancemaster.AbstractInstanceMaster;
import com.mazen.utils.ResponseUtil;



@RestController
@RequestMapping("/instancemaster")
public class InstanceMasterController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(InstanceMasterController.class);
	
	@Autowired
	private InstanceMasterService instanceMasterService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/testconnection")
	public ResponseEntity<?> testConnection(@RequestBody AbstractInstanceMaster instanceMaster) {
		
		LOGGER.info(" Enter into @testConnection InstanceController");
		
		try {
			boolean connectionresult = instanceMasterService.testConnection(instanceMaster);
			return new ResponseEntity<ResponseObject<?>>(ResponseUtil.createSuccessResponse(connectionresult),HttpStatus.OK);
		}
		catch (Exception e) {
			LOGGER.error("Exception occured doing test connection", e);
			return new ResponseEntity<ResponseObject<?>>(ResponseUtil.createErrorResponse(e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}