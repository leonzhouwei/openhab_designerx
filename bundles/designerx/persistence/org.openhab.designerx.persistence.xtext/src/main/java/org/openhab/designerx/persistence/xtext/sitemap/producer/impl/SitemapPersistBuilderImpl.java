package org.openhab.designerx.persistence.xtext.sitemap.producer.impl;

import org.openhab.designerx.config.Config;
import org.openhab.designerx.config.ConfigBuilder;
import org.openhab.designerx.config.ConfigException;
import org.openhab.designerx.model.sitemap.Sitemap;
import org.openhab.designerx.persistence.xtext.sitemap.SitemapPersist;
import org.openhab.designerx.persistence.xtext.sitemap.producer.SitemapPersistBuilder;

public final class SitemapPersistBuilderImpl implements SitemapPersistBuilder {

	@Override
	public SitemapPersist build(String name) throws ConfigException {
		return new SitemapPersistImpl(name);
	}
	
	private class SitemapPersistImpl implements SitemapPersist {
		private Config config;
		private String name;
		
		public SitemapPersistImpl(String name) throws ConfigException {
			config = ConfigBuilder.build();
			this.name = name;
		}

		@Override
		public Sitemap get() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void save(Sitemap sitemap) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
