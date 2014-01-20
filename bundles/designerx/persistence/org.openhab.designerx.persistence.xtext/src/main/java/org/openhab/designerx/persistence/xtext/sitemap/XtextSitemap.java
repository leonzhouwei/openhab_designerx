package org.openhab.designerx.persistence.xtext.sitemap;

import java.io.IOException;

import org.openhab.designerx.model.sitemap.Sitemap;
import org.openhab.designerx.model.xtdex.ModelXtdexException;

public interface XtextSitemap {
	
	public Sitemap get() throws IOException, ModelXtdexException;
	
	public void save(Sitemap sitemap) throws IOException;
	
}
