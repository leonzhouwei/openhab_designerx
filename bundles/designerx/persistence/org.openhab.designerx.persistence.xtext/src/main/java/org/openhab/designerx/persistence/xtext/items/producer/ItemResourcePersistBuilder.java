package org.openhab.designerx.persistence.xtext.items.producer;

import org.openhab.designerx.config.ConfigException;
import org.openhab.designerx.persistence.xtext.items.ItemResourcePersist;

public interface ItemResourcePersistBuilder {
	
	/**
	 * 
	 * @param name  e.g. 'demo' for $OPENHAB_HOME/configurations/sitemaps/demo.items
	 * @return
	 */
	public ItemResourcePersist build(String name) throws ConfigException;

}
