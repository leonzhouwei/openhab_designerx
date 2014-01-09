package org.openhab.designerx.model.sitemap.childlesselement.xtext;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerx.model.sitemap.Image;
import org.openhab.designerx.model.sitemap.impl.ImageBuilder;

public class ImageXtdexTest {

	@Test
	public void testFromXtext() {
		final String xtext = "Image url=\"http://localhost:8080/images/splash-ipad-h.png\" label=\"openHAB\"";
		final String label = PropertyHandler.getValueBetweenDoubleQuotes(xtext, "label");
		final String url = PropertyHandler.getValueBetweenDoubleQuotes(xtext, "url");
		final Image expected = new ImageBuilder().build();
		expected.setLabel(label);
		expected.setUrl(url);
		final Image actual = ImageXtdex.fromXtext(xtext);
		assertThat(expected.equalsLogically(actual), Matchers.equalTo(true));
	}

}
