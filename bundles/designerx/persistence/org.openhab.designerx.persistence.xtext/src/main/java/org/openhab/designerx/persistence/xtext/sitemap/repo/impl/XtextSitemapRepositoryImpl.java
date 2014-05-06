package org.openhab.designerx.persistence.xtext.sitemap.repo.impl;

import java.util.Set;

import org.openhab.designerx.persistence.xtext.sitemap.XtextSitemap;
import org.openhab.designerx.persistence.xtext.sitemap.repo.XtextSitemapRepository;

public final class XtextSitemapRepositoryImpl implements XtextSitemapRepository {
	private static final XtextSitemapRepository real = RealXtextSitemapRepositoryImpl.getInstance();
	
	private static final XtextSitemapRepositoryImpl instance = new XtextSitemapRepositoryImpl();
	
	public static XtextSitemapRepository getInstance() {
		return instance;
	}
	
	private XtextSitemapRepositoryImpl() {}

	@Override
	public XtextSitemap find(String name) {
		return real.find(name);
	}

	@Override
	public Set<String> nameSet() {
		return real.nameSet();
	}
	
	@Override
	public XtextSitemap findOrCreate(String name) throws Exception {
		return real.findOrCreate(name);
	}
}
