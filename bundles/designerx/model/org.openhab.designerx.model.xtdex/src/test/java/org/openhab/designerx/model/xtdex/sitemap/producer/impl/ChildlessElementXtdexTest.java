package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerx.model.sitemap.Element;
import org.openhab.designerx.model.xtdex.ModelXtdexException;

public class ChildlessElementXtdexTest {
	
	@Test
	public void testParse_1() throws ModelXtdexException {
		final String xtext = "Chart item=Weather_Chart visibility=[Weather_Chart_Period==0,Weather_Chart_Period==\"Uninitialized\"] period=h refresh=600";
		ChildlessElementXtextKeeper keeper = new ChildlessElementXtextKeeper(xtext);
		Element e = ChildlessElementXtdex.parse(keeper);
		final String actual = ChildlessElementXtdex.toXtext(e);
		assertThat(actual, Matchers.equalTo(xtext));
	}
	
	@Test
	public void testParse_2() throws ModelXtdexException {
		final String xtext = "Colorpicker item=RGBLight icon=\"slider\" sendFrequency=0";
		ChildlessElementXtextKeeper keeper = new ChildlessElementXtextKeeper(xtext);
		Element e = ChildlessElementXtdex.parse(keeper);
		final String actual = ChildlessElementXtdex.toXtext(e);
		assertThat(actual, Matchers.equalTo(xtext));
	}

	@Test
	public void testParse_12() throws ModelXtdexException {
		final String xtext = "Video url=\"http://demo.openhab.org/Hue.m4v\"";
		ChildlessElementXtextKeeper keeper = new ChildlessElementXtextKeeper(xtext);
		Element e = ChildlessElementXtdex.parse(keeper);
		final String actual = ChildlessElementXtdex.toXtext(e);
		assertThat(actual, Matchers.equalTo(xtext));
	}

}
