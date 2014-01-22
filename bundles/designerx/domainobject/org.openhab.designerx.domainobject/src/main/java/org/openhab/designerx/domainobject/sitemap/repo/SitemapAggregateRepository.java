package org.openhab.designerx.domainobject.sitemap.repo;

import java.util.Set;

import org.openhab.designerx.domainobject.sitemap.SitemapAggregate;

public interface SitemapAggregateRepository {
	
	public SitemapAggregate findByName(String name);
	
	public Set<String> listNames();

}
