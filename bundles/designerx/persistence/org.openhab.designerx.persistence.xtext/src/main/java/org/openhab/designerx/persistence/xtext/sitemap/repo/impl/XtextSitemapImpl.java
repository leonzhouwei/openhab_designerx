package org.openhab.designerx.persistence.xtext.sitemap.repo.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openhab.designerx.config.Config;
import org.openhab.designerx.config.impl.ConfigFactory;
import org.openhab.designerx.model.ModelException;
import org.openhab.designerx.model.sitemap.Sitemap;
import org.openhab.designerx.model.xtdex.ModelXtdexException;
import org.openhab.designerx.model.xtdex.sitemap.SitemapXtdex;
import org.openhab.designerx.model.xtdex.sitemap.impl.SitemapXtdexImpl;
import org.openhab.designerx.persistence.xtext.PersistenceXtextConstants;
import org.openhab.designerx.persistence.xtext.sitemap.XtextSitemap;
import org.openhab.designerx.util.IOUtils;

final class XtextSitemapImpl implements XtextSitemap {
	private File file;
	private Config config = ConfigFactory.create();
	private SitemapXtdex xtdex = new SitemapXtdexImpl();
	
	public XtextSitemapImpl(String name) {
		file = new File(config.getSitemapsFolderPath() + PersistenceXtextConstants.FILE_SEPARATOR + name + PersistenceXtextConstants.SITEMAP_FILE_EXTENSION);
	}

	@Override
	public Sitemap sitemapReplica() throws IOException, ModelXtdexException, ModelException {
		List<String> list = IOUtils.readAll(file);
		Sitemap result = xtdex.parse(list);
		return result;
	}

	@Override
	public void save(Sitemap sitemap) throws IOException {
		String xtext = xtdex.toXtext(sitemap);
		IOUtils.write(file, xtext);
	}
	
}
