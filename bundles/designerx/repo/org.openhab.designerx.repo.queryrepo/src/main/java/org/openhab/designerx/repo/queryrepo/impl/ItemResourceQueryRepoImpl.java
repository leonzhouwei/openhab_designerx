package org.openhab.designerx.repo.queryrepo.impl;

import java.util.List;

import org.openhab.designerx.model.items.ItemResource;
import org.openhab.designerx.repo.queryrepo.ItemResourceQueryRepo;

public final class ItemResourceQueryRepoImpl implements ItemResourceQueryRepo {
	private ItemResourceQueryRepo real = RealItemResourceQueryRepoImpl.getInstance();

	@Override
	public List<ItemResource> listAllAsReplicas() {
		return real.listAllAsReplicas();
	}

	@Override
	public ItemResource getReplicaByName(String name) {
		return real.getReplicaByName(name);
	}

}
