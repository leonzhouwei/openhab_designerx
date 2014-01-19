package org.openhab.designerx.persistence.xtext.sitemap.producer;

import org.openhab.designerx.persistence.xtext.sitemap.SitemapPersist;

public interface SitemapPersistBuilder {
	
	/**
	 * 
	 * @param name  e.g. 'demo' for $OPENHAB_HOME/configurations/sitemaps/demo.sitemap
	 * @return
	 */
	public SitemapPersist build(String name);

}
