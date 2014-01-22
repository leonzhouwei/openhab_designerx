package org.openhab.designerx.domainobject.items.repo;

import java.util.Set;

import org.openhab.designerx.domainobject.items.ItemResourceAggregate;

public interface ItemResourceAggregateRepository {
	
	public ItemResourceAggregate getByName(String name);
	
	public Set<String> listNames();

}
