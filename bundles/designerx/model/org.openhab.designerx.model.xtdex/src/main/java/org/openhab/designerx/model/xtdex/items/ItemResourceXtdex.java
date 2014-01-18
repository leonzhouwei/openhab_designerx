package org.openhab.designerx.model.xtdex.items;

import java.util.List;

import org.openhab.designerx.model.items.ItemResource;

public interface ItemResourceXtdex {
	
	public ItemResource fromXtext(String xtext);
	
	public String toXtext(ItemResource itemResource);
	
	public ItemResource fromXtext(List<String> xtext);

}
