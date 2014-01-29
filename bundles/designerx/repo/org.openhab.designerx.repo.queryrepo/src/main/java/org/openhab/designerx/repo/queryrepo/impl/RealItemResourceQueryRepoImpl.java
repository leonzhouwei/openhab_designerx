package org.openhab.designerx.repo.queryrepo.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.openhab.designerx.model.items.ItemResource;
import org.openhab.designerx.model.xtdex.items.ItemResourceXtdex;
import org.openhab.designerx.model.xtdex.items.impl.ItemResourceXtdexImpl;
import org.openhab.designerx.persistence.xtext.items.ItemResourceQuery;
import org.openhab.designerx.persistence.xtext.items.repo.impl.ItemResourceQueryImpl;
import org.openhab.designerx.repo.queryrepo.ItemResourceQueryRepo;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

final class RealItemResourceQueryRepoImpl implements ItemResourceQueryRepo {
	private ItemResourceXtdex xtdex = new ItemResourceXtdexImpl();
	private static Map<String, ItemResource> map = Maps.newHashMap();
	
	private static final RealItemResourceQueryRepoImpl instance = new RealItemResourceQueryRepoImpl();

	static RealItemResourceQueryRepoImpl getInstance() {
		return instance;
	}

	@Override
	public List<ItemResource> listAllAsReplicas() {
		List<ItemResource> list = Lists.newArrayList();
		Collection<ItemResource> c = map.values();
		try {
			for (ItemResource ir : c) {
				ItemResource replica = createReplica(ir);
				list.add(replica);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	@Override
	public ItemResource getReplicaByName(String name) {
		ItemResource replica = map.get(name);
		try {
			if (replica != null) {
				replica = createReplica(replica);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return replica;
	}

	private RealItemResourceQueryRepoImpl() {
		try {
			ItemResourceQuery query = new ItemResourceQueryImpl();
			List<ItemResource> list = query.replicas();
			for (ItemResource e : list) {
				map.put(e.name(), e);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private ItemResource createReplica(ItemResource source) {
		ItemResource replica = null;
		try {
			String xtext = xtdex.toXtext(source);
			replica = xtdex.fromXtext(source.name(), xtext);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return replica;
	}

}
