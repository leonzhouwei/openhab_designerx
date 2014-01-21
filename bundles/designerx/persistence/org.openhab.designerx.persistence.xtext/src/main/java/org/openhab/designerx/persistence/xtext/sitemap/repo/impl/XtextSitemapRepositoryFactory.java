package org.openhab.designerx.persistence.xtext.sitemap.repo.impl;

import org.openhab.designerx.persistence.xtext.sitemap.repo.XtextSitemapRepository;

public final class XtextSitemapRepositoryFactory {
	private static final XtextSitemapRepository repo = XtextSitemapRepositoryImpl.getInstance();
	
	public static XtextSitemapRepository create() {
		return repo;
	}
	
	private XtextSitemapRepositoryFactory() {}
}
