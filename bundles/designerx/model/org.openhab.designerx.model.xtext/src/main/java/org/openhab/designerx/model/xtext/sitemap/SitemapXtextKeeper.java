package org.openhab.designerx.model.xtext.sitemap;

import java.util.List;

import org.openhab.designerx.model.xtext.ModelXtextException;

import com.google.common.collect.ImmutableList;

public final class SitemapXtextKeeper {
	
	private NestableElementXtextKeeper keeper;
	private static final String MATCH_REGEX = "sitemap\\b.*";
	
	public SitemapXtextKeeper(List<String> list) throws ModelXtextException {
		keeper = new NestableElementXtextKeeper(list);
		if (keeper.getXtext().isEmpty()) {
			throw new ModelXtextException("could not find 'sitemap'");
		}
		if (!keeper.getXtext().get(0).matches(MATCH_REGEX)) {
			throw new ModelXtextException("could not find 'sitemap' in '" + keeper.getXtext().get(0) + "'");
		}
	}
	
	public ImmutableList<String> getXtext() {
		return keeper.getXtext();
	}

}
