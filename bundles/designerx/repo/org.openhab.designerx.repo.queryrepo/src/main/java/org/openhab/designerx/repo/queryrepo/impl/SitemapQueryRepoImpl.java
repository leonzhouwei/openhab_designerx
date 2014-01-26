package org.openhab.designerx.repo.queryrepo.impl;

import java.util.List;

import org.openhab.designerx.model.sitemap.Sitemap;
import org.openhab.designerx.repo.queryrepo.SitemapQueryRepo;

public final class SitemapQueryRepoImpl implements SitemapQueryRepo {
	private SitemapQueryRepo real = RealSitemapQueryRepoImpl.getInstance();

	@Override
	public List<Sitemap> listAllAsReplicas() {
		return real.listAllAsReplicas();
	}

	@Override
	public Sitemap getReplicaByName(String name) {
		return real.getReplicaByName(name);
	}

}
