package org.openhab.designerx.persistence.xtext.sitemap.repo.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openhab.designerx.config.Config;
import org.openhab.designerx.config.impl.ConfigImpl;
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
	private Config config = ConfigImpl.getInstance();
	private SitemapXtdex xtdex = new SitemapXtdexImpl();
	private Sitemap sitemap;
	
	XtextSitemapImpl(String name) throws IOException, ModelXtdexException, ModelException {
		file = new File(config.getSitemapsFolderPath() + PersistenceXtextConstants.FILE_SEPARATOR + name + PersistenceXtextConstants.SITEMAP_FILE_EXTENSION);
		if (!file.exists()) {
			file.createNewFile();
			IOUtils.write(file, "sitemap " + name);
		}
		List<String> list = IOUtils.readAll(file);
		sitemap = xtdex.parse(list);
	}

	@Override
	public Sitemap sitemapReplica() throws IOException, ModelXtdexException, ModelException {
		Sitemap result = xtdex.parse(xtdex.toXtext(sitemap));
		return result;
	}

	@Override
	public void save(Sitemap sitemap) throws IOException {
		String xtext = xtdex.toXtext(sitemap);
		IOUtils.write(file, xtext);
		this.sitemap = sitemap;
	}
	
}
