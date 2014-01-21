package org.openhab.designerx.persistence.xtext.items.repo.impl;

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
import org.openhab.designerx.persistence.xtext.items.XtextItemResource;
import org.openhab.designerx.util.IOUtils;

final class XtextItemResourceImpl implements XtextItemResource {
	private File file;
	private Config config = ConfigFactory.create();
	private final ItemResourceXtdex xtdex = new ItemResourceXtdexImpl();
	
	public XtextItemResourceImpl(String name) {
		file = new File(config.getItemsFolderPath() + PersistenceXtextConstants.FILE_SEPARATOR + name + PersistenceXtextConstants.ITEMS_FILE_EXTENSION);
	}
	
	public XtextItemResourceImpl(File file) {
		this.file = file;
	}

	@Override
	public ItemResource get() throws IOException, ModelXtdexException, ModelException {
		List<String> list = IOUtils.readAll(file);
		ItemResource result = xtdex.fromXtext(list);
		return result;
	}

	@Override
	public void save(ItemResource ir) throws IOException, ModelException {
		String xtext = xtdex.toXtext(ir);
		IOUtils.write(file, xtext);
	}

}
