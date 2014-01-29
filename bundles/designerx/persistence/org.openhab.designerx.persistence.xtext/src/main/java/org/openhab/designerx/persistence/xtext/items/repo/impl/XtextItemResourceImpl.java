package org.openhab.designerx.persistence.xtext.items.repo.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openhab.designerx.config.Config;
import org.openhab.designerx.config.impl.ConfigImpl;
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
	private Config config = ConfigImpl.getInstance();
	private final ItemResourceXtdex xtdex = new ItemResourceXtdexImpl();
	private ItemResource itemResource;
	
	XtextItemResourceImpl(String name) throws IOException, ModelXtdexException, ModelException {
		file = new File(config.getItemsFolderPath() + PersistenceXtextConstants.FILE_SEPARATOR + name + PersistenceXtextConstants.ITEMS_FILE_EXTENSION);
		List<String> list = IOUtils.readAll(file);
		itemResource = xtdex.fromXtext(name, list);
	}
	
	@Override
	public ItemResource itemResourceReplica() throws IOException, ModelXtdexException, ModelException {
		String name = itemResource.name();
		ItemResource result = xtdex.fromXtext(name, xtdex.toXtext(itemResource));
		return result;
	}

	@Override
	public void save(ItemResource ir) throws IOException, ModelException {
		String xtext = xtdex.toXtext(ir);
		IOUtils.write(file, xtext);
		this.itemResource = ir;
	}

}
