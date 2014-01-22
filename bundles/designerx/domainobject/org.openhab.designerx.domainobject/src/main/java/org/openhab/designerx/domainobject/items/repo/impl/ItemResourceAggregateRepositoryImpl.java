package org.openhab.designerx.domainobject.items.repo.impl;

import java.util.List;
import java.util.Map;

import org.openhab.designerx.domainobject.DomainObjectException;
import org.openhab.designerx.domainobject.items.ItemResourceAggregate;
import org.openhab.designerx.domainobject.items.repo.ItemResourceAggregateRepository;
import org.openhab.designerx.persistence.xtext.items.repo.XtextItemResourceRepository;
import org.openhab.designerx.persistence.xtext.items.repo.impl.XtextItemResourceRepositoryFactory;

import com.google.common.collect.Maps;

final class ItemResourceAggregateRepositoryImpl implements ItemResourceAggregateRepository {
	private XtextItemResourceRepository xtextRepo = XtextItemResourceRepositoryFactory.create();

	private Map<String, ItemResourceAggregate> map = Maps.newHashMap();
	private static long nextId = 1; 
	private static final ItemResourceAggregateRepositoryImpl instance = new ItemResourceAggregateRepositoryImpl();	
	
	@Override
	public ItemResourceAggregate getByName(String name) {
		return map.get(name);
	}
	
	private ItemResourceAggregateRepositoryImpl() {
		List<String> names = xtextRepo.listNames();
		for (String name : names) {
			ItemResourceAggregate ira = new ItemResourceAggregateImpl(id, name);
			map.put(name, ira);
		}
	}
	
	static ItemResourceAggregateRepositoryImpl getInstance() {
		return instance; 
	}
	
	synchronized long generateId() {
		long ret = nextId;
		nextId += 1;
		if (nextId <= 0) {
			throw new DomainObjectException("no available ");
		}
		return ret;
	}
	
}
