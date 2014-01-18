package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import org.junit.Test;
import org.openhab.designerx.model.sitemap.Sitemap;
import org.openhab.designerx.model.xtdex.ModelXtdexConstants;
import org.openhab.designerx.model.xtdex.ModelXtdexException;
import org.openhab.designerx.model.xtdex.sitemap.SitemapXtdex;

public class SitemapXtdexBuilderImplTest {
	private static final SitemapXtdex xtdex = new SitemapXtdexBuilderImpl().build();

	@Test
	public void test_1() throws ModelXtdexException {
		final String xtext = "sitemap demo label=\"Main Menu\"";
		Sitemap sitemap = xtdex.parse(xtext);
		System.out.println(xtdex.toXtext(sitemap));
	}
	
	@Test
	public void test_2() throws ModelXtdexException {
		StringBuilder sb = new StringBuilder();
		sb.append("sitemap demo label=\"Main Menu\" {");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR);
		sb.append("    Frame");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR);
		sb.append("}");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR);
		final String xtext = sb.toString();
		Sitemap sitemap = xtdex.parse(xtext);
		System.out.println(sitemap.getChildren().size());
		System.out.println(xtdex.toXtext(sitemap));
	}

}
