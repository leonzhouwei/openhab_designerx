package org.openhab.designerx.persistence.xtext.items.repo.impl;

import java.io.File;
import java.util.List;

import org.openhab.designerx.config.Config;
import org.openhab.designerx.config.impl.ConfigFactory;
import org.openhab.designerx.persistence.xtext.PersistenceXtextConstants;
import org.openhab.designerx.persistence.xtext.items.XtextItemResource;
import org.openhab.designerx.persistence.xtext.items.repo.XtextItemResourceRepository;
import org.openhab.designerx.util.IOUtils;

final class XtextItemResourceRepositoryImpl implements XtextItemResourceRepository {
	private static final XtextItemResourceRepository instance = new XtextItemResourceRepositoryImpl();
	private static final Config config = ConfigFactory.create();
	
	static XtextItemResourceRepository getInstance() {
		return instance;
	}

	@Override
	public XtextItemResource find(String name) {
		return new XtextItemResourceImpl(name);
	}
	
	private XtextItemResourceRepositoryImpl() {}

	@Override
	public List<String> listNames() {
		String dirPath = config.getItemsFolderPath();
		File directory = new File(dirPath);
		List<File> files = IOUtils.listRegularFileNames(directory, PersistenceXtextConstants.ITEMS_FILE_EXTENSION);
		List<String> names = IOUtils.listBaseNamesWithoutExtension(files, PersistenceXtextConstants.ITEMS_FILE_EXTENSION);
		return names;
	}

}
