package org.openhab.designerx.persistence.xtext.sitemap.repo.impl;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.openhab.designerx.model.ModelException;
import org.openhab.designerx.model.sitemap.Sitemap;
import org.openhab.designerx.model.xtdex.ModelXtdexException;
import org.openhab.designerx.model.xtdex.sitemap.SitemapXtdex;
import org.openhab.designerx.model.xtdex.sitemap.impl.SitemapXtdexImpl;
import org.openhab.designerx.persistence.xtext.sitemap.XtextSitemap;
import org.openhab.designerx.util.StringHelper;

public class RealXtextSitemapRepositoryImplTest {
	private RealXtextSitemapRepositoryImpl repo = RealXtextSitemapRepositoryImpl.getInstance();
	private SitemapXtdex xtdex = new SitemapXtdexImpl();

//	@Test
	public void testFind() throws IOException, ModelXtdexException, ModelException {
		StringHelper.printSeparateLine();
		XtextSitemap persist = repo.find("test");
		Sitemap sitemap = persist.sitemapReplica();
		String xtext = xtdex.toXtext(sitemap);
		System.out.println(xtext);
	}
	
//	@Test
	public void testReplicas() throws IOException, ModelXtdexException, ModelException {
		StringHelper.printSeparateLine();
		List<Sitemap> replicas = repo.replicas();
		for (Sitemap e : replicas) {
			System.out.println(xtdex.toXtext(e));
		}
	}
	
	@Test
	public void testNameSet() {
		StringHelper.printSeparateLine();
		Set<String> names = repo.nameSet();
		for (String name : names) {
			System.out.println(name);
		}
	}
	
//	@Test
	public void testGetReplicaByName() throws IOException, ModelXtdexException, ModelException {
		StringHelper.printSeparateLine();
		Sitemap replica = repo.getReplicaByName("demo");
		System.out.println(xtdex.toXtext(replica));
	}
	
}
