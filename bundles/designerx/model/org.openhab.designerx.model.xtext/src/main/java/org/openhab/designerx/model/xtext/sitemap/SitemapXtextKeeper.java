package org.openhab.designerx.model.xtext.sitemap;

import java.util.List;

import org.openhab.designerx.model.xtext.ModelXtextException;

import com.google.common.collect.ImmutableList;

public final class SitemapXtextKeeper {
	
	private NestableElementXtextKeeper keeper;
	
	public SitemapXtextKeeper(List<String> list) throws ModelXtextException {
		keeper = new NestableElementXtextKeeper(list);
		if (keeper.getXtext().isEmpty()) {
			throw new ModelXtextException("could not find 'sitemap'");
		}
	}
	
	public ImmutableList<String> getXtext() {
		return keeper.getXtext();
	}

}
