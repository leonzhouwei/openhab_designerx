package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerx.model.sitemap.Chart;
import org.openhab.designerx.model.sitemap.producer.ElementFactory;
import org.openhab.designerx.model.sitemap.producer.impl.ElementFactoryImpl;

public class ElementXtextualizerTest {
	private static ElementFactory factory = new ElementFactoryImpl();

	@Test
	public void testToXtextIgnoringChildren() {
		final String expected = "Chart label=\"lalala\"";
		Chart e = factory.createChart();
		e.setLabel("lalala");
		final String actual = ElementXtextualizer.toXtextIgnoringChildren(e);
		assertThat(actual, Matchers.equalTo(expected));
	}

}
