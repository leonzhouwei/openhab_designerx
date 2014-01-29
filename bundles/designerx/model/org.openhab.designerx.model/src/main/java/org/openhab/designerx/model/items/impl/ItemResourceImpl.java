package org.openhab.designerx.model.items.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.openhab.designerx.model.ModelException;
import org.openhab.designerx.model.items.Item;
import org.openhab.designerx.model.items.ItemResource;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

final class ItemResourceImpl implements ItemResource {
	private List<Item> items = Lists.newArrayList();
	private Map<String, Integer> map = Maps.newHashMap();
	private String name;
	
	public ItemResourceImpl(String name) throws ModelException {
		name = name.trim();
		if (name.isEmpty()) {
			throw new ModelException("name is empty");
		}
		this.name = name;
	}
	
	@Override
	public Item append(Item item) {
		Item old = null;
		final String name = item.getName().trim();
		Integer index = map.get(name);
		if (index == null) {
			items.add(item);
			map.put(name, items.size() - 1);
		} else {
			old = items.get(index);
			items.set(index, item);
		}
		return old;
	}

	@Override
	public void appendAll(Collection<? extends Item> items) {
		for (Item e : items) {
			append(e);
		}
	}

	@Override
	public List<Item> getAll() {
		return items;
	}
	
	@Override
	public Item findByName(String name) {
		Item result = null;
		Integer index = map.get(name);
		if (index != null) {
			result = items.get(index);
		}
		return result;
	}

	@Override
	public String name() {
		return name;
	}
	
}
