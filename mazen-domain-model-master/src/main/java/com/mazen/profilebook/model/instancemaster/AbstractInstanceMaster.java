package com.mazen.profilebook.model.instancemaster;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mazen.profilebook.model.common.AbstractConnectivity;
import com.mazen.profilebook.model.instancemaster.azureblob.AzureBlobInstanceMaster;
import com.mazen.profilebook.model.instancemaster.googlecloudstorage.GoogleCloudStorageInstanceMaster;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.EXISTING_PROPERTY, property="type")
@JsonSubTypes({
	@Type(value = AzureBlobInstanceMaster.class , name = "AzureBlobInstanceMaster"),
	@Type(value = GoogleCloudStorageInstanceMaster.class, name = "GoogleCloudStorageInstanceMaster")
	
})
@Document(collection="instanceMaster")
public abstract class AbstractInstanceMaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1828395843327430286L;
	
	@Id
	private String instanceName;
	private String businessName;
	private String description;
	private String lastUpdateDate;
	private String storageMB;
	private String supportedTypeDesc;
	
	@JsonProperty(value="supportedType")
	private InstanceSupportedTypeEnum supportType;
	
	@JsonProperty(value="datastoreType")
	private DatastoreTypeEnum datastoreType;
	
	@Transient
	private String type;
	
	protected AbstractConnectivity connectivity;
	
	public abstract String getType();

	public String getInstanceName() {
		return instanceName;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getStorageMB() {
		return storageMB;
	}

	public void setStorageMB(String storageMB) {
		this.storageMB = storageMB;
	}

	public String getSupportedTypeDesc() {
		return supportedTypeDesc;
	}

	public void setSupportedTypeDesc(String supportedTypeDesc) {
		this.supportedTypeDesc = supportedTypeDesc;
	}

	public InstanceSupportedTypeEnum getSupportType() {
		return supportType;
	}

	public void setSupportType(InstanceSupportedTypeEnum supportType) {
		this.supportType = supportType;
	}

	public DatastoreTypeEnum getDatastoreType() {
		return datastoreType;
	}

	public void setDatastoreType(DatastoreTypeEnum datastoreType) {
		this.datastoreType = datastoreType;
	}

	public AbstractConnectivity getConnectivity() {
		return connectivity;
	}

	public void setConnectivity(AbstractConnectivity connectivity) {
		this.connectivity = connectivity;
	}
	
	

}
