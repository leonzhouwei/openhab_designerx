package org.openhab.designerx.persistence.xtext.items.repo.impl;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.openhab.designerx.model.ModelException;
import org.openhab.designerx.model.items.ItemResource;
import org.openhab.designerx.model.xtdex.ModelXtdexException;
import org.openhab.designerx.model.xtdex.items.ItemResourceXtdex;
import org.openhab.designerx.model.xtdex.items.impl.ItemResourceXtdexImpl;
import org.openhab.designerx.persistence.xtext.items.XtextItemResource;
import org.openhab.designerx.persistence.xtext.items.repo.XtextItemResourceRepository;
import org.openhab.designerx.util.StringHelper;

public class ItemResourcePersistTest {
	private static final XtextItemResourceRepository persistBuilder = XtextItemResourceRepositoryImpl.getInstance();
	private static final ItemResourceXtdex xtdex = new ItemResourceXtdexImpl();

	@Test
	public void testGet() throws IOException, ModelXtdexException, ModelException {
		XtextItemResource persist = persistBuilder.find("demo");
		ItemResource ir = persist.get();
		StringHelper.printSeparateLine();
		System.out.println(xtdex.toXtext(ir));
	}
	
	@Test
	public void testListNames() throws IOException {
		StringHelper.printSeparateLine();
		List<String> names = persistBuilder.nameList();
		for (String name : names) {
			System.out.println(name);
		}
	}

}
