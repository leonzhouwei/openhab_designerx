package org.openhab.designerx.model.xtext.sitemap;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerx.model.sitemap.Text;
import org.openhab.designerx.model.sitemap.impl.TextBuilder;
import org.openhab.designerx.model.xtext.sitemap.ColorArrayXtdex;
import org.openhab.designerx.model.xtext.sitemap.PropertyHandler;
import org.openhab.designerx.model.xtext.sitemap.TextXtdex;

public class TextXtdexTest {

	@Test
	public void testFromXtext() {
		final String xtext = "Text item=Weather_Temperature valuecolor=[Weather_LastUpdate==\"Uninitialized\"=\"lightgray\",Weather_LastUpdate>90=\"lightgray\",>25=\"orange\",>15=\"green\",>5=\"orange\",<=5=\"blue\"] {";
		final Text expected = new TextBuilder().build();
		expected.setItem(PropertyHandler.getValue(xtext, "item"));
		expected.addValueColor(ColorArrayXtdex.fromXtext(xtext, "valuecolor"));
		final Text actual = TextXtdex.fromXtext(xtext);
		assertThat(expected.equalsLogically(actual), Matchers.equalTo(true));
	}

}
