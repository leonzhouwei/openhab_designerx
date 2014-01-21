package org.openhab.designerx.model.sitemap;

import org.openhab.designerx.model.ModelException;

public interface SitemapFactory {
	
	public Sitemap createSitemap(String name) throws ModelException;

}
