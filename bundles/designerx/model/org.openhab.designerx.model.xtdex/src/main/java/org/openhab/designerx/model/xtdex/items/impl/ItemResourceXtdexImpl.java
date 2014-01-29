package org.openhab.designerx.model.xtdex.items.impl;

import java.util.List;

import org.openhab.designerx.model.ModelException;
import org.openhab.designerx.model.items.ItemResource;
import org.openhab.designerx.model.xtdex.ModelXtdexException;
import org.openhab.designerx.model.xtdex.items.ItemResourceXtdex;

public final class ItemResourceXtdexImpl implements ItemResourceXtdex {
	private static final ItemResourceXtdex xtdex = new RealItemResourceXtdexImpl();
	
	@Override
	public ItemResource fromXtext(String name, String xtext) throws ModelXtdexException,
			ModelException {
		return xtdex.fromXtext(name, xtext);
	}

	@Override
	public String toXtext(ItemResource itemResource) {
		return xtdex.toXtext(itemResource);
	}

	@Override
	public ItemResource fromXtext(String name, List<String> xtext)
			throws ModelXtdexException, ModelException {
		return xtdex.fromXtext(name, xtext);
	}

}
