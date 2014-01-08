package org.openhab.designerx.model.sitemap.childlesselement.xtext;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerx.model.sitemap.Colorpicker;
import org.openhab.designerx.model.sitemap.impl.ColorpickerBuilder;

public class ColorpickerXtdexTest {

	@Test
	public void testFromXtext() {
		final String item = "a";
		final String label = "b";
		final String icon = "c";
		final int frequency = 1;
		final String xtext = "Colorpicker item=a label=\"b\" icon=\"c\" frequency=1";
		final Colorpicker expected = new ColorpickerBuilder().build();
		expected.setItem(item);
		expected.setLabel(label);
		expected.setIcon(icon);
		expected.setFrequency(frequency);
		final Colorpicker actual = ColorpickerXtdex.fromXtext(xtext);
		assertThat(expected.equalsLogically(actual), Matchers.equalTo(true));
	}
	
}
