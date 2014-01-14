package org.openhab.designerx.model.xtext.items.impl;

import java.util.List;

import org.openhab.designerx.model.xtext.ModelXtextException;

import com.google.common.collect.ImmutableList;

final class ItemResourceXtextKeeper {
	private ImmutableList<String> xtext;
	
	public ItemResourceXtextKeeper(List<String> list) throws ModelXtextException {
		ImmutableList.Builder<String> builder = ImmutableList.<String>builder();
		for (String s : list) {
			s = s.trim();
			if (s.isEmpty()) {
				continue;
			}
			builder.add(s);
		}
		xtext = builder.build();
		if (xtext.isEmpty()) {
			throw new ModelXtextException("could not find any effective content in the input");
		}
	}
	
	ImmutableList<String> getXtext() {
		return xtext;
	}

}
