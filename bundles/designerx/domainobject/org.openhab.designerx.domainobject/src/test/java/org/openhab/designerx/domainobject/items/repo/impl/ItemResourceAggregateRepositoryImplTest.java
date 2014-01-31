package org.openhab.designerx.domainobject.items.repo.impl;

import java.util.Set;

import org.junit.Test;
import org.openhab.designerx.util.StringHelper;

public class ItemResourceAggregateRepositoryImplTest {
	private RealItemResourceAggregateRepositoryImpl repo = RealItemResourceAggregateRepositoryImpl.getInstance();
	
	@Test
	public void test() {
		StringHelper.printTestStartLine();
		Set<String> names = repo.nameSet();
		for (String name : names) {
			System.out.println(name);
			System.out.println(repo.findByName(name).toString());
		}
		StringHelper.printTestEndLine();
	}

}
