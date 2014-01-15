package org.openhab.designerx.model.xtdex.items;

import org.openhab.designerx.model.items.ItemResource;

public interface ItemResourceXtdex {
	
	public ItemResource fromXtext(String xtext);
	
	public String toXtext(ItemResource itemResource);

}
