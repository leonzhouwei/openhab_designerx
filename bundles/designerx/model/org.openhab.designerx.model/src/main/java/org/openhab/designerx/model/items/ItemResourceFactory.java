package org.openhab.designerx.model.items;

import org.openhab.designerx.model.ModelException;

public interface ItemResourceFactory {

	public ItemResource createItemResource(String name) throws ModelException;

}
