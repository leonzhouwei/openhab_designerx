package org.openhab.designerx.persistence.xtext.items.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openhab.designerx.config.Config;
import org.openhab.designerx.config.impl.ConfigFactory;
import org.openhab.designerx.model.ModelException;
import org.openhab.designerx.model.items.ItemResource;
import org.openhab.designerx.model.xtdex.ModelXtdexException;
import org.openhab.designerx.model.xtdex.items.ItemResourceXtdex;
import org.openhab.designerx.model.xtdex.items.impl.ItemResourceXtdexImpl;
import org.openhab.designerx.persistence.xtext.PersistenceXtextConstants;
import org.openhab.designerx.persistence.xtext.items.ItemResourceQuery;
import org.openhab.designerx.util.IOUtils;

import com.google.common.collect.Lists;

final class RealItemResourceQueryImpl implements ItemResourceQuery {
	private Config config = ConfigFactory.create();
	private final ItemResourceXtdex xtdex = new ItemResourceXtdexImpl();
	
	@Override
	public ItemResource byName(String name) throws IOException, ModelXtdexException, ModelException {
		File file = new File(config.getItemsFolderPath() + PersistenceXtextConstants.FILE_SEPARATOR + name + PersistenceXtextConstants.ITEMS_FILE_EXTENSION);
		return byFile(file);
	}
	
	@Override
	public List<ItemResource> all() throws IOException, ModelXtdexException, ModelException {
		List<ItemResource> list = Lists.newArrayList();
		String dirPath = config.getItemsFolderPath();
		File directory = new File(dirPath);
		List<File> files = IOUtils.listRegularFileNames(directory, PersistenceXtextConstants.ITEMS_FILE_EXTENSION);
		for (File file : files) {
			ItemResource ir = byFile(file);
			list.add(ir);
		}
		return list;
	}
	
	@Override
	public List<String> nameList() {
		String dirPath = config.getItemsFolderPath();
		File directory = new File(dirPath);
		List<File> files = IOUtils.listRegularFileNames(directory, PersistenceXtextConstants.ITEMS_FILE_EXTENSION);
		List<String> names = IOUtils.listBaseNamesWithoutExtension(files, PersistenceXtextConstants.ITEMS_FILE_EXTENSION);
		return names;
	}
	
	private ItemResource byFile(File file) throws IOException, ModelXtdexException, ModelException {
		List<String> list = IOUtils.readAll(file);
		ItemResource result = xtdex.fromXtext(list);
		return result;
	}

}
