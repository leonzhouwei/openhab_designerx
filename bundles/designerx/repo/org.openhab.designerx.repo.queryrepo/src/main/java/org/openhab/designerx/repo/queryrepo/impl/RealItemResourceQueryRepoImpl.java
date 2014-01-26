package org.openhab.designerx.repo.queryrepo.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.openhab.designerx.model.ModelException;
import org.openhab.designerx.model.items.ItemResource;
import org.openhab.designerx.model.xtdex.ModelXtdexException;
import org.openhab.designerx.model.xtdex.items.ItemResourceXtdex;
import org.openhab.designerx.model.xtdex.items.impl.ItemResourceXtdexImpl;
import org.openhab.designerx.persistence.xtext.items.ItemResourceQuery;
import org.openhab.designerx.persistence.xtext.items.impl.ItemResourceQueryImpl;
import org.openhab.designerx.repo.queryrepo.ItemResourceQueryRepo;
import org.openhab.designerx.repo.queryrepo.QueryRepoException;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

final class RealItemResourceQueryRepoImpl implements
		ItemResourceQueryRepo {
	private ItemResourceXtdex xtdex = new ItemResourceXtdexImpl();
	private static Map<String, ItemResource> map = Maps.newHashMap();
	private static final RealItemResourceQueryRepoImpl instance = new RealItemResourceQueryRepoImpl();

	public static RealItemResourceQueryRepoImpl getInstance() {
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
			throw new QueryRepoException(e);
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
			throw new QueryRepoException(e);
		}
		return replica;
	}

	private RealItemResourceQueryRepoImpl() {
		ItemResourceQuery query = new ItemResourceQueryImpl();
		try {
			List<String> names = query.nameList();
			for (String name : names) {
				ItemResource value;
				value = query.byName(name);
				map.put(name, value);
			}
		} catch (Exception e) {
			throw new QueryRepoException(e);
		}
	}

	private ItemResource createReplica(ItemResource source)
			throws ModelXtdexException, ModelException {
		String xtext = xtdex.toXtext(source);
		ItemResource replica = xtdex.fromXtext(xtext);
		return replica;
	}

}
