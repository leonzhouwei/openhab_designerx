package org.openhab.designerx.model.items.producer.impl;

import org.openhab.designerx.model.items.ItemResource;
import org.openhab.designerx.model.items.producer.ItemResourceBuilder;

public final class ItemResourceBuilderImpl implements ItemResourceBuilder {
	
	@Override
	public ItemResource build() {
		return new ItemResourceImpl();
	}

}