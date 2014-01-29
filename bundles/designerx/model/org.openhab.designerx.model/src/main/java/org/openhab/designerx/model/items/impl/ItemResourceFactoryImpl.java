package org.openhab.designerx.model.items.impl;

import org.openhab.designerx.model.ModelException;
import org.openhab.designerx.model.items.ItemResource;
import org.openhab.designerx.model.items.ItemResourceFactory;

public final class ItemResourceFactoryImpl implements ItemResourceFactory {

	@Override
	public ItemResource createItemResource(String name) throws ModelException {
		return new ItemResourceImpl(name);
	}

}
