package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerx.model.sitemap.Chart;
import org.openhab.designerx.model.sitemap.producer.ElementFactory;
import org.openhab.designerx.model.sitemap.producer.impl.ElementFactoryImpl;
import org.openhab.designerx.model.xtdex.ModelXtdexException;

public class ChartXtdexTest {
	private static ElementFactory factory = new ElementFactoryImpl();

	@Test
	public void testIsChart_1() {
		final String xtext = "Chart";
		boolean actual = ChartXtdex.isChart(xtext);
		assertThat(actual, Matchers.equalTo(true));
	}
	
	@Test
	public void testIsChart_2() throws ModelXtdexException {
		final String xtext = "Cha";
		boolean actual = ChartXtdex.isChart(xtext);
		assertThat(actual, Matchers.equalTo(false));
	}

	@Test
	public void testParseIgnoringChildren_1() throws ModelXtdexException {
		final String xtext = "Chart item=Weather_Chart refresh=0";
		ChildlessElementXtextKeeper keeper = new ChildlessElementXtextKeeper(xtext);
		Chart e = ChartXtdex.parseIgnoringChildren(keeper);
		String actual = ChartXtdex.toXtextIgnoringChildren(e);
		assertThat(actual, Matchers.equalTo(xtext));
	}
	
	@Test
	public void testParseIgnoringChildren() throws ModelXtdexException {
		final String xtext = "Chart item=Weather_Chart period=h refresh=600";
		ChildlessElementXtextKeeper keeper = new ChildlessElementXtextKeeper(xtext);
		Chart e = ChartXtdex.parseIgnoringChildren(keeper);
		String actual = ChartXtdex.toXtextIgnoringChildren(e);
		assertThat(actual, Matchers.equalTo(xtext));
	}

}
