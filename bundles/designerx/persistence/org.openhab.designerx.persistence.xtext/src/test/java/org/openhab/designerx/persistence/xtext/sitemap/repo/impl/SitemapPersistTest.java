package org.openhab.designerx.persistence.xtext.sitemap.repo.impl;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.openhab.designerx.model.sitemap.Sitemap;
import org.openhab.designerx.model.xtdex.ModelXtdexException;
import org.openhab.designerx.model.xtdex.sitemap.SitemapXtdex;
import org.openhab.designerx.model.xtdex.sitemap.producer.SitemapXtdexBuilder;
import org.openhab.designerx.model.xtdex.sitemap.producer.impl.SitemapXtdexBuilderImpl;
import org.openhab.designerx.persistence.xtext.sitemap.XtextSitemap;
import org.openhab.designerx.persistence.xtext.sitemap.repo.XtextSitemapRepository;
import org.openhab.designerx.util.StringHelper;

public class SitemapPersistTest {
	private XtextSitemapRepository persistBuilder = new XtextSitemapRepositoryImpl();
	private SitemapXtdexBuilder xtdexBuilder = new SitemapXtdexBuilderImpl();
	private SitemapXtdex xtdex = xtdexBuilder.build();

	@Test
	public void testGet() throws IOException, ModelXtdexException {
		File file = new File("_test/resources/demo.sitemap");
		XtextSitemap persist = persistBuilder.find(file);
		Sitemap sitemap = persist.get();
		String xtext = xtdex.toXtext(sitemap);
		StringHelper.printSeparateLine();
		System.out.println(xtext);
	}
	
//	@Test
	public void testSave() throws IOException, ModelXtdexException {
		File file = new File("_test/resources/demo.sitemap");
		XtextSitemap persist = persistBuilder.find(file);
		Sitemap sitemap = persist.get();
		StringHelper.printSeparateLine();
		persist.save(sitemap);
	}
	
}
