package org.openhab.designerx.repo.queryrepo.impl;

import java.util.List;

import org.junit.Test;
import org.openhab.designerx.model.items.ItemResource;
import org.openhab.designerx.model.xtdex.items.ItemResourceXtdex;
import org.openhab.designerx.model.xtdex.items.impl.ItemResourceXtdexImpl;
import org.openhab.designerx.repo.queryrepo.ItemResourceQueryRepo;
import org.openhab.designerx.util.StringHelper;

public class ItemResourceQueryRepoImplTest {
	private static final ItemResourceXtdex xtdex = new ItemResourceXtdexImpl();
	private static final ItemResourceQueryRepo repo = ItemResourceQueryRepoImpl.getInstance();

	@Test
	public void testListAllAsReplicas() {
		List<ItemResource> list = repo.listAllAsReplicas();
		for (ItemResource ir : list) {
			StringHelper.printSeparateLine();
			System.out.println(xtdex.toXtext(ir));
		}
	}

	@Test
	public void testGetReplicaByName() {
		ItemResource ir = repo.getReplicaByName("test");
		StringHelper.printSeparateLine();
		System.out.println(xtdex.toXtext(ir));
	}

}
