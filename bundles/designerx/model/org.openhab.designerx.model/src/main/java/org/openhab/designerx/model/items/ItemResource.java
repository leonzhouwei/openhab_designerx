package org.openhab.designerx.model.items;

import java.util.Collection;
import java.util.List;

public interface ItemResource {
	
	public Item append(Item item);
	
	public void appendAll(Collection<? extends Item> items);
	
	public List<Item> getAll();
	
	public Item findByName(String name);

}
