package org.openhab.designerx.persistence.xtext.sitemap;

import org.openhab.designerx.model.sitemap.Sitemap;

public interface SitemapPersist {
	
	public Sitemap get();
	
	public void save(Sitemap sitemap);

}
