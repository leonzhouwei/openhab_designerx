package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import org.junit.Test;
import org.openhab.designerx.model.sitemap.Sitemap;
import org.openhab.designerx.model.xtdex.ModelXtdexException;
import org.openhab.designerx.model.xtdex.sitemap.SitemapXtdex;

public class SitemapXtdexBuilderImplTest {
	private static final SitemapXtdex xtdex = new SitemapXtdexBuilderImpl().build();

	@Test
	public void test() throws ModelXtdexException {
		final String xtext = "sitemap demo label=\"Main Menu\"";
		Sitemap sitemap = xtdex.parse(xtext);
		System.out.println(xtdex.toXtext(sitemap));
	}

}
