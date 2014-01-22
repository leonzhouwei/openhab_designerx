package org.openhab.designerx.model.xtdex.items;

import java.util.List;

import org.openhab.designerx.model.ModelException;
import org.openhab.designerx.model.items.ItemResource;
import org.openhab.designerx.model.xtdex.ModelXtdexException;

public interface ItemResourceXtdex {
	
	public ItemResource fromXtext(String xtext) throws ModelXtdexException, ModelException;
	
	public String toXtext(ItemResource itemResource);
	
	public ItemResource fromXtext(List<String> xtext) throws ModelXtdexException, ModelException;

}
