package org.openhab.designerx.persistence.xtext.sitemap.repo.impl;

import org.openhab.designerx.persistence.xtext.sitemap.repo.XtextSitemapRepository;

public final class XtextSitemapRepositoryImpl {
	private static final XtextSitemapRepository real = RealXtextSitemapRepositoryImpl.getInstance();
	
	private static final XtextSitemapRepositoryImpl instance = new XtextSitemapRepositoryImpl();
	
	public static XtextSitemapRepositoryImpl getInstance() {
		return instance;
	}
	
	public static XtextSitemapRepository create() {
		return real;
	}
	
	private XtextSitemapRepositoryImpl() {}
}
