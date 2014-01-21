package org.openhab.designerx.persistence.xtext.sitemap.repo.impl;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.openhab.designerx.model.sitemap.Sitemap;
import org.openhab.designerx.model.xtdex.ModelXtdexException;
import org.openhab.designerx.model.xtdex.sitemap.SitemapXtdex;
import org.openhab.designerx.model.xtdex.sitemap.impl.SitemapXtdexImpl;
import org.openhab.designerx.persistence.xtext.sitemap.XtextSitemap;
import org.openhab.designerx.persistence.xtext.sitemap.repo.XtextSitemapRepository;
import org.openhab.designerx.util.StringHelper;

public class SitemapPersistTest {
	private XtextSitemapRepository persistBuilder = XtextSitemapRepositoryImpl.getInstance();
	private SitemapXtdex xtdex = new SitemapXtdexImpl();

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
