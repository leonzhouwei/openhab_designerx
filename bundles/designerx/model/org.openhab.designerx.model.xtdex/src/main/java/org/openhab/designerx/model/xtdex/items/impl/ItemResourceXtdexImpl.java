package org.openhab.designerx.model.xtdex.items.impl;

import java.util.List;

import org.openhab.designerx.model.items.Item;
import org.openhab.designerx.model.items.ItemResource;
import org.openhab.designerx.model.items.producer.ItemResourceBuilder;
import org.openhab.designerx.model.items.producer.impl.ItemResourceBuilderImpl;
import org.openhab.designerx.model.xtdex.XtdexConstants;
import org.openhab.designerx.model.xtdex.items.ItemResourceXtdex;
import org.openhab.designerx.model.xtdex.items.ItemXtdex;

public final class ItemResourceXtdexImpl implements ItemResourceXtdex {
	
	private ItemResourceBuilder builder = new ItemResourceBuilderImpl();
	private ItemXtdex xtdex = new ItemXtdexImpl();

	@Override
	public ItemResource fromXtext(String xtext) {
		xtext = xtext.trim();
		String[] split = xtext.split(XtdexConstants.LINE_SEPARATOR);
		ItemResource ir = builder.build();
		for (String string : split) {
			String s = string.trim();
			if (s.isEmpty() || s.startsWith("/*")) {
				continue;
			}
			Item item = xtdex.parseItem(s);
			ir.append(item);
		}
		return ir;
	}

	@Override
	public String toXtext(ItemResource itemResource) {
		StringBuilder sb = new StringBuilder();
		List<Item> items = itemResource.getAll();
		for (Item item : items) {
			sb.append(xtdex.toXtext(item));
			sb.append(XtdexConstants.LINE_SEPARATOR);
		}
		return sb.toString();
	}

}
