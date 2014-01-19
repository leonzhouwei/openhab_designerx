package org.openhab.designerx.persistence.xtext.sitemap;

import java.io.IOException;

import org.junit.Test;
import org.openhab.designerx.model.sitemap.Sitemap;
import org.openhab.designerx.model.xtdex.ModelXtdexException;
import org.openhab.designerx.model.xtdex.sitemap.SitemapXtdex;
import org.openhab.designerx.model.xtdex.sitemap.producer.SitemapXtdexBuilder;
import org.openhab.designerx.model.xtdex.sitemap.producer.impl.SitemapXtdexBuilderImpl;
import org.openhab.designerx.persistence.xtext.sitemap.producer.SitemapPersistBuilder;
import org.openhab.designerx.persistence.xtext.sitemap.producer.impl.SitemapPersistBuilderImpl;
import org.openhab.designerx.util.StringHelper;

public class SitemapPersistTest {
	private SitemapPersistBuilder persistBuilder = new SitemapPersistBuilderImpl();
	private SitemapXtdexBuilder xtdexBuilder = new SitemapXtdexBuilderImpl();
	private SitemapXtdex xtdex = xtdexBuilder.build();

	@Test
	public void testGet() throws IOException, ModelXtdexException {
		SitemapPersist persist = persistBuilder.build("demo");
		Sitemap sitemap = persist.get();
		String xtext = xtdex.toXtext(sitemap);
		StringHelper.printSeparateLine();
		System.out.println(xtext);
	}

}
