package org.openhab.designerx.model.sitemap.childlesselement.xtext;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerx.model.sitemap.Switch;
import org.openhab.designerx.model.sitemap.impl.SwitchBuilder;

public class SwitchXtdexTest {

	@Test
	public void testFromXtext() {
		final String xtext = 
			"Switch item=Weather_Chart_Period label=\"Chart Period\" mappings=[0=\"Hour\", 1=\"Day\", 2=\"Week\"]";
		final Switch expected = new SwitchBuilder().build();
		expected.setItem(PropertyHandler.getValueWithoutStartEndMarks(xtext, "item"));
		expected.setLabel(PropertyHandler.getValueBetweenDoubleQuotes(xtext, "label"));
		expected.addMappings(MappingsXtdex.fromXtext(xtext));
		final Switch actual = SwitchXtdex.fromXtext(xtext);
		assertThat(expected.equalsLogically(actual), Matchers.equalTo(true));
	}

}
