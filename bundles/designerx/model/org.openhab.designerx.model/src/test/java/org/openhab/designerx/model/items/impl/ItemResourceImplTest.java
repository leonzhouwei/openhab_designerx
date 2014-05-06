package org.openhab.designerx.model.items.impl;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerx.model.ModelException;
import org.openhab.designerx.model.items.Item;
import org.openhab.designerx.model.items.ItemFactory;
import org.openhab.designerx.model.items.ItemResource;

public class ItemResourceImplTest {
	private static final ItemFactory itemFactory = new ItemFactoryImpl();

	@Test
	public void testAppend_1() throws ModelException {
		ItemResource ir = new ItemResourceImpl("test");
		Item group = itemFactory.createGroupItem("All");
		ir.append(group);
		System.out.println(group.getTypeName());
		System.out.println(group.getName());
	}
	
//	@Test
	public void testAppend_2() throws ModelException {
		ItemResource ir = new ItemResourceImpl("test");
		Item first = itemFactory.createGroupItem("All");
		ir.append(first);
		Item duplicateNameItem = itemFactory.createDimmerItem("All");
		ir.append(duplicateNameItem);
	}

}
