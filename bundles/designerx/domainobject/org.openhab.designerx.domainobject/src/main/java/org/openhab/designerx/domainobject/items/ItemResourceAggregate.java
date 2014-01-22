package org.openhab.designerx.domainobject.items;

import org.openhab.designerx.domainobject.DomainObjectException;
import org.openhab.designerx.model.items.Item;

public interface ItemResourceAggregate {
	
	public long getId();
	
	public <T extends Item> void add(T item) throws DomainObjectException;
	
}
