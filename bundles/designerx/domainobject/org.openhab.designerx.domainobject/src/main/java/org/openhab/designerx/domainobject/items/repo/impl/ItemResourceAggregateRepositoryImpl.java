package org.openhab.designerx.domainobject.items.repo.impl;

import org.openhab.designerx.domainobject.items.repo.ItemResourceAggregateRepository;

public final class ItemResourceAggregateRepositoryImpl {
	private static final ItemResourceAggregateRepository repo = RealItemResourceAggregateRepositoryImpl.getInstance();
	
	public static ItemResourceAggregateRepository create() {
		return repo;
	}
	

	private ItemResourceAggregateRepositoryImpl() {}
}
