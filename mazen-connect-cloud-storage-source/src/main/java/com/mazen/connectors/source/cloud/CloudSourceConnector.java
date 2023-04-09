package com.mazen.connectors.source.cloud;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.kafka.common.config.Config;
import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.connect.connector.Task;
import org.apache.kafka.connect.source.SourceConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import com.mazen.connectors.source.cloud.config.CloudSourceConfig;
import com.mazen.kafkautils.source.SourceConstants;

public class CloudSourceConnector extends SourceConnector {

	private static final Logger LOGGER = LoggerFactory.getLogger(CloudSourceConfig.class);
	
	private Map<String, String> configProperties;
	CloudSourceConfig configs;
	
	@Override
	public String version() {
		return null;
	}
	
	@Override
	public Config validate(Map<String, String> connectorConfigs) {
		MDC.clear();
		try {
			MDC.put(SourceConstants.MDC_CONNECTOR_NAME, connectorConfigs.get("name"));
		}
		catch (IllegalArgumentException ex) {
			LOGGER.error("Exception in MDC.put()", ex);
		}
		catch(Exception ex) {
			LOGGER.error("Exception in MDC.Put()",ex);
		}
		return super.validate(connectorConfigs);
	}

	@Override
	public void start(Map<String, String> props) {
		this.configProperties = props;
		configs = new CloudSourceConfig(props);
	}

	@Override
	public Class<? extends Task> taskClass() {
		return CloudSourceTask.class;
	}

	@Override
	public List<Map<String, String>> taskConfigs(int maxTasks) {
		List<Map<String, String>> taskConfigs = new ArrayList<>();
		Map<String, String> taskProps = new HashMap<>(configProperties);
		for(int i=0; i < maxTasks; i++) {
			taskConfigs.add(taskProps);
		}
		return taskConfigs;
	}

	@Override
	public void stop() {
		MDC.clear();
		
	}

	@Override
	public ConfigDef config() {
		return CloudSourceConfig.config;
	}
	
	

}
