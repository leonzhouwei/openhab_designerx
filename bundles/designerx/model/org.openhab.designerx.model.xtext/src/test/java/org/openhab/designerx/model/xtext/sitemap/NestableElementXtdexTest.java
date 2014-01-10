package org.openhab.designerx.model.xtext.sitemap;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerx.model.sitemap.NestableElement;

import com.google.common.collect.Lists;

public class NestableElementXtdexTest {

	@Test
	public void testFromXtextString() {
	}

	@Test
	public void testIsNestableElement() {
	}

	@Test
	public void testFromXtextListOfString() {
		List<String> list = Lists.newArrayList();
		list.add("Frame {");
//		list.add("    Text label=\"Group Demo\" icon=\"firstfloor\" {");
		list.add("        Switch item=Lights mappings=[OFF=\"All Off\"]");
		list.add("        Group item=Heating");
		list.add("        Group item=Windows");
		list.add("        Text item=Temperature");
//		list.add("    }");
		list.add("}");
		NestableElement root = NestableElementXtdex.fromXtext(list);
		System.out.println(NestableElementXtdex.toXtext(root, ""));
	}

//	@Test
	public void testEndIndexOf() {
		List<String> list = Lists.newArrayList();
		list.add("Frame {");
		list.add("    Text");
		list.add("    Frame {");
		list.add("        Setpoint");
		list.add("    }");
		list.add("}");
		assertThat(NestableElementXtdex.endIndexOf(list, 0), Matchers.equalTo(5));
		assertThat(NestableElementXtdex.endIndexOf(list, 2), Matchers.equalTo(4));
	}

}
