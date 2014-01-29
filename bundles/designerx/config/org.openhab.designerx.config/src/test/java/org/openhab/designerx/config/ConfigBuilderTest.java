package org.openhab.designerx.config;

import org.junit.Test;
import org.openhab.designerx.config.impl.ConfigImpl;

public class ConfigBuilderTest {

	@Test
	public void test() {
		Config config = ConfigImpl.getInstance();
		System.out.println(ConfigConstants.STRIKETHROUGH_80);
		System.out.println(config.getOpenHABHomeFolderPath());
	}

}
