package org.openhab.designerx.model.xtext.childless;

import org.junit.Test;
import org.openhab.designerx.model.sitemap.Chart;

public class ChartXtdexTest {

	private final static String xtext = 
		"Chart item=Weather_Chart period=h refresh=600 visibility=[Weather_Chart_Period==0, Weather_Chart_Period==\"Uninitialized\"]";

	@Test
	public void testFromXtext() {
		Chart chart = ChartXtdex.fromXtext(xtext);
		System.out.println(ChartXtdex.toXtext(chart));
	}

	@Test
	public void testToXtext() {
		Chart chart = ChartXtdex.fromXtext(xtext);
		System.out.println(ChartXtdex.toXtext(chart));
	}

}
