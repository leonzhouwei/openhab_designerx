package org.openhab.designerx.persistence.xtext.sitemap.impl;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.openhab.designerx.model.ModelException;
import org.openhab.designerx.model.sitemap.Sitemap;
import org.openhab.designerx.model.xtdex.ModelXtdexException;
import org.openhab.designerx.model.xtdex.sitemap.SitemapXtdex;
import org.openhab.designerx.model.xtdex.sitemap.impl.SitemapXtdexImpl;
import org.openhab.designerx.persistence.xtext.sitemap.SitemapQuery;
import org.openhab.designerx.util.StringHelper;

public class SitemapQueryImplTest {
	private static final SitemapQuery query = new SitemapQueryImpl();
	private static final SitemapXtdex xtdex = new SitemapXtdexImpl();

	@Test
	public void testNameList() {
		List<String> names = query.nameList();
		for (String name : names) {
			System.out.println(name);
		}
	}

	@Test
	public void testAll() throws IOException, ModelXtdexException, ModelException {
		List<Sitemap> result = query.all();
		for (Sitemap ir : result) {
			StringHelper.printSeparateLine();
			String xtext = xtdex.toXtext(ir);
			System.out.println(xtext);
		}
	}

	@Test
	public void testByName() throws IOException, ModelXtdexException, ModelException {
		StringHelper.printSeparateLine();
		Sitemap result = query.byName("demo");
		String xtext = xtdex.toXtext(result);
		System.out.println(xtext);
	}

}
