package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import org.openhab.designerx.model.sitemap.Sitemap;
import org.openhab.designerx.model.xtdex.ModelXtdexException;
import org.openhab.designerx.model.xtdex.sitemap.SitemapXtdex;
import org.openhab.designerx.model.xtdex.sitemap.producer.SitemapXtdexBuilder;

public final class SitemapXtdexBuilderImpl implements SitemapXtdexBuilder {

	@Override
	public SitemapXtdex build() {
		return new SitemapXtdexImpl();
	}
	
	private class SitemapXtdexImpl implements SitemapXtdex {

		@Override
		public Sitemap parse(String xtext) throws ModelXtdexException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String toXtext(Sitemap sitemap) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

}
