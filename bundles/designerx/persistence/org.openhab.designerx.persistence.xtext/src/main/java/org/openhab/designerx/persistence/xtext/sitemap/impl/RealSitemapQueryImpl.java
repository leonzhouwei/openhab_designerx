package org.openhab.designerx.persistence.xtext.sitemap.impl;

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
import org.openhab.designerx.persistence.xtext.sitemap.SitemapQuery;
import org.openhab.designerx.util.IOUtils;

import com.google.common.collect.Lists;

public final class RealSitemapQueryImpl implements SitemapQuery {
	private Config config = ConfigFactory.create();
	private SitemapXtdex xtdex = new SitemapXtdexImpl();
	
	@Override
	public Sitemap byName(String name) throws IOException, ModelXtdexException, ModelException {
		File file = new File(config.getSitemapsFolderPath() + PersistenceXtextConstants.FILE_SEPARATOR + name + PersistenceXtextConstants.SITEMAP_FILE_EXTENSION);
		return byFile(file);
	}
	
	@Override
	public List<Sitemap> all() throws IOException, ModelXtdexException, ModelException {
		List<Sitemap> list = Lists.newArrayList();
		String dirPath = config.getSitemapsFolderPath();
		File directory = new File(dirPath);
		List<File> files = IOUtils.listRegularFileNames(directory, PersistenceXtextConstants.SITEMAP_FILE_EXTENSION);
		for (File file : files) {
			Sitemap ir = byFile(file);
			list.add(ir);
		}
		return list;
	}
	
	@Override
	public List<String> nameList() {
		String dirPath = config.getSitemapsFolderPath();
		File directory = new File(dirPath);
		List<File> files = IOUtils.listRegularFileNames(directory, PersistenceXtextConstants.SITEMAP_FILE_EXTENSION);
		List<String> names = IOUtils.listBaseNamesWithoutExtension(files, PersistenceXtextConstants.SITEMAP_FILE_EXTENSION);
		return names;
	}
	
	private Sitemap byFile(File file) throws IOException, ModelXtdexException, ModelException {
		List<String> list = IOUtils.readAll(file);
		Sitemap result = xtdex.parse(list);
		return result;
	}

}
