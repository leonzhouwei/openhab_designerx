package org.openhab.designerx.persistence.xtext.sitemap.repo.impl;

import java.io.File;
import java.util.List;

import org.openhab.designerx.config.Config;
import org.openhab.designerx.config.impl.ConfigFactory;
import org.openhab.designerx.persistence.xtext.PersistenceXtextConstants;
import org.openhab.designerx.persistence.xtext.sitemap.XtextSitemap;
import org.openhab.designerx.persistence.xtext.sitemap.repo.XtextSitemapRepository;
import org.openhab.designerx.util.IOUtils;

final class XtextSitemapRepositoryImpl implements XtextSitemapRepository {
	private static XtextSitemapRepository instance = new XtextSitemapRepositoryImpl();
	private static final Config config = ConfigFactory.create();
	
	public static XtextSitemapRepository getInstance() {
		return instance;
	}

	@Override
	public XtextSitemap find(String name) {
		return new XtextSitemapImpl(name);
	}
	
	private XtextSitemapRepositoryImpl() {}

	@Override
	public List<String> nameList() {
		String dirPath = config.getSitemapsFolderPath();
		File directory = new File(dirPath);
		List<File> files = IOUtils.listRegularFileNames(directory, PersistenceXtextConstants.SITEMAP_FILE_EXTENSION);
		List<String> names = IOUtils.listBaseNamesWithoutExtension(files, PersistenceXtextConstants.SITEMAP_FILE_EXTENSION);
		return names;
	}

}
