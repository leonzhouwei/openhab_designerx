package org.openhab.designerx.domainobject.items.repo.impl;

import java.util.List;
import java.util.Map;

import org.openhab.designerx.domainobject.items.ItemResourceAggregate;
import org.openhab.designerx.domainobject.items.repo.ItemResourceAggregateRepository;
import org.openhab.designerx.persistence.xtext.items.XtextItemResource;
import org.openhab.designerx.persistence.xtext.items.repo.XtextItemResourceRepository;
import org.openhab.designerx.persistence.xtext.items.repo.impl.XtextItemResourceRepositoryFactory;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

final class ItemResourceAggregateRepositoryImpl implements ItemResourceAggregateRepository {
	private XtextItemResourceRepository xtextRepo = XtextItemResourceRepositoryFactory.create();
	
	private Map<String, ItemResourceAggregate> map = Maps.newHashMap();
	private static final ItemResourceAggregateRepository instance = new ItemResourceAggregateRepositoryImpl();	
	
	@Override
	public ItemResourceAggregate getByName(String name) {
		return map.get(name);
	}
	
	private ItemResourceAggregateRepositoryImpl() {
		List<String> names = Lists.newArrayList();
		for (String name : names) {
			XtextItemResource xir = xtextRepo.find(name);
		}
	}
	
}
