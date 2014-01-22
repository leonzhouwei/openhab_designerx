package org.openhab.designerx.domainobject.sitemap.repo.impl;

import org.openhab.designerx.domainobject.sitemap.repo.SitemapAggregateRepository;

public final class SitemapAggregateRepositoryFactory {
	private static final SitemapAggregateRepository repo = SitemapAggregateRepositoryImpl.getInstance();
	
	public static SitemapAggregateRepository create() {
		return repo;
	}

	private SitemapAggregateRepositoryFactory() {}
}
