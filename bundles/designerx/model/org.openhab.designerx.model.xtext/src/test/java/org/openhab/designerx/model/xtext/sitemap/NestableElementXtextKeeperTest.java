package org.openhab.designerx.model.xtext.sitemap;

import java.util.List;

import org.junit.Test;
import org.openhab.designerx.model.xtext.ModelXtextException;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

public class NestableElementXtextKeeperTest {

	@Test
	public void testGetXtext() throws ModelXtextException {
		List<String> list = Lists.newArrayList();
		list.add("Frame {");
		list.add("    Text");
		list.add("    Frame {");
		list.add("        Setpoint");
		list.add("    }");
		list.add("}");
		NestableElementXtextKeeper keeper = new NestableElementXtextKeeper(list);
		ImmutableList<String> il = keeper.getXtext();
		for (String s : il) {
			System.out.println(s);
		}
	}

}
