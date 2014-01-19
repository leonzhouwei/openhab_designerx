package org.openhab.designerx.persistence.xtext.sitemap.producer.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openhab.designerx.config.Config;
import org.openhab.designerx.config.ConfigBuilder;
import org.openhab.designerx.model.sitemap.Sitemap;
import org.openhab.designerx.model.xtdex.ModelXtdexException;
import org.openhab.designerx.model.xtdex.sitemap.SitemapXtdex;
import org.openhab.designerx.model.xtdex.sitemap.producer.SitemapXtdexBuilder;
import org.openhab.designerx.model.xtdex.sitemap.producer.impl.SitemapXtdexBuilderImpl;
import org.openhab.designerx.persistence.xtext.PersistenceXtextConstants;
import org.openhab.designerx.persistence.xtext.sitemap.SitemapPersist;
import org.openhab.designerx.persistence.xtext.sitemap.producer.SitemapPersistBuilder;
import org.openhab.designerx.util.IOUtils;

public final class SitemapPersistBuilderImpl implements SitemapPersistBuilder {

	@Override
	public SitemapPersist build(String name) {
		return new SitemapPersistImpl(name);
	}
	
	private class SitemapPersistImpl implements SitemapPersist {
		private String name;
		private Config config = ConfigBuilder.build();
		private SitemapXtdexBuilder xtdexBuilder = new SitemapXtdexBuilderImpl();
		private SitemapXtdex xtdex = xtdexBuilder.build();
		
		public SitemapPersistImpl(String name) {
			this.name = name;
		}

		@Override
		public Sitemap get() throws IOException, ModelXtdexException {
			File file = new File(config.getSitemapsFolderPath() + PersistenceXtextConstants.FILE_SEPARATOR + name + PersistenceXtextConstants.SITEMAP_FILE_EXTENSION);
			List<String> list = IOUtils.readAll(file);
			Sitemap result = xtdex.parse(list);
			return result;
		}

		@Override
		public void save(Sitemap sitemap) throws IOException {
			String xtext = xtdex.toXtext(sitemap);
			File file = new File(config.getSitemapsFolderPath() + PersistenceXtextConstants.FILE_SEPARATOR + name + PersistenceXtextConstants.SITEMAP_FILE_EXTENSION);
			IOUtils.write(file, xtext);
		}
		
	}

}
