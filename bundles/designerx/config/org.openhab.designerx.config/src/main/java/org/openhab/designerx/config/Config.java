package org.openhab.designerx.config;

import java.io.File;

public interface Config {
	
	public String getOpenHABHomeFolderPath();
	
	public String getSitemapsFolderPath();

	public String getItemsFolderPath();

	public File getOpenHABHomeFolder();

	public File getSitemapsFolder();

	File getItemsFolder();

	public String getOpenHABWebappsImagesFolderPath();

}
