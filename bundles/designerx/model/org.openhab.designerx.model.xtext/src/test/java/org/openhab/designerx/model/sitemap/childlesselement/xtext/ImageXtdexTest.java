package org.openhab.designerx.model.sitemap.childlesselement.xtext;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerx.model.sitemap.Image;
import org.openhab.designerx.model.sitemap.impl.ImageBuilder;

public class ImageXtdexTest {

	@Test
	public void testFromXtext() {
		final String item = "anItem";
		final String label = "aLabel";
		final String icon = "anIcon";
		final String xtext = "Image item=anItem label=\"aLabel\" icon=\"anIcon\"";
		final Image expected = new ImageBuilder().build();
		expected.setItem(item);
		expected.setLabel(label);
		expected.setIcon(icon);
		final Image actual = ImageXtdex.fromXtext(xtext);
		assertThat(expected.equalsLogically(actual), Matchers.equalTo(true));
	}

}
