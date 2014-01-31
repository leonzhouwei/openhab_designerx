package org.openhab.designerx.domainobject.items.repo.impl;

import java.util.Map;
import java.util.Set;

import org.openhab.designerx.domainobject.items.ItemResourceAggregate;
import org.openhab.designerx.domainobject.items.repo.ItemResourceAggregateRepository;
import org.openhab.designerx.persistence.xtext.items.repo.XtextItemResourceRepository;
import org.openhab.designerx.persistence.xtext.items.repo.impl.XtextItemResourceRepositoryImpl;
import org.openhab.designerx.util.IdGenerator;

import com.google.common.collect.Maps;

final class RealItemResourceAggregateRepositoryImpl implements ItemResourceAggregateRepository {
	private XtextItemResourceRepository xtextRepo = XtextItemResourceRepositoryImpl.getInstance();

	private Map<String, ItemResourceAggregate> map = Maps.newHashMap();
	private static final IdGenerator idGen = new IdGenerator();
	private static final RealItemResourceAggregateRepositoryImpl instance = new RealItemResourceAggregateRepositoryImpl();	
	
	@Override
	public ItemResourceAggregate findByName(String name) {
		return map.get(name);
	}
	
	private RealItemResourceAggregateRepositoryImpl() {
		try {
			Set<String> names = xtextRepo.nameSet();
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
	
	static RealItemResourceAggregateRepositoryImpl getInstance() {
		return instance; 
	}

	@Override
	public Set<String> nameSet() {
		return map.keySet();
	}
	
}
