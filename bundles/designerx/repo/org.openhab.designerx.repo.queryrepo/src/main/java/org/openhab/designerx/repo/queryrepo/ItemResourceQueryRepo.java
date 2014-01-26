package org.openhab.designerx.repo.queryrepo;

import java.util.List;

import org.openhab.designerx.model.items.ItemResource;

public interface ItemResourceQueryRepo {
	
	public List<ItemResource> listAllAsReplicas();
	
	public ItemResource getReplicaByName(String name);
	
}
