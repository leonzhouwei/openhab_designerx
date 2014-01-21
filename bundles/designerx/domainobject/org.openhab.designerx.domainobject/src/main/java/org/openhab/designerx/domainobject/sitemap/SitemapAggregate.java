package org.openhab.designerx.domainobject.sitemap;

import org.openhab.designerx.model.sitemap.Element;

public interface SitemapAggregate {
	
	public <T extends Element> void add(T e);

}
