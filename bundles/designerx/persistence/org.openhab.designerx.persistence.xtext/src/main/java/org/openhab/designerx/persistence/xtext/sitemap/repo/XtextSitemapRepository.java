package org.openhab.designerx.persistence.xtext.sitemap.repo;

import java.util.Set;

import org.openhab.designerx.persistence.xtext.sitemap.XtextSitemap;

public interface XtextSitemapRepository {
	
	/**
	 * 
	 * @param name  e.g. 'demo' for $OPENHAB_HOME/configurations/sitemaps/demo.sitemap
	 * @return
	 */
	public XtextSitemap find(String name);

	public Set<String> nameSet();
	
	public XtextSitemap findOrCreate(String name) throws Exception;
	
}
