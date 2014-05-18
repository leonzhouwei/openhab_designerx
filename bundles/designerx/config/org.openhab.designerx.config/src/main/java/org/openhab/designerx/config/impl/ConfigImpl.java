package org.openhab.designerx.config.impl;

import java.io.File;

import org.openhab.designerx.config.Config;

public final class ConfigImpl implements Config {
	private static final Config real = RealConfigImpl.getInstance();
	
	private static final ConfigImpl instance = new ConfigImpl();
	
	public static Config getInstance() {
		return instance;
	}
	
	@Override
	public String getOpenHABHomeFolderPath() {
		return real.getOpenHABHomeFolderPath();
	}

	@Override
	public String getSitemapsFolderPath() {
		return real.getSitemapsFolderPath();
	}

	@Override
	public String getItemsFolderPath() {
		return real.getItemsFolderPath();
	}

	@Override
	public File getOpenHABHomeFolder() {
		return real.getOpenHABHomeFolder();
	}

	@Override
	public File getSitemapsFolder() {
		return real.getSitemapsFolder();
	}

	@Override
	public File getItemsFolder() {
		return real.getItemsFolder();
	}
	
	private ConfigImpl() {}

	@Override
	public String getOpenHABWebappsImagesFolderPath() {
		return real.getOpenHABWebappsImagesFolderPath();
	}
}
