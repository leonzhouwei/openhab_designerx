package org.openhab.designerx.domainobject.items.repo.impl;

import java.util.Set;

import org.junit.Test;
import org.openhab.designerx.util.StringHelper;

public class ItemResourceAggregateRepositoryImplTest {
	private ItemResourceAggregateRepositoryImpl repo = ItemResourceAggregateRepositoryImpl.getInstance();
	
	@Test
	public void test() {
		Set<String> names = repo.listNames();
		for (String name : names) {
			StringHelper.printSeparateLine();
			System.out.println(name);
			System.out.println(repo.findByName(name).toString());
		}
	}

}
