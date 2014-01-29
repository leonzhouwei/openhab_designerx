package org.openhab.designerx.persistence.xtext.items.repo.impl;

import java.io.IOException;
import java.util.List;

import org.openhab.designerx.model.ModelException;
import org.openhab.designerx.model.items.ItemResource;
import org.openhab.designerx.model.xtdex.ModelXtdexException;
import org.openhab.designerx.persistence.xtext.items.ItemResourceQuery;

public final class ItemResourceQueryImpl implements ItemResourceQuery {
	private static final ItemResourceQuery real = RealXtextItemResourceRepositoryImpl.getInstance();

	@Override
	public ItemResource getReplicaByName(String name) throws IOException,
			ModelXtdexException, ModelException {
		return real.getReplicaByName(name);
	}

	@Override
	public List<ItemResource> replicas() throws IOException,
			ModelXtdexException, ModelException {
		return real.replicas();
	}

}
