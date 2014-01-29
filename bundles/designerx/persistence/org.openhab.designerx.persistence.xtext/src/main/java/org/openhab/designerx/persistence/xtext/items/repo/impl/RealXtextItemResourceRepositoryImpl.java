package org.openhab.designerx.persistence.xtext.items.repo.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openhab.designerx.config.Config;
import org.openhab.designerx.config.impl.ConfigFactory;
import org.openhab.designerx.model.ModelException;
import org.openhab.designerx.model.items.ItemResource;
import org.openhab.designerx.model.xtdex.ModelXtdexException;
import org.openhab.designerx.persistence.xtext.PersistenceXtextConstants;
import org.openhab.designerx.persistence.xtext.items.ItemResourceQuery;
import org.openhab.designerx.persistence.xtext.items.XtextItemResource;
import org.openhab.designerx.persistence.xtext.items.repo.XtextItemResourceRepository;
import org.openhab.designerx.util.IOUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

final class RealXtextItemResourceRepositoryImpl implements XtextItemResourceRepository, ItemResourceQuery  {
	private static final Config config = ConfigFactory.create();
	private static final Map<String, XtextItemResourceImpl> map = Maps.newHashMap(); 
	
	private static final RealXtextItemResourceRepositoryImpl instance = new RealXtextItemResourceRepositoryImpl();
	
	static RealXtextItemResourceRepositoryImpl getInstance() {
		return instance;
	}

	@Override
	public XtextItemResource find(String name) {
		return map.get(name);
	}
	
	private RealXtextItemResourceRepositoryImpl() {
		String dirPath = config.getItemsFolderPath();
		File directory = new File(dirPath);
		List<File> files = IOUtils.listRegularFileNames(directory, PersistenceXtextConstants.ITEMS_FILE_EXTENSION);
		List<String> names = IOUtils.listBaseNamesWithoutExtension(files, PersistenceXtextConstants.ITEMS_FILE_EXTENSION);
		for (String name : names) {
			XtextItemResourceImpl xir = new XtextItemResourceImpl(name);
			map.put(name, xir);
		}
	}

	@Override
	public Set<String> nameSet() {
		Set<String> names = map.keySet();
		return names;
	}

	@Override
	public ItemResource getReplicaByName(String name) throws IOException,
			ModelXtdexException, ModelException {
		XtextItemResourceImpl xir = map.get(name);
		if (xir != null) {
			return xir.itemResourceReplica();
		}
		return null;
	}

	@Override
	public List<ItemResource> replicas() throws IOException,
			ModelXtdexException, ModelException {
		List<ItemResource> replicas = Lists.newArrayList();
		Set<String> names = map.keySet();
		for (String name : names) {
			replicas.add(getReplicaByName(name));
		}
		return replicas;
	}

}
