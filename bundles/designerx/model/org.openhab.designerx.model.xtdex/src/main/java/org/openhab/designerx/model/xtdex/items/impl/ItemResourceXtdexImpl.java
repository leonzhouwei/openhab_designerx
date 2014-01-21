package org.openhab.designerx.model.xtdex.items.impl;

import java.util.List;

import org.openhab.designerx.model.ModelException;
import org.openhab.designerx.model.items.Item;
import org.openhab.designerx.model.items.ItemResource;
import org.openhab.designerx.model.items.producer.ItemResourceBuilder;
import org.openhab.designerx.model.items.producer.impl.ItemResourceBuilderImpl;
import org.openhab.designerx.model.xtdex.ModelXtdexConstants;
import org.openhab.designerx.model.xtdex.ModelXtdexException;
import org.openhab.designerx.model.xtdex.items.ItemResourceXtdex;
import org.openhab.designerx.model.xtdex.items.ItemXtdex;

import com.google.common.collect.Lists;

public final class ItemResourceXtdexImpl implements ItemResourceXtdex {
	private ItemResourceBuilder builder = new ItemResourceBuilderImpl();
	private ItemXtdex xtdex = new ItemXtdexImpl();

	@Override
	public ItemResource fromXtext(String xtext) throws ModelXtdexException, ModelException {
		xtext = xtext.trim();
		String[] split = xtext.split(ModelXtdexConstants.LINE_SEPARATOR);
		List<String> list = Lists.newArrayList();
		for (String string : split) {
			list.add(string);
		}
		return fromXtext(list);
	}

	@Override
	public String toXtext(ItemResource itemResource) throws ModelException {
		StringBuilder sb = new StringBuilder();
		List<Item> items = itemResource.getAll();
		for (Item item : items) {
			sb.append(xtdex.toXtext(item));
			sb.append(ModelXtdexConstants.LINE_SEPARATOR);
		}
		return sb.toString();
	}
	
	@Override
	public ItemResource fromXtext(List<String> xtext) throws ModelXtdexException, ModelException {
		ItemResource ir = builder.build();
		for (String string : xtext) {
			String s = string.trim();
			if (s.isEmpty() || s.startsWith("/*")) {
				continue;
			}
			Item item = xtdex.parseItem(s);
			String name = item.getName();
			if (ir.findByName(name) != null) {
				throw new ModelXtdexException("item name '" + name + "' has been used for more than once at '" + string + "'");
			}
			ir.append(item);
		}
		return ir;
	}

}
