package org.openhab.designerx.persistence.xtext.sitemap.repo.impl;

import org.openhab.designerx.persistence.xtext.sitemap.XtextSitemap;
import org.openhab.designerx.persistence.xtext.sitemap.repo.XtextSitemapRepository;

final class XtextSitemapRepositoryImpl implements XtextSitemapRepository {
	private static XtextSitemapRepository instance = new XtextSitemapRepositoryImpl();
	
	public static XtextSitemapRepository getInstance() {
		return instance;
	}

	@Override
	public XtextSitemap find(String name) {
		return new XtextSitemapImpl(name);
	}
	
	private XtextSitemapRepositoryImpl() {}

}
