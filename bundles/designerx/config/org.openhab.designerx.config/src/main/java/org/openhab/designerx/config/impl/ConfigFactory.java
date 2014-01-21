package org.openhab.designerx.config.impl;

import org.openhab.designerx.config.Config;

public final class ConfigFactory {
	private static final Config config = ConfigImpl.getInstance();
	
	public static Config create() {
		return config;
	}
	
	private ConfigFactory() {}
}
