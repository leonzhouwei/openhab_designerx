package org.openhab.designerx.persistence.xtext.items.repo.impl;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.openhab.designerx.model.ModelException;
import org.openhab.designerx.model.items.ItemResource;
import org.openhab.designerx.model.xtdex.ModelXtdexException;
import org.openhab.designerx.model.xtdex.items.ItemResourceXtdex;
import org.openhab.designerx.model.xtdex.items.producer.ItemResourceXtdexBuilder;
import org.openhab.designerx.model.xtdex.items.producer.impl.ItemResourceXtdexBuilderImpl;
import org.openhab.designerx.persistence.xtext.items.XtextItemResource;
import org.openhab.designerx.persistence.xtext.items.repo.XtextItemResourceRepository;
import org.openhab.designerx.util.StringHelper;

public class ItemResourcePersistTest {
	private static final XtextItemResourceRepository persistBuilder = XtextItemResourceRepositoryImpl.getInstance();
	private static final ItemResourceXtdexBuilder xtdexBuilder = new  ItemResourceXtdexBuilderImpl();

	@Test
	public void testGet() throws IOException, ModelXtdexException, ModelException {
		File file = new File("_test/resources/demo.items");
		XtextItemResource persist = persistBuilder.find(file);
		ItemResource ir = persist.get();
		StringHelper.printSeparateLine();
		ItemResourceXtdex irx = xtdexBuilder.build();
		StringHelper.printSeparateLine();
		System.out.println(irx.toXtext(ir));
	}
	
//	@Test
	public void testSave() throws IOException {
	}

}
