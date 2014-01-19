package org.openhab.designerx.persistence.xtext.items.producer.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openhab.designerx.config.Config;
import org.openhab.designerx.config.ConfigBuilder;
import org.openhab.designerx.model.ModelException;
import org.openhab.designerx.model.items.ItemResource;
import org.openhab.designerx.model.xtdex.ModelXtdexException;
import org.openhab.designerx.model.xtdex.items.ItemResourceXtdex;
import org.openhab.designerx.model.xtdex.items.producer.ItemResourceXtdexBuilder;
import org.openhab.designerx.model.xtdex.items.producer.impl.ItemResourceXtdexBuilderImpl;
import org.openhab.designerx.persistence.xtext.PersistenceXtextConstants;
import org.openhab.designerx.persistence.xtext.items.ItemResourcePersist;
import org.openhab.designerx.persistence.xtext.items.producer.ItemResourcePersistBuilder;
import org.openhab.designerx.util.IOUtils;

public final class ItemResourcePersistBuilderImpl implements ItemResourcePersistBuilder {

	@Override
	public ItemResourcePersist build(String name) {
		return new ItemResourcePersistImpl(name);
	}
	
	@Override
	public ItemResourcePersist build(File file) {
		return new ItemResourcePersistImpl(file);
	}
	
	private class ItemResourcePersistImpl implements ItemResourcePersist {
		private File file;
		private Config config = ConfigBuilder.build();
		private ItemResourceXtdexBuilder builder = new ItemResourceXtdexBuilderImpl();
		private ItemResourceXtdex xtdex = builder.build();
		
		public ItemResourcePersistImpl(String name) {
			file = new File(config.getItemsFolderPath() + PersistenceXtextConstants.FILE_SEPARATOR + name + PersistenceXtextConstants.ITEMS_FILE_EXTENSION);
		}
		
		public ItemResourcePersistImpl(File file) {
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

}
