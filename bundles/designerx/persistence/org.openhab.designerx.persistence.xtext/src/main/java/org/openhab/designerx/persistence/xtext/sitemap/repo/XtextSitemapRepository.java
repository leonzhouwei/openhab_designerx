package org.openhab.designerx.persistence.xtext.sitemap.repo;

import org.openhab.designerx.persistence.xtext.sitemap.XtextSitemap;

public interface XtextSitemapRepository {
	
	/**
	 * 
	 * @param name  e.g. 'demo' for $OPENHAB_HOME/configurations/sitemaps/demo.sitemap
	 * @return
	 */
	public XtextSitemap find(String name);
	
}
