package org.openhab.designerx.model.xtdex.sitemap;

import java.util.List;

import org.openhab.designerx.model.ModelException;
import org.openhab.designerx.model.sitemap.Sitemap;
import org.openhab.designerx.model.xtdex.ModelXtdexException;

public interface SitemapXtdex {
	
	public Sitemap parse(String xtext) throws ModelXtdexException, ModelException;
	
	public String toXtext(Sitemap sitemap);
	
	public Sitemap parse(List<String> xtext) throws ModelXtdexException, ModelException;

}
