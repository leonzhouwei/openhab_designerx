package org.openhab.designerx.persistence.xtext.items;

import java.io.IOException;
import java.util.List;

import org.openhab.designerx.model.ModelException;
import org.openhab.designerx.model.items.ItemResource;
import org.openhab.designerx.model.xtdex.ModelXtdexException;

public interface ItemResourceQuery {
	
	public ItemResource getReplicaByName(String name) throws IOException, ModelXtdexException, ModelException;
	
	public List<ItemResource> replicas() throws IOException, ModelXtdexException, ModelException;

}
