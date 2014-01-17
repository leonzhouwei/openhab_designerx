package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerx.model.sitemap.Chart;
import org.openhab.designerx.model.sitemap.producer.ElementFactory;
import org.openhab.designerx.model.sitemap.producer.impl.ElementFactoryImpl;
import org.openhab.designerx.model.xtdex.ModelXtdexException;

public class ElementFillerTest {
	private static ElementFactory factory = new ElementFactoryImpl();

	@Test
	public void testFillWithoutChildren() throws ModelXtdexException {
		final String item = "lalala";
		final String expected = "Chart item=" + item;
		NonNestableElementXtextKeeper keeper = new NonNestableElementXtextKeeper(expected);
		Chart e = factory.createChart();
		ElementFiller.fillWithoutChildren(e, keeper);
		final String actual = ElementXtextualizer.toXtextIgnoringChildren(e);
		assertThat(actual, Matchers.equalTo(expected));
	}

}
