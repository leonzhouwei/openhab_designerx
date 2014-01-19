package org.openhab.designerx.model.items;

import org.junit.Test;
import org.openhab.designerx.model.items.producer.ItemFactory;
import org.openhab.designerx.model.items.producer.ItemResourceBuilder;
import org.openhab.designerx.model.items.producer.impl.ItemFactoryImpl;
import org.openhab.designerx.model.items.producer.impl.ItemResourceBuilderImpl;
import org.openhab.designerx.model.sitemap.Group;

public class ItemResourceTest {
	private static final ItemResourceBuilder resBuilder = new ItemResourceBuilderImpl();
	private static final ItemFactory itemFactory = new ItemFactoryImpl();

	@Test
	public void testAppend() {
	}

}
