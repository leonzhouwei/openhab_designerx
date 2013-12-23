package org.openhab.designerx.config.internal;

import org.junit.Test;

public class ConfigImplTest {

	@Test
	public void test() {
		ConfigImpl config = new ConfigImpl();
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println(config.getSitemapFolderPath());
	}

}
