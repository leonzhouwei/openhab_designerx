package org.openhab.designerx.domainobject.sitemap.repo.impl;

import java.util.Map;
import java.util.Set;

import org.openhab.designerx.domainobject.sitemap.SitemapAggregate;
import org.openhab.designerx.domainobject.sitemap.repo.SitemapAggregateRepository;
import org.openhab.designerx.persistence.xtext.sitemap.repo.XtextSitemapRepository;
import org.openhab.designerx.persistence.xtext.sitemap.repo.impl.XtextSitemapRepositoryImpl;
import org.openhab.designerx.util.IdGenerator;

import com.google.common.collect.Maps;

final class SitemapAggregateRepositoryImpl implements SitemapAggregateRepository {
	private XtextSitemapRepository xtextRepo = XtextSitemapRepositoryImpl.getInstance();

	private Map<String, SitemapAggregate> map = Maps.newHashMap();
	private static final IdGenerator idGen = new IdGenerator();
	private static final SitemapAggregateRepositoryImpl instance = new SitemapAggregateRepositoryImpl();	
	
	public static SitemapAggregateRepositoryImpl getInstance() {
		return instance;
	}
	
	@Override
	public SitemapAggregate findByName(String name) {
		return map.get(name);
	}

	@Override
	public Set<String> nameSet() {
		return map.keySet();
	}

	private SitemapAggregateRepositoryImpl() {
		try {
			Set<String> names = xtextRepo.nameSet();
			for (String name : names) {
				long id = idGen.newId();
				SitemapAggregate ira = new SitemapAggregateImpl(id, name);
				map.put(name, ira);
			}
		} catch (Exception e) {
			RuntimeException re = new RuntimeException();
			re.initCause(e);
			throw re;
		}
	}
	
}
