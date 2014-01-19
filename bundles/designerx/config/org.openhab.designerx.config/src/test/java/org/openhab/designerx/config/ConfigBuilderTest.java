package org.openhab.designerx.config;

import org.junit.Test;

public class ConfigBuilderTest {

	@Test
	public void test() {
		Config config = ConfigBuilder.build();
		System.out.println(ConfigConstants.STRIKETHROUGH_80);
		System.out.println(config.getOpenHABHomeFolderPath());
	}

}
