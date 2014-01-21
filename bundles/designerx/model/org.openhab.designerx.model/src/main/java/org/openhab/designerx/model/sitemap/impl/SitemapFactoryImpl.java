package org.openhab.designerx.model.sitemap.impl;

import org.openhab.designerx.model.ModelException;
import org.openhab.designerx.model.sitemap.Sitemap;
import org.openhab.designerx.model.sitemap.SitemapFactory;

public final class SitemapFactoryImpl implements SitemapFactory {
	
	@Override
	public Sitemap createSitemap(String name) throws ModelException {
		return new SitemapImpl(name);
	}
	
}
