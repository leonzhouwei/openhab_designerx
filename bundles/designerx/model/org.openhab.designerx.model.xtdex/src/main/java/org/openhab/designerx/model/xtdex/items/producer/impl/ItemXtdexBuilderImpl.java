package org.openhab.designerx.model.xtdex.items.producer.impl;

import org.openhab.designerx.model.xtdex.items.ItemXtdex;
import org.openhab.designerx.model.xtdex.items.producer.ItemXtdexBuilder;

public final class ItemXtdexBuilderImpl implements ItemXtdexBuilder {

	@Override
	public ItemXtdex build() {
		return new ItemXtdexImpl();
	}

}
