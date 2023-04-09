package com.mazen.profilebook.model.instancemaster;

public enum InstanceSupportedTypeEnum {
	
	AZUREBLOB("AZUREBLOB"),
	GOOGLECLOUDSTORAGE("GOOGLECLOUDSTORAGE"),
	NOSUPPORTTYPE("NOSUPPORTTYPE");
	
	String value;

	private InstanceSupportedTypeEnum(String value) {
		this.value = value;	
	}
	
	public String getValue() {
		return this.value;
	}
	
	public static InstanceSupportedTypeEnum ofValue(String value) {
		if (value!=null) {
			for(InstanceSupportedTypeEnum supportedTypeEnum : InstanceSupportedTypeEnum.values()) {
				if(value.equalsIgnoreCase(supportedTypeEnum.value)) {
					return supportedTypeEnum;
				}
			}
		}
		return NOSUPPORTTYPE;
	}
}
