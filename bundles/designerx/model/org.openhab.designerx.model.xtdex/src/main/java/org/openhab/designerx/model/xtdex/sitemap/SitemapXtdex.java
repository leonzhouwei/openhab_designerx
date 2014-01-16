package org.openhab.designerx.model.xtdex.sitemap;

import org.openhab.designerx.model.sitemap2.Sitemap;

public interface SitemapXtdex {
	
	public Sitemap parse(String xtext);
	
	public String toXtext(Sitemap sitemap);

}
