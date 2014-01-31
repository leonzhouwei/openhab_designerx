package org.openhab.designerx.bizlogic.cqrs.eventbus;

public interface SitemapUpdatedEvent extends Event {
	
	public String sitemapName();
	
	public String sitemapXtext();

}
