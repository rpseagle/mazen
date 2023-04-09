package com.mazen.connectors.source.cloud.config;

import java.util.Map;

import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.common.config.ConfigDef.Importance;
import org.apache.kafka.common.config.ConfigDef.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mazen.kafkautils.source.SourceConstants;

public class CloudSourceConfig extends AbstractConfig {
	

	private static Logger LOGGER = LoggerFactory.getLogger(CloudSourceConfig.class);
	
	public static final ConfigDef config = baseConfigDef();

	
	public CloudSourceConfig(Map <String, String> properties) {
		super(config,properties);
		LOGGER.info("Cloud source configuration intialized");
	}
	
	public static ConfigDef baseConfigDef() {
		return new ConfigDef.define(CloudSourceConstants.IDENTITY, Type.STRING, "",Importance.HIGH, "Access Key")
				.define(CloudSourceConstants.CREDENTIALS,Type.STRING, "",Importance.HIGH,"Secret Key")
				.define(CloudSourceConstants.CLOUDENDPOINT,Type.STRING, "",Importance.HIGH,"Endpoint")
				.define(CloudSourceConstants.PROVIDER, Type.STRING, "",Importance.HIGH,"Cloud Storage Type")
				.define(CloudSourceConstants.DETAILS, Type.STRING, "", Importance.HIGH, "Bucket Details")
				.define(SourceConstants.MODE, Type.STRING, "", Importance.HIGH, "Mode of getting data from S3")
				.define(SourceConstants.CONNECTOR_TYPE, Type.STRING, "datastream", Importance.HIGH, "Type of Connector");
	}
	
}
