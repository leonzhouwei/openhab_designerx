package org.openhab.designerx.model.xtdex.items.impl;

import java.util.List;

import org.openhab.designerx.model.ModelException;
import org.openhab.designerx.model.items.Item;
import org.openhab.designerx.model.items.ItemResource;
import org.openhab.designerx.model.items.ItemResourceFactory;
import org.openhab.designerx.model.items.impl.ItemResourceFactoryImpl;
import org.openhab.designerx.model.xtdex.ModelXtdexConstants;
import org.openhab.designerx.model.xtdex.ModelXtdexException;
import org.openhab.designerx.model.xtdex.items.ItemResourceXtdex;
import org.openhab.designerx.model.xtdex.items.ItemXtdex;

import com.google.common.collect.Lists;

final class RealItemResourceXtdexImpl implements ItemResourceXtdex {
	private ItemXtdex xtdex = new RealItemXtdexImpl();
	private ItemResourceFactory factory = new ItemResourceFactoryImpl();

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
		ItemResource ir = factory.createItemResource();
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
