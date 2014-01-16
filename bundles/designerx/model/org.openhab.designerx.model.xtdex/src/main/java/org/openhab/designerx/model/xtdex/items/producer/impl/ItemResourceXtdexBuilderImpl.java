package org.openhab.designerx.model.xtdex.items.producer.impl;

import org.openhab.designerx.model.xtdex.items.ItemResourceXtdex;
import org.openhab.designerx.model.xtdex.items.producer.ItemResourceXtdexBuilder;

public final class ItemResourceXtdexBuilderImpl implements ItemResourceXtdexBuilder {

	@Override
	public ItemResourceXtdex build() {
		return new ItemResourceXtdexImpl();
	}

}
