package org.openhab.designerx.bizlogic.cqrs.query.sitemap;

import java.util.List;

import org.openhab.designerx.model.sitemap.Sitemap;

public interface SitemapQuery {
	
	public List<Sitemap> all();
	
	public Sitemap byName(String name);

}
