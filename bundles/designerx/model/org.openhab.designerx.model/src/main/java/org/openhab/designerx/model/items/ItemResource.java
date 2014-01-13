package org.openhab.designerx.model.items;

import java.util.List;

public interface ItemResource {
	
	public void add(Item item);
	
	public List<Item> getAll();

}
