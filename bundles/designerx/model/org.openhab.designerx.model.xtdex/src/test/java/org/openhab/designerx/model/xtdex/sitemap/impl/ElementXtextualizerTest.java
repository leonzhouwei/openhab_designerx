package org.openhab.designerx.model.xtdex.sitemap.impl;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerx.model.sitemap.Chart;
import org.openhab.designerx.model.sitemap.SitemapElementFactory;
import org.openhab.designerx.model.sitemap.impl.SitemapElementFactoryImpl;
import org.openhab.designerx.model.xtdex.sitemap.impl.ElementXtextualizer;

public class ElementXtextualizerTest {
	private static SitemapElementFactory factory = new SitemapElementFactoryImpl();

	@Test
	public void testToXtextIgnoringChildren() {
		final String item = "lalala";
		final String expected = "Chart item=" + item;
		Chart e = factory.createChart();
		e.setItem(item);
		final String actual = ElementXtextualizer.toXtextIgnoringChildren(e);
		assertThat(actual, Matchers.equalTo(expected));
	}

}
