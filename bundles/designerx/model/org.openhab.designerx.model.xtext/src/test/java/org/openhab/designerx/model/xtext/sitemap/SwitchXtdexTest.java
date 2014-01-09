package org.openhab.designerx.model.xtext.sitemap;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerx.model.sitemap.Switch;
import org.openhab.designerx.model.sitemap.impl.SwitchBuilder;
import org.openhab.designerx.model.xtext.sitemap.MappingsXtdex;
import org.openhab.designerx.model.xtext.sitemap.PropertyHandler;
import org.openhab.designerx.model.xtext.sitemap.SwitchXtdex;

public class SwitchXtdexTest {

	@Test
	public void testFromXtext() {
		final String xtext = 
			"Switch item=Weather_Chart_Period label=\"Chart Period\" mappings=[0=\"Hour\", 1=\"Day\", 2=\"Week\"]";
		final Switch expected = new SwitchBuilder().build();
		expected.setItem(PropertyHandler.getValue(xtext, "item"));
		expected.setLabel(PropertyHandler.getValueBetweenDoubleQuotes(xtext, "label"));
		expected.addMappings(MappingsXtdex.fromXtext(xtext));
		final Switch actual = SwitchXtdex.fromXtext(xtext);
		assertThat(expected.equalsLogically(actual), Matchers.equalTo(true));
	}

}
