package org.openhab.designerx.persistence.xtext.sitemap;

import java.io.IOException;
import java.util.List;

import org.openhab.designerx.model.ModelException;
import org.openhab.designerx.model.sitemap.Sitemap;
import org.openhab.designerx.model.xtdex.ModelXtdexException;

public interface SitemapQuery {

	public List<String> nameList();
	
	public List<Sitemap> all() throws IOException, ModelXtdexException, ModelException;
	
	public Sitemap byName(String name) throws IOException, ModelXtdexException, ModelException;
	
}
