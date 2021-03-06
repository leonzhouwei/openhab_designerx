package org.openhab.designerx.persistence.xtext.items;

import java.io.IOException;

import org.openhab.designerx.model.ModelException;
import org.openhab.designerx.model.items.ItemResource;
import org.openhab.designerx.model.xtdex.ModelXtdexException;

public interface XtextItemResource {
	
	public ItemResource itemResourceReplica() throws IOException, ModelXtdexException, ModelException;
	
	public void save(ItemResource ir) throws IOException, ModelException;
	
}
