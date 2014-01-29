package org.openhab.designerx.repo.queryrepo.impl;

import java.util.List;

import org.openhab.designerx.model.items.ItemResource;
import org.openhab.designerx.repo.queryrepo.ItemResourceQueryRepo;

public final class ItemResourceQueryRepoImpl implements ItemResourceQueryRepo {
	private ItemResourceQueryRepo real = RealItemResourceQueryRepoImpl.getInstance();
	
	private static final ItemResourceQueryRepoImpl instance = new ItemResourceQueryRepoImpl();
	
	public static ItemResourceQueryRepo getInstance() {
		return instance;
	}

	@Override
	public List<ItemResource> listAllAsReplicas() {
		return real.listAllAsReplicas();
	}

	@Override
	public ItemResource getReplicaByName(String name) {
		return real.getReplicaByName(name);
	}

	private ItemResourceQueryRepoImpl() {}
}
