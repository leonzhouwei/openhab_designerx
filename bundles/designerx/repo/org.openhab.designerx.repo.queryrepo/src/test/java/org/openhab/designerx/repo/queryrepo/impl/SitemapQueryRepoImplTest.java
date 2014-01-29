package org.openhab.designerx.repo.queryrepo.impl;

import java.util.List;

import org.junit.Test;
import org.openhab.designerx.model.sitemap.Sitemap;
import org.openhab.designerx.model.xtdex.sitemap.SitemapXtdex;
import org.openhab.designerx.model.xtdex.sitemap.impl.SitemapXtdexImpl;
import org.openhab.designerx.repo.queryrepo.SitemapQueryRepo;
import org.openhab.designerx.util.StringHelper;

public class SitemapQueryRepoImplTest {
	private static final SitemapXtdex xtdex = new SitemapXtdexImpl();
	private static final SitemapQueryRepo repo = SitemapQueryRepoImpl.getInstance();

	@Test
	public void testListAllAsReplicas() {
		List<Sitemap> list = repo.listAllAsReplicas();
		for (Sitemap s : list) {
			StringHelper.printSeparateLine();
			System.out.println(xtdex.toXtext(s));
		}
	}

	@Test
	public void testGetReplicaByName() {
		StringHelper.printSeparateLine();
		Sitemap s = repo.getReplicaByName("test");
		System.out.println(xtdex.toXtext(s));
	}

}
