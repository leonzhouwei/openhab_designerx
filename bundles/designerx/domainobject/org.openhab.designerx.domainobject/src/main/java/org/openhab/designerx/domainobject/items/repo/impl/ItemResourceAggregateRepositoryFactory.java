package org.openhab.designerx.domainobject.items.repo.impl;

import org.openhab.designerx.domainobject.items.repo.ItemResourceAggregateRepository;

public final class ItemResourceAggregateRepositoryFactory {
	private static final ItemResourceAggregateRepository repo = ItemResourceAggregateRepositoryImpl.getInstance();
	
	public static ItemResourceAggregateRepository create() {
		return repo;
	}
	

	private ItemResourceAggregateRepositoryFactory() {}
}
