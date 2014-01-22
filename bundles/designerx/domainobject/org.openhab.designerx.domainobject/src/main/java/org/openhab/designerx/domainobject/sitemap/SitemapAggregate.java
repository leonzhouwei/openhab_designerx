package org.openhab.designerx.domainobject.sitemap;

import org.openhab.designerx.domainobject.DomainObjectException;
import org.openhab.designerx.model.sitemap.Element;

public interface SitemapAggregate {
	
	public long getId();
	
	public <T extends Element> void add(T e) throws DomainObjectException;

}
