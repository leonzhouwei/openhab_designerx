package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import java.util.List;

import org.junit.Test;
import org.openhab.designerx.model.sitemap.Element;
import org.openhab.designerx.model.xtdex.ModelXtdexException;

import com.google.common.collect.Lists;

public class ChildfulElementXtdexTest {

	@Test
	public void testParse() throws ModelXtdexException {
		List<String> list = Lists.newArrayList();
		list.add("Frame {");
		list.add("    Group item=gFF label=\"First Floor\" icon=\"firstfloor\"");
		list.add("}");
		ChildfulElementXtextKeeper keeper = new ChildfulElementXtextKeeper(list);
//		for (String s : keeper.getXtext()) {
//			System.out.println(s);
//		}
		Element e = ChildfulElementXtdex.parse(keeper);
		System.out.println(e.getChildren().size());
		String actual = ChildfulElementXtdex.toXtext(e);
		System.out.println(actual);
	}

}
