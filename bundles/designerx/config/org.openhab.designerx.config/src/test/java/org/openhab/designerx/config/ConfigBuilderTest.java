package org.openhab.designerx.config;

import org.junit.Test;
import org.openhab.designerx.config.impl.ConfigFactory;

public class ConfigBuilderTest {

	@Test
	public void test() {
		Config config = ConfigFactory.create();
		System.out.println(ConfigConstants.STRIKETHROUGH_80);
		System.out.println(config.getOpenHABHomeFolderPath());
	}

}
