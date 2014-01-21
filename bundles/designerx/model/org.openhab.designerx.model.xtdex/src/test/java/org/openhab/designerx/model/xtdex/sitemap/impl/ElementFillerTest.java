package org.openhab.designerx.model.xtdex.sitemap.impl;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerx.model.sitemap.Chart;
import org.openhab.designerx.model.sitemap.SitemapElementFactory;
import org.openhab.designerx.model.sitemap.impl.SitemapElementFactoryImpl;
import org.openhab.designerx.model.xtdex.ModelXtdexException;
import org.openhab.designerx.model.xtdex.sitemap.impl.ChildlessElementXtextKeeper;
import org.openhab.designerx.model.xtdex.sitemap.impl.ElementFiller;
import org.openhab.designerx.model.xtdex.sitemap.impl.ElementXtextualizer;

public class ElementFillerTest {
	private static SitemapElementFactory factory = new SitemapElementFactoryImpl();
	
	@Test
	public void testFillWithoutChildren_1() throws ModelXtdexException {
		final String expected = "Chart";
		ChildlessElementXtextKeeper keeper = new ChildlessElementXtextKeeper(expected);
		Chart e = factory.createChart();
		ElementFiller.fillWithoutChildren(e, keeper);
		final String actual = ElementXtextualizer.toXtextIgnoringChildren(e);
		assertThat(actual, Matchers.equalTo(expected));
	}

	@Test
	public void testFillWithoutChildren_2() throws ModelXtdexException {
		final String expected = "Chart item=Weather_Chart";
		ChildlessElementXtextKeeper keeper = new ChildlessElementXtextKeeper(expected);
		Chart e = factory.createChart();
		ElementFiller.fillWithoutChildren(e, keeper);
		final String actual = ElementXtextualizer.toXtextIgnoringChildren(e);
		assertThat(actual, Matchers.equalTo(expected));
	}
	
	@Test
	public void testFillWithoutChildren_3() throws ModelXtdexException {
		final String expected = "Chart item=Weather_Chart valuecolor=[Weather_LastUpdate==\"Uninitialized\"=\"lightgray\",Weather_LastUpdate>90=\"lightgray\",>25=\"orange\",>15=\"green\",>5=\"orange\",<=5=\"blue\"]";
		ChildlessElementXtextKeeper keeper = new ChildlessElementXtextKeeper(expected);
		Chart e = factory.createChart();
		ElementFiller.fillWithoutChildren(e, keeper);
		final String actual = ElementXtextualizer.toXtextIgnoringChildren(e);
		assertThat(actual, Matchers.equalTo(expected));
	}
	
	@Test
	public void testFillWithoutChildren_4() throws ModelXtdexException {
		final String expected = "Chart item=Weather_Chart valuecolor=[Weather_LastUpdate==\"Uninitialized\"=\"lightgray\",Weather_LastUpdate>90=\"lightgray\",>25=\"orange\",>15=\"green\",>5=\"orange\",<=5=\"blue\"] visibility=[Weather_Chart_Period==0,Weather_Chart_Period==\"Uninitialized\"]";
		ChildlessElementXtextKeeper keeper = new ChildlessElementXtextKeeper(expected);
		Chart e = factory.createChart();
		ElementFiller.fillWithoutChildren(e, keeper);
		final String actual = ElementXtextualizer.toXtextIgnoringChildren(e);
		assertThat(actual, Matchers.equalTo(expected));
	}

}
