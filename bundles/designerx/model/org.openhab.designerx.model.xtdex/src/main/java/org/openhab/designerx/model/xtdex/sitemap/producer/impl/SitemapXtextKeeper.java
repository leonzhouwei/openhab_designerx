package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import java.util.List;

import org.openhab.designerx.model.xtdex.ModelXtdexException;

import com.google.common.collect.ImmutableList;

public final class SitemapXtextKeeper {
	private ChildfulElementXtextKeeper keeper;
	
	SitemapXtextKeeper(List<String> list) throws ModelXtdexException {
		keeper = new ChildfulElementXtextKeeper(list);
		if (keeper.getXtext().isEmpty()) {
			throw new ModelXtdexException("could not find 'sitemap'");
		}
	}
	
	ImmutableList<String> getXtext() {
		return keeper.getXtext();
	}

}
