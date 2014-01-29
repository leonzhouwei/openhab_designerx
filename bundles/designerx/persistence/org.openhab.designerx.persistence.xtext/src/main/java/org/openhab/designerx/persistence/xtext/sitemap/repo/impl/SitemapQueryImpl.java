package org.openhab.designerx.persistence.xtext.sitemap.repo.impl;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openhab.designerx.model.ModelException;
import org.openhab.designerx.model.sitemap.Sitemap;
import org.openhab.designerx.model.xtdex.ModelXtdexException;
import org.openhab.designerx.persistence.xtext.sitemap.SitemapQuery;

public final class SitemapQueryImpl implements SitemapQuery {
	private static final SitemapQuery real = RealXtextSitemapRepositoryImpl.getInstance();

	@Override
	public Set<String> nameSet() {
		return real.nameSet();
	}

	@Override
	public List<Sitemap> replicas() throws IOException, ModelXtdexException,
			ModelException {
		return real.replicas();
	}

	@Override
	public Sitemap getReplicaByName(String name) throws IOException,
			ModelXtdexException, ModelException {
		return real.getReplicaByName(name);
	}

}
