package org.openhab.designerx.domainobject.items.repo.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openhab.designerx.domainobject.items.ItemResourceAggregate;
import org.openhab.designerx.domainobject.items.repo.ItemResourceAggregateRepository;
import org.openhab.designerx.persistence.xtext.items.repo.XtextItemResourceRepository;
import org.openhab.designerx.persistence.xtext.items.repo.impl.XtextItemResourceRepositoryFactory;
import org.openhab.designerx.util.IdGenerator;

import com.google.common.collect.Maps;

final class ItemResourceAggregateRepositoryImpl implements ItemResourceAggregateRepository {
	private XtextItemResourceRepository xtextRepo = XtextItemResourceRepositoryFactory.create();

	private Map<String, ItemResourceAggregate> map = Maps.newHashMap();
	private static final IdGenerator idGen = new IdGenerator();
	private static final ItemResourceAggregateRepositoryImpl instance = new ItemResourceAggregateRepositoryImpl();	
	
	@Override
	public ItemResourceAggregate findByName(String name) {
		return map.get(name);
	}
	
	private ItemResourceAggregateRepositoryImpl() {
		try {
			List<String> names = xtextRepo.listNames();
			for (String name : names) {
				long id = idGen.newId();
				ItemResourceAggregate ira = new ItemResourceAggregateImpl(id, name);
				map.put(name, ira);
			}
		} catch (Exception e) {
			RuntimeException re = new RuntimeException();
			re.initCause(e);
			throw re;
		}
	}
	
	static ItemResourceAggregateRepositoryImpl getInstance() {
		return instance; 
	}

	@Override
	public Set<String> listNames() {
		return map.keySet();
	}
	
}
