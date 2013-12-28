package org.openhab.designerx.modelrepository;

import org.openhab.designerx.model.sitemap.Sitemap;

public interface SitemapWriter {

	public void write(String name, Sitemap sitemap);
	
}
