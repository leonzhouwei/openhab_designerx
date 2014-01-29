package org.openhab.designerx.repo.queryrepo.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

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
	private SitemapXtdex xtdex = new SitemapXtdexImpl();
	private static Map<String, Sitemap> map = Maps.newHashMap();
	private static final RealSitemapQueryRepoImpl instance = new RealSitemapQueryRepoImpl();

	public static RealSitemapQueryRepoImpl getInstance() {
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
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
