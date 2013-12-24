package org.openhab.designerx.config.internal;

import org.junit.Test;
import org.openhab.designerx.config.ConfigConstants;
import org.openhab.designerx.config.ConfigException;

public class ConfigImplTest {

	@Test
	public void test() throws ConfigException {
		ConfigImpl config = new ConfigImpl();
		config.load();
		System.out.println(ConfigConstants.STRIKETHROUGH_80);
		System.out.println(config.getSitemapsFolderPath());
	}

}
