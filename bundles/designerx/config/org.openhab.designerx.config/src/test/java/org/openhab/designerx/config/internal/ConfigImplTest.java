package org.openhab.designerx.config.internal;

import org.junit.Test;
import org.openhab.designerx.config.ConfigConstants;

public class ConfigImplTest {

	@Test
	public void test() {
		ConfigImpl config = new ConfigImpl();
		System.out.println(ConfigConstants.STRIKETHROUGH_80);
		System.out.println(config.getSitemapFolderPath());
	}

}
