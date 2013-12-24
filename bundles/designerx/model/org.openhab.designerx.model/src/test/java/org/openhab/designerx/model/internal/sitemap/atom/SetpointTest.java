package org.openhab.designerx.model.internal.sitemap.atom;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerx.model.internal.sitemap.node.atom.Setpoint;

public class SetpointTest {

	@Test
	public void testParse() {
		final String expected = "Setpoint item=Temperature_Setpoint minValue=16 maxValue=28 step=0.5";
		Setpoint sitemapElement = Setpoint.parse(expected);
		String actual = sitemapElement.toXtext();
		assertThat(actual, Matchers.equalTo(expected));
	}

}
