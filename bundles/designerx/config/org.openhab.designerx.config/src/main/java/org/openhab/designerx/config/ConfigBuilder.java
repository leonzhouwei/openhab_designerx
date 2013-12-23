package org.openhab.designerx.config;

import org.openhab.designerx.config.internal.ConfigImpl;

public class ConfigBuilder {
	
	private static ConfigImpl config = new ConfigImpl();
	
	public static Config build() {
		return config;
	}
	
}
