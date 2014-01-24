package org.openhab.designerx.persistence.xtext.items.impl;

import java.io.IOException;
import java.util.List;

import org.openhab.designerx.model.ModelException;
import org.openhab.designerx.model.items.ItemResource;
import org.openhab.designerx.model.xtdex.ModelXtdexException;
import org.openhab.designerx.persistence.xtext.items.ItemResourceQuery;

public final class ItemResourceQueryImpl implements ItemResourceQuery {
	private final ItemResourceQuery real = new RealItemResourceQueryImpl();

	@Override
	public ItemResource byName(String name) throws IOException,
			ModelXtdexException, ModelException {
		return real.byName(name);
	}

	@Override
	public List<ItemResource> all() throws IOException, ModelXtdexException,
			ModelException {
		return real.all();
	}

	@Override
	public List<String> nameList() {
		return real.nameList();
	}

}
