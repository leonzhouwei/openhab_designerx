package org.openhab.designerx.model.xtext.sitemap;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerx.model.sitemap.Frame;
import org.openhab.designerx.model.sitemap.impl.FrameBuilder;
import org.openhab.designerx.model.xtext.sitemap.FrameXtdex;

public class FrameXtdexTest {

	@Test
	public void testFromXtext() {
		final String item = "anItem";
		final String label = "aLabel";
		final String icon = "anIcon";
		final String xtext = "Frame item=anItem label=\"aLabel\" icon=\"anIcon\"";
		final Frame expected = new FrameBuilder().build();
		expected.setItem(item);
		expected.setLabel(label);
		expected.setIcon(icon);
		final Frame actual = FrameXtdex.fromXtext(xtext);
		assertThat(expected.equalsLogically(actual), Matchers.equalTo(true));
	}

}
