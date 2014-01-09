package org.openhab.designerx.model.sitemap.childlesselement.xtext;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerx.model.sitemap.Slider;
import org.openhab.designerx.model.sitemap.impl.SliderBuilder;

public class SliderXtdexTest {

	@Test
	public void testFromXtext() {
		final String item = "DimmedLight";
		final String xtext = "Slider item=DimmedLight switchSupport";
		final Slider expected = new SliderBuilder().build();
		expected.setItem(item);
		expected.setSwitchEnabled(true);
		final Slider actual = SliderXtdex.fromXtext(xtext);
		System.out.println(SliderXtdex.toXtext(expected));
		assertThat(expected.equalsLogically(actual), Matchers.equalTo(true));
	}

}
