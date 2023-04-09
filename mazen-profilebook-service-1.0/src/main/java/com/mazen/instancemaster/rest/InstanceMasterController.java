package com.mazen.instancemaster.rest;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(method=RequestMethod.POST, value = "/saveinstancemaster" )
	public ResponseEntity<?> saveInstanceMaster(@RequestBody AbstractInstanceMaster instanceMaster, BindingResult errors) {
		try {
			instanceMasterService.saveInstanceMaster(instanceMaster);
			return new ResponseEntity<ResponseObject<?>>(ResponseUtil.createSuccessResponse(instanceMaster),HttpStatus.OK);
		}
		catch (Exception e) {
			LOGGER.error("Exception occured while saving instancmaster");
			return new ResponseEntity<ResponseObject<?>>(ResponseUtil.createErrorResponse(e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{instanceName}")
	public ResponseEntity<?> findById(@PathVariable String instanceName) {
		LOGGER.info("Enter into @findById - InstanceMasterController");
		try {
			if(StringUtils.isEmpty(instanceName)) {
				LOGGER.info("Instance Name cannot be empty");
				return new ResponseEntity<ResponseObject<?>>(ResponseUtil.createErrorResponse("Instance Name cannot be empty"),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
			AbstractInstanceMaster instance = instanceMasterService.findById(instanceName);
			return new ResponseEntity<ResponseObject<?>>(ResponseUtil.createSuccessResponse(instance),HttpStatus.OK);
		}
		catch (Exception e) {
			LOGGER.error("Exception occured during finding InstanceMaster Information by Name", e);
			return new ResponseEntity<ResponseObject<?>>(ResponseUtil.createErrorResponse(e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/allinstance")
	public ResponseEntity<?> findAllInstance() {
		LOGGER.info(" Enter @findAllInstance - InstanceMasterController");
		try {
			List<AbstractInstanceMaster> instance = instanceMasterService.findAllInstance();
			return new ResponseEntity<ResponseObject<?>>(ResponseUtil.createSuccessResponse(instance),HttpStatus.OK);
		}
		catch (Exception e) {
			LOGGER.error("Exception occured during find all Instance Information", e);
			return new ResponseEntity<ResponseObject<?>>(ResponseUtil.createErrorResponse(e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{instanceName}")
	public ResponseEntity<?> deleteInstance(@PathVariable String instanceName) {
		LOGGER.info("Enter into @deleteInstance - InstanceMasterController");
		try {
			if(StringUtils.isEmpty(instanceName)) {
				LOGGER.info("Instance Name cannot be empty");
				return new ResponseEntity<ResponseObject<?>>(ResponseUtil.createErrorResponse("Instance Name cannot be empty"),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
			instanceMasterService.deleteInstance(instanceName);
			return new ResponseEntity<ResponseObject<?>>(ResponseUtil.createSuccessResponse("Deleted Instance" +instanceName),HttpStatus.OK);
		}
		catch (Exception e) {
			LOGGER.error("Exception occured during finding InstanceMaster Information by Name", e);
			return new ResponseEntity<ResponseObject<?>>(ResponseUtil.createErrorResponse(e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/doesNameExists/{instanceName}")
	public ResponseEntity<?> doesNameExists(@PathVariable String instanceName) {
		LOGGER.info("Enter into @doesNameExists - InstanceMasterController");
		try {
			AbstractInstanceMaster existingInstanceMaster = instanceMasterService.findById(instanceName);
			if(existingInstanceMaster != null) {
				LOGGER.info("Instance Name cannot be empty");
				return new ResponseEntity<ResponseObject<?>>(ResponseUtil.createSuccessResponse(true),HttpStatus.OK);
			}
			else {
				return new ResponseEntity<ResponseObject<?>>(ResponseUtil.createSuccessResponse(false),HttpStatus.OK);

			}
		}
		catch (Exception e) {
			LOGGER.error("Exception occured during Name Match InstanceMaster Information by Name", e);
			return new ResponseEntity<ResponseObject<?>>(ResponseUtil.createErrorResponse(e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}