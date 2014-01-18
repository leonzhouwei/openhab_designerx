package org.openhab.designerx.persistence.xtext.items;

import java.io.IOException;

import org.openhab.designerx.model.items.Item;
import org.openhab.designerx.model.items.ItemResource;

public interface ItemResourcePersist {
	
	public ItemResource get() throws IOException;
	
	public void append(Item item) throws IOException;
	
	public void save(ItemResource ir) throws IOException;
	
}
