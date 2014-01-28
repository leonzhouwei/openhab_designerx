package org.openhab.designerx.persistence.xtext.items.repo.impl;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.openhab.designerx.model.ModelException;
import org.openhab.designerx.model.items.ItemResource;
import org.openhab.designerx.model.xtdex.ModelXtdexException;
import org.openhab.designerx.model.xtdex.items.ItemResourceXtdex;
import org.openhab.designerx.model.xtdex.items.impl.ItemResourceXtdexImpl;
import org.openhab.designerx.util.StringHelper;

public class XtextItemResourceRepositoryImplTest {
	private static final XtextItemResourceRepositoryImpl repo = XtextItemResourceRepositoryImpl.getInstance();
	private static final ItemResourceXtdex xtdex = new ItemResourceXtdexImpl();

	@Test
	public void testByName() throws IOException, ModelXtdexException, ModelException {
		StringHelper.printSeparateLine();
		ItemResource result = repo.getReplicaByName("test");
		String xtext = xtdex.toXtext(result);
		System.out.println(xtext);
	}

	@Test
	public void testReplicas() throws IOException, ModelXtdexException, ModelException {
		StringHelper.printSeparateLine();
		List<ItemResource> result = repo.replicas();
		for (ItemResource ir : result) {
			String xtext = xtdex.toXtext(ir);
			System.out.println(xtext);
		}
	}

	@Test
	public void testNameSet() {
		StringHelper.printSeparateLine();
		Set<String> names = repo.nameSet();
		for (String name : names) {
			System.out.println(name);
		}
	}

}
