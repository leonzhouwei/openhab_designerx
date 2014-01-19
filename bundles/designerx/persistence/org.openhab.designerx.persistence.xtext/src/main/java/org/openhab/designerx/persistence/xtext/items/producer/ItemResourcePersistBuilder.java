package org.openhab.designerx.persistence.xtext.items.producer;

import java.io.File;

import org.openhab.designerx.persistence.xtext.items.ItemResourcePersist;

public interface ItemResourcePersistBuilder {
	
	/**
	 * 
	 * @param name  e.g. 'demo' for $OPENHAB_HOME/configurations/sitemaps/demo.items
	 * @return
	 */
	public ItemResourcePersist build(String name);
	
	public ItemResourcePersist build(File file);

}
