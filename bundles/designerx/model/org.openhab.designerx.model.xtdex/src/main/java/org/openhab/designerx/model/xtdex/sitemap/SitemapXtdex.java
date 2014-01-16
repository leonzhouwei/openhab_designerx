package org.openhab.designerx.model.xtdex.sitemap;

import org.openhab.designerx.model.sitemap2.Sitemap;
import org.openhab.designerx.model.xtdex.ModelXtdexException;

public interface SitemapXtdex {
	
	public Sitemap parse(String xtext) throws ModelXtdexException;
	
	public String toXtext(Sitemap sitemap);

}
