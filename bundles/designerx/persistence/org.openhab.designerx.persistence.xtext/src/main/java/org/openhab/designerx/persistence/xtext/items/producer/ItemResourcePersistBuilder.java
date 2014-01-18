package org.openhab.designerx.persistence.xtext.items.producer;

import org.openhab.designerx.persistence.xtext.items.ItemResourcePersist;

public interface ItemResourcePersistBuilder {
	
	/**
	 * 
	 * @param name  e.g. 'demo' for $OPENHAB_HOME/configurations/sitemaps/demo.sitemap
	 * @return
	 */
	public ItemResourcePersist build(String name);

}