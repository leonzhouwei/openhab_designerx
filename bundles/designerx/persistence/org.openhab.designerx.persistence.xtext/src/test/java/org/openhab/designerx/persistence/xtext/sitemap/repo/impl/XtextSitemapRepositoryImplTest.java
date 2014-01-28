package org.openhab.designerx.persistence.xtext.sitemap.repo.impl;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.openhab.designerx.model.ModelException;
import org.openhab.designerx.model.sitemap.Sitemap;
import org.openhab.designerx.model.xtdex.ModelXtdexException;
import org.openhab.designerx.model.xtdex.sitemap.SitemapXtdex;
import org.openhab.designerx.model.xtdex.sitemap.impl.SitemapXtdexImpl;
import org.openhab.designerx.persistence.xtext.sitemap.XtextSitemap;
import org.openhab.designerx.util.StringHelper;

public class XtextSitemapRepositoryImplTest {
	private XtextSitemapRepositoryImpl repo = XtextSitemapRepositoryImpl.getInstance();
	private SitemapXtdex xtdex = new SitemapXtdexImpl();

	@Test
	public void testFind() throws IOException, ModelXtdexException, ModelException {
		StringHelper.printSeparateLine();
		XtextSitemap persist = repo.find("test");
		Sitemap sitemap = persist.sitemapReplica();
		String xtext = xtdex.toXtext(sitemap);
		System.out.println(xtext);
	}
	
	@Test
	public void testReplicas() throws IOException, ModelXtdexException, ModelException {
		StringHelper.printSeparateLine();
		List<Sitemap> replicas = repo.replicas();
		for (Sitemap e : replicas) {
			System.out.println(xtdex.toXtext(e));
		}
	}
	
}
