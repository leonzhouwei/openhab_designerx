package org.openhab.designerx.persistence.xtext.items.impl;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.openhab.designerx.model.ModelException;
import org.openhab.designerx.model.items.ItemResource;
import org.openhab.designerx.model.xtdex.ModelXtdexException;
import org.openhab.designerx.model.xtdex.items.ItemResourceXtdex;
import org.openhab.designerx.model.xtdex.items.impl.ItemResourceXtdexImpl;
import org.openhab.designerx.persistence.xtext.items.ItemResourceQuery;
import org.openhab.designerx.util.StringHelper;

public class ItemResourceQueryImplTest {
	private static final ItemResourceQuery query = new ItemResourceQueryImpl();
	private static final ItemResourceXtdex xtdex = new ItemResourceXtdexImpl();

	@Test
	public void testByName() throws IOException, ModelXtdexException, ModelException {
		StringHelper.printSeparateLine();
		ItemResource result = query.byName("demo");
		String xtext = xtdex.toXtext(result);
		System.out.println(xtext);
	}

	@Test
	public void testAll() throws IOException, ModelXtdexException, ModelException {
		List<ItemResource> result = query.all();
		for (ItemResource ir : result) {
			StringHelper.printSeparateLine();
			String xtext = xtdex.toXtext(ir);
			System.out.println(xtext);
		}
	}

	@Test
	public void testNameList() {
		StringHelper.printSeparateLine();
		List<String> names = query.nameList();
		for (String name : names) {
			System.out.println(name);
		}
	}

}
