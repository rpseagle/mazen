package com.mazen.connectors.source.cloud;

import java.util.List;
import java.util.Map;

import org.apache.kafka.connect.source.SourceRecord;
import org.apache.kafka.connect.source.SourceTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CloudSourceTask extends SourceTask {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CloudSourceTask.class);

	@Override
	public String version() {
		return null;
	}

	@Override
	public void start(Map<String, String> props) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SourceRecord> poll() throws InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}
	
	


}
