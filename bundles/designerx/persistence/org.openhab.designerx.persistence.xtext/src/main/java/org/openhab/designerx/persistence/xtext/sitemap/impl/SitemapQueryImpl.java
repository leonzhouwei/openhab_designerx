package org.openhab.designerx.persistence.xtext.sitemap.impl;

import java.io.IOException;
import java.util.List;

import org.openhab.designerx.model.ModelException;
import org.openhab.designerx.model.sitemap.Sitemap;
import org.openhab.designerx.model.xtdex.ModelXtdexException;
import org.openhab.designerx.persistence.xtext.sitemap.SitemapQuery;

public final class SitemapQueryImpl implements SitemapQuery {
	private final SitemapQuery real = new RealSitemapQueryImpl();

	@Override
	public List<String> nameList() {
		return real.nameList();
	}

	@Override
	public List<Sitemap> all() throws IOException, ModelXtdexException,
			ModelException {
		return real.all();
	}

	@Override
	public Sitemap byName(String name) throws IOException, ModelXtdexException,
			ModelException {
		return real.byName(name);
	}

}
