package org.openhab.designerx.persistence.xtext.items;

import java.io.IOException;

import org.junit.Test;
import org.openhab.designerx.model.items.ItemResource;
import org.openhab.designerx.model.xtdex.items.ItemResourceXtdex;
import org.openhab.designerx.model.xtdex.items.producer.ItemResourceXtdexBuilder;
import org.openhab.designerx.model.xtdex.items.producer.impl.ItemResourceXtdexBuilderImpl;
import org.openhab.designerx.persistence.xtext.items.producer.ItemResourcePersistBuilder;
import org.openhab.designerx.persistence.xtext.items.producer.impl.ItemResourcePersistBuilderImpl;

public class ItemResourcePersistTest {
	private static final ItemResourcePersistBuilder persistBuilder = new ItemResourcePersistBuilderImpl();
	private static final ItemResourceXtdexBuilder xtdexBuilder = new  ItemResourceXtdexBuilderImpl();

	@Test
	public void testGet() throws IOException {
		final String name = "demo";
		ItemResourcePersist persist = persistBuilder.build(name);
		ItemResource ir = persist.get();
		ItemResourceXtdex irx = xtdexBuilder.build();
		System.out.println(irx.toXtext(ir));
	}

}
