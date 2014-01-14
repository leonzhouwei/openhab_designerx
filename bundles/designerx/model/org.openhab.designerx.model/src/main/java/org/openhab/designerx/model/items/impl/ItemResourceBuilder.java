package org.openhab.designerx.model.items.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.openhab.designerx.model.items.Item;
import org.openhab.designerx.model.items.ItemResource;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public final class ItemResourceBuilder {
	
	public ItemResourceBuilder() {
		
	}
	
	public ItemResource build() {
		return new ItemResourceImpl();
	}
	
	private class ItemResourceImpl implements ItemResource {
		private List<Item> items = Lists.newArrayList();
		private Map<String, Integer> map = Maps.newHashMap();
		
		@Override
		public Item append(Item item) {
			Item old = null;
			Integer index = map.get(item.getName());
			if (index == null) {
				items.add(item);
				map.put(item.getName(), items.size() - 1);
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
	}

}
