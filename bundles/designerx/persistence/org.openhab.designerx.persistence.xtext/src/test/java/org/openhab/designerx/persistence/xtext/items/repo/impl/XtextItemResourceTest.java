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
import org.openhab.designerx.util.StringHelper;

import com.google.common.collect.Lists;

public class XtextItemResourceTest {
	private static final RealXtextItemResourceRepositoryImpl repo = RealXtextItemResourceRepositoryImpl.getInstance();
	private static final ItemResourceXtdex xtdex = new ItemResourceXtdexImpl();

	@Test
	public void testFind() throws IOException, ModelXtdexException, ModelException {
		StringHelper.printSeparateLine();
		XtextItemResource expected = repo.find("demo");
		System.out.println(xtdex.toXtext(expected.itemResourceReplica()));
	}
	
//	@Test
	public void testFindOrCreate() throws Exception {
		final String name = "demo";
		// 根据名称查找或创建XtextItemResource
		XtextItemResource xir = repo.findOrCreate(name);
		// 用于反序列化的文本
		List<String> list = Lists.newArrayList();
		list.add("Group All");
		list.add("Group gGF (All)");
		list.add("Rollershutter Shutter_GF_Living \"Livingroom\" <sofa> (gGF) {knx=\"1/0/16+0/0/16\"}");
		list.add("Switch Light_GF_Toilet_Mirror \"Mirror\" <mirrors> (gGF,All) {knx=\"1/0/15+0/0/15\"}");
		// ItemResource的反序列化
		ItemResource ir = xtdex.fromXtext(name, list);
		// 保存(到.items文件中)
		xir.save(ir);
	}

}
