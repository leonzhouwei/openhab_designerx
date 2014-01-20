package org.openhab.designerx.model.items.producer.impl;

import org.junit.Test;
import org.openhab.designerx.model.ModelException;
import org.openhab.designerx.model.items.Item;
import org.openhab.designerx.model.items.ItemResource;
import org.openhab.designerx.model.items.producer.ItemFactory;
import org.openhab.designerx.model.items.producer.ItemResourceBuilder;

public class ItemResourceImplTest {
	private static final ItemResourceBuilder resBuilder = new ItemResourceBuilderImpl();
	private static final ItemFactory itemFactory = new ItemFactoryImpl();

	@Test
	public void testAppend_1() throws ModelException {
		ItemResource ir = resBuilder.build();
		Item first = itemFactory.createGroupItem("All");
		ir.append(first);
	}
	
	@Test
	public void testAppend_2() throws ModelException {
		ItemResource ir = resBuilder.build();
		Item first = itemFactory.createGroupItem("All");
		ir.append(first);
		Item duplicateNameItem = itemFactory.createDimmerItem("All");
		ir.append(duplicateNameItem);
	}

}
