package org.openhab.designerx.config;

import org.openhab.designerx.config.internal.ConfigImpl;

public class ConfigBuilder {
	
	private static ConfigImpl config = new ConfigImpl();
	
	public synchronized static Config build() throws ConfigException {
		config.load();
		return config;
	}
	
}
