package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import java.util.List;

import org.junit.Test;
import org.openhab.designerx.model.sitemap.Sitemap;
import org.openhab.designerx.model.xtdex.ModelXtdexException;
import org.openhab.designerx.model.xtdex.sitemap.SitemapXtdex;

import com.google.common.collect.Lists;

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
		List<String> list = Lists.newArrayList();
		list.add("sitemap demo label=\"Main Menu\" {");
		list.add("    Frame {");
		list.add("        Group item=gFF label=\"First Floor\" icon=\"firstfloor\"");
		list.add("        Group item=gGF label=\"Ground Floor\" icon=\"groundfloor\"");
		list.add("        Group item=gC label=\"Cellar\" icon=\"cellar\"");
		list.add("        Group item=Outdoor icon=\"garden\"");
		list.add("    }");
		list.add("}");
		Sitemap sitemap = xtdex.parse(list);
		System.out.println(xtdex.toXtext(sitemap));
	}

}
