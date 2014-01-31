package org.openhab.designerx.repo.queryrepo.impl;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

import org.openhab.designerx.bizlogic.cqrs.eventbus.Event;
import org.openhab.designerx.bizlogic.cqrs.eventbus.EventBus;
import org.openhab.designerx.bizlogic.cqrs.eventbus.EventHandler;
import org.openhab.designerx.bizlogic.cqrs.eventbus.SitemapUpdatedEvent;
import org.openhab.designerx.bizlogic.cqrs.eventbus.Subscriber;
import org.openhab.designerx.bizlogic.cqrs.eventbus.impl.EventBusImpl;
import org.openhab.designerx.model.ModelException;
import org.openhab.designerx.model.sitemap.Sitemap;
import org.openhab.designerx.model.xtdex.ModelXtdexException;
import org.openhab.designerx.model.xtdex.sitemap.SitemapXtdex;
import org.openhab.designerx.model.xtdex.sitemap.impl.SitemapXtdexImpl;
import org.openhab.designerx.persistence.xtext.sitemap.SitemapQuery;
import org.openhab.designerx.persistence.xtext.sitemap.repo.impl.SitemapQueryImpl;
import org.openhab.designerx.repo.queryrepo.SitemapQueryRepo;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

final class RealSitemapQueryRepoImpl implements SitemapQueryRepo {
	private static final SitemapXtdex xtdex = new SitemapXtdexImpl();
	private static final ConcurrentMap<String, Sitemap> map = Maps.newConcurrentMap();
	
	private static final RealSitemapQueryRepoImpl instance = new RealSitemapQueryRepoImpl();

	static RealSitemapQueryRepoImpl getInstance() {
		return instance;
	}

	@Override
	public List<Sitemap> listAllAsReplicas() {
		List<Sitemap> list = Lists.newArrayList();
		Collection<Sitemap> c = map.values();
		try {
			for (Sitemap ir : c) {
				Sitemap replica = createReplica(ir);
				list.add(replica);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	@Override
	public Sitemap getReplicaByName(String name) {
		Sitemap replica = map.get(name);
		try {
			if (replica != null) {
				replica = createReplica(replica);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return replica;
	}

	private Sitemap createReplica(Sitemap source)
			throws ModelXtdexException, ModelException {
		String xtext = xtdex.toXtext(source);
		Sitemap replica = xtdex.parse(xtext);
		return replica;
	}

	private RealSitemapQueryRepoImpl() {
		SitemapQuery query = new SitemapQueryImpl();
		try {
			List<Sitemap> list = query.replicas();
			for (Sitemap s : list) {
				map.put(s.getName(), s);
			}
			EventBus bus = EventBusImpl.getInstance();
			// register the subscriber
			bus.addSubscriber(new Subscriber() {
				@Override
				public EventHandler eventHandler() {
					EventHandler handler = new EventHandler() {
						@Override
						public <T extends Event> void handle(T event) {
							update(event);
						}
					};
					return handler;
				}
			});
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	private <T extends Event> void update(T event) {
		if (!(event instanceof SitemapUpdatedEvent)) {
			return;
		}
		SitemapUpdatedEvent irue = (SitemapUpdatedEvent) event;
		String name = irue.sitemapName();
		if (map.containsKey(name)) {
			try {
				Sitemap replace = xtdex.parse(irue.sitemapXtext());
				map.put(name, replace);
			} catch (Exception e) {
				map.remove(name);
				// TODO
			}
		}
	}

}
