package org.openhab.designerx.domainobject.items.repo;

import org.openhab.designerx.domainobject.items.ItemResourceAggregate;

public interface ItemResourceAggregateRepository {
	
	public ItemResourceAggregate getByName(String name);

}
