package org.openhab.designerx.model.xtext.sitemap;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerx.model.sitemap.Group;
import org.openhab.designerx.model.sitemap.impl.GroupBuilder;
import org.openhab.designerx.model.xtext.sitemap.GroupXtdex;

public class GroupXtdexTest {

	@Test
	public void testFromXtextWithoutChildren() {
		final String item = "anItem";
		final String label = "aLabel";
		final String icon = "anIcon";
		final String xtext = "Group item=anItem label=\"aLabel\" icon=\"anIcon\"";
		final Group expected = new GroupBuilder().build();
		expected.setItem(item);
		expected.setLabel(label);
		expected.setIcon(icon);
		final Group actual = GroupXtdex.fromXtextWithoutChildren(xtext);
		assertThat(expected.equalsLogically(actual), Matchers.equalTo(true));
	}

}
