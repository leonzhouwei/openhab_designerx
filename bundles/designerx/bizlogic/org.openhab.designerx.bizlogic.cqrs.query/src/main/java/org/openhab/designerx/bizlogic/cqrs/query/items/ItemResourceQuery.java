package org.openhab.designerx.bizlogic.cqrs.query.items;

import java.util.List;

import org.openhab.designerx.model.items.ItemResource;

public interface ItemResourceQuery {
	
	public List<ItemResource> all();
	
	public ItemResource byName(String name);

}
