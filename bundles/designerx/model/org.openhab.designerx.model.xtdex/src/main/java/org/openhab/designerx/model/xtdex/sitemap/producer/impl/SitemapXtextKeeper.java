package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import java.util.List;

import org.openhab.designerx.model.xtdex.ModelXtdexException;

import com.google.common.collect.ImmutableList;

public final class SitemapXtextKeeper {
	private NestableElementXtextKeeper keeper;
	
	public SitemapXtextKeeper(List<String> list) throws ModelXtdexException {
		keeper = new NestableElementXtextKeeper(list);
		if (keeper.getXtext().isEmpty()) {
			throw new ModelXtdexException("could not find 'sitemap'");
		}
	}
	
	public ImmutableList<String> getXtext() {
		return keeper.getXtext();
	}

}
