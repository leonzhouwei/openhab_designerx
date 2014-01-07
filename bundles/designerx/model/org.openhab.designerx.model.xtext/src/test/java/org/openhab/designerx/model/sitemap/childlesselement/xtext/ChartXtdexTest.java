package org.openhab.designerx.model.sitemap.childlesselement.xtext;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerx.model.sitemap.Chart;
import org.openhab.designerx.model.sitemap.VisibilityRule;
import org.openhab.designerx.model.sitemap.impl.ChartBuilder;

public class ChartXtdexTest {

	@Test
	public void testFromXtext() {
		final String expected = "Chart item=Weather_Chart visibility=[Weather_Chart_Period==0,Weather_Chart_Period==\"Uninitialized\"] period=h refresh=600";
		Chart chart = ChartXtdex.fromXtext(expected);
		final String actual = ChartXtdex.toXtext(chart);
		assertThat(actual, Matchers.equalTo(expected));
	}

	@Test
	public void testToXtext() {
		final String expected = "Chart item=Weather_Chart period=h refresh=600";
		Chart chart = new ChartBuilder().build();
		chart.setItem("Weather_Chart");
		chart.setPeriod("h");
		chart.setRefresh(600);
		final String actual = ChartXtdex.toXtext(chart);
		assertThat(actual, Matchers.equalTo(expected));
	}
	
	@Test
	public void testFromXtext_2() {
		final String expected = "Chart item=Weather_Chart visibility=[Weather_Chart_Period==0,Weather_Chart_Period==\"Uninitialized\"] period=h refresh=600";
		Chart chart = ChartXtdex.fromXtext(expected);
		final String actual = ChartXtdex.toXtext(chart);
		assertThat(actual, Matchers.equalTo(expected));
		Chart gen = new ChartBuilder().build();
		gen.setItem("Weather_Chart");
		List<VisibilityRule> visibility = VisibilityRulesXtdex.fromXtext("visibility=[Weather_Chart_Period==0,Weather_Chart_Period==\"Uninitialized\"]");
		gen.addVisibility(visibility);
		gen.setPeriod("h");
		gen.setRefresh(600);
		System.out.println(gen.equalsLogically(chart));
	}
	
}
