package org.openhab.designerx.persistence.xtext.items.producer.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openhab.designerx.config.Config;
import org.openhab.designerx.config.ConfigBuilder;
import org.openhab.designerx.model.items.Item;
import org.openhab.designerx.model.items.ItemResource;
import org.openhab.designerx.model.xtdex.items.ItemResourceXtdex;
import org.openhab.designerx.model.xtdex.items.ItemXtdex;
import org.openhab.designerx.model.xtdex.items.producer.ItemResourceXtdexBuilder;
import org.openhab.designerx.model.xtdex.items.producer.ItemXtdexBuilder;
import org.openhab.designerx.model.xtdex.items.producer.impl.ItemResourceXtdexBuilderImpl;
import org.openhab.designerx.model.xtdex.items.producer.impl.ItemXtdexBuilderImpl;
import org.openhab.designerx.persistence.xtext.PersistenceXtextConstants;
import org.openhab.designerx.persistence.xtext.items.ItemResourcePersist;
import org.openhab.designerx.persistence.xtext.items.producer.ItemResourcePersistBuilder;
import org.openhab.designerx.util.IOUtils;

public final class ItemResourcePersistBuilderImpl implements ItemResourcePersistBuilder {

	@Override
	public ItemResourcePersist build(String name) {
		return new ItemResourcePersistImpl(name);
	}
	
	private class ItemResourcePersistImpl implements ItemResourcePersist {
		private String name;
		private Config config;
		private ItemResourceXtdexBuilder builder = new ItemResourceXtdexBuilderImpl();
		private ItemResourceXtdex xtdex = builder.build();
		private ItemXtdexBuilder itemXtdexBuilder = new ItemXtdexBuilderImpl();
		private ItemXtdex itemXtdex = itemXtdexBuilder.build();
		
		public ItemResourcePersistImpl(String name) {
			config = ConfigBuilder.build();
			this.name = name;
		}

		@Override
		public ItemResource get() throws IOException {
			File file = new File(config.getItemsFolderPath() + PersistenceXtextConstants.FILE_SEPARATOR + name + PersistenceXtextConstants.DOT_ITEMS);
			List<String> list = IOUtils.readAll(file);
			ItemResource result = xtdex.fromXtext(list);
			return result;
		}

		@Override
		public void append(Item item) throws IOException {
			String string = itemXtdex.toXtext(item);
			File file = new File(config.getItemsFolderPath() + PersistenceXtextConstants.FILE_SEPARATOR + name + PersistenceXtextConstants.DOT_ITEMS);
			IOUtils.append(file, string);
		}

		@Override
		public void save(ItemResource ir) throws IOException {
			String xtext = xtdex.toXtext(ir);
			File file = new File(config.getItemsFolderPath() + PersistenceXtextConstants.FILE_SEPARATOR + name + PersistenceXtextConstants.DOT_ITEMS);
			IOUtils.write(file, xtext);
		}
		
	}

}
