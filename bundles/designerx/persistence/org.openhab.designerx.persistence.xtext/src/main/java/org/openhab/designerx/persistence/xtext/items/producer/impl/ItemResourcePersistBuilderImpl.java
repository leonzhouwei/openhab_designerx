package org.openhab.designerx.persistence.xtext.items.producer.impl;

import org.openhab.designerx.model.items.Item;
import org.openhab.designerx.model.items.ItemResource;
import org.openhab.designerx.persistence.xtext.items.ItemResourcePersist;
import org.openhab.designerx.persistence.xtext.items.producer.ItemResourcePersistBuilder;

public final class ItemResourcePersistBuilderImpl implements ItemResourcePersistBuilder {

	@Override
	public ItemResourcePersist build(String name) {
		return new ItemResourcePersistImpl(name);
	}
	
	private class ItemResourcePersistImpl implements ItemResourcePersist {
		private String name;
		
		public ItemResourcePersistImpl(String name) {
			this.name = name;
		}

		@Override
		public ItemResource get() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void append(Item item) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void save(ItemResource ir) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
