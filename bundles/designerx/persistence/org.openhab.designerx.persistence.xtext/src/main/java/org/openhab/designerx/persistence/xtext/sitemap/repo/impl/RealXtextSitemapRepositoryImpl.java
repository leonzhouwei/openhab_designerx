package org.openhab.designerx.persistence.xtext.sitemap.repo.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openhab.designerx.config.Config;
import org.openhab.designerx.config.impl.ConfigImpl;
import org.openhab.designerx.model.ModelException;
import org.openhab.designerx.model.sitemap.Sitemap;
import org.openhab.designerx.model.xtdex.ModelXtdexException;
import org.openhab.designerx.persistence.xtext.PersistenceXtextConstants;
import org.openhab.designerx.persistence.xtext.sitemap.SitemapQuery;
import org.openhab.designerx.persistence.xtext.sitemap.XtextSitemap;
import org.openhab.designerx.persistence.xtext.sitemap.repo.XtextSitemapRepository;
import org.openhab.designerx.util.IOUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

final class RealXtextSitemapRepositoryImpl implements XtextSitemapRepository, SitemapQuery {
	private static final Config config = ConfigImpl.getInstance();
	private static final Map<String, XtextSitemapImpl> map = Maps.newHashMap();
	
	private static RealXtextSitemapRepositoryImpl instance = new RealXtextSitemapRepositoryImpl();
	
	static RealXtextSitemapRepositoryImpl getInstance() {
		return instance;
	}

	@Override
	public XtextSitemap find(String name) {
		return map.get(name);
	}
	
	private RealXtextSitemapRepositoryImpl() {
		try {
			String dirPath = config.getSitemapsFolderPath();
			File directory = new File(dirPath);
			List<File> files = IOUtils.listRegularFileNames(directory, PersistenceXtextConstants.SITEMAP_FILE_EXTENSION);
			List<String> names = IOUtils.listBaseNamesWithoutExtension(files, PersistenceXtextConstants.SITEMAP_FILE_EXTENSION);
			for (String name : names) {
				XtextSitemapImpl value = new XtextSitemapImpl(name);
				map.put(name, value);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Set<String> nameSet() {
		return map.keySet();
	}

	@Override
	public List<Sitemap> replicas() throws IOException, ModelXtdexException,
			ModelException {
		List<Sitemap> replicas = Lists.newArrayList();
		Set<String> names = map.keySet();
		for (String name : names) {
			replicas.add(getReplicaByName(name));
		}
		return replicas;
	}

	@Override
	public Sitemap getReplicaByName(String name) throws IOException,
			ModelXtdexException, ModelException {
		XtextSitemapImpl xsi = map.get(name);
		if (xsi != null) {
			return xsi.sitemapReplica();
		}
		return null;
	}
	
	@Override
	public XtextSitemap findOrCreate(String name) throws Exception {
		if (map.containsKey(name)) {
			return map.get(name);
		}
		XtextSitemap xs = new XtextSitemapImpl(name);
		return xs;
	}

}
