package com.web.configurationReader;

import java.io.IOException;

public class ConfigurationReaderHelp {
	
	public static ConfigurationReader getInstance() throws IOException {
		
		ConfigurationReader cr = new ConfigurationReader();
		return cr;
		
	}
	
	
	private ConfigurationReaderHelp() {
		
	}
	
	

}
