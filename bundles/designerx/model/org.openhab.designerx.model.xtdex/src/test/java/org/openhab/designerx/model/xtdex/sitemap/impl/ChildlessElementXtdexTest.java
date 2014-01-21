package org.openhab.designerx.model.xtdex.sitemap.impl;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerx.model.sitemap.Element;
import org.openhab.designerx.model.xtdex.ModelXtdexException;
import org.openhab.designerx.model.xtdex.sitemap.impl.ChildlessElementXtdex;
import org.openhab.designerx.model.xtdex.sitemap.impl.ChildlessElementXtextKeeper;

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
	public void testParse_3() throws ModelXtdexException {
		final String xtext = "List item=aList";
		ChildlessElementXtextKeeper keeper = new ChildlessElementXtextKeeper(xtext);
		Element e = ChildlessElementXtdex.parse(keeper);
		final String actual = ChildlessElementXtdex.toXtext(e);
		assertThat(actual, Matchers.equalTo(xtext));
	}
	
	@Test
	public void testParse_4() throws ModelXtdexException {
		final String xtext = "Selection item=Radio_Station mappings=[0=off,1=HR3,2=SWR3,3=FFH]";
		ChildlessElementXtextKeeper keeper = new ChildlessElementXtextKeeper(xtext);
		Element e = ChildlessElementXtdex.parse(keeper);
		final String actual = ChildlessElementXtdex.toXtext(e);
		assertThat(actual, Matchers.equalTo(xtext));
	}
	
	@Test
	public void testParse_5() throws ModelXtdexException {
		final String xtext = "Setpoint item=Temperature_Setpoint minValue=16 maxValue=28 step=0.5";
		ChildlessElementXtextKeeper keeper = new ChildlessElementXtextKeeper(xtext);
		Element e = ChildlessElementXtdex.parse(keeper);
		final String actual = ChildlessElementXtdex.toXtext(e);
		assertThat(actual, Matchers.equalTo(xtext));
	}
	
	@Test
	public void testParse_6() throws ModelXtdexException {
		final String xtext = "Switch item=Scene_General label=\"Scene\" mappings=[1=TV,2=Dinner,3=Reading]";
		ChildlessElementXtextKeeper keeper = new ChildlessElementXtextKeeper(xtext);
		Element e = ChildlessElementXtdex.parse(keeper);
		final String actual = ChildlessElementXtdex.toXtext(e);
		assertThat(actual, Matchers.equalTo(xtext));
	}
	
	@Test
	public void testParse_7() throws ModelXtdexException {
		final String xtext = "Video url=\"http://demo.openhab.org/Hue.m4v\"";
		ChildlessElementXtextKeeper keeper = new ChildlessElementXtextKeeper(xtext);
		Element e = ChildlessElementXtdex.parse(keeper);
		final String actual = ChildlessElementXtdex.toXtext(e);
		assertThat(actual, Matchers.equalTo(xtext));
	}
	
	@Test
	public void testParse_8() throws ModelXtdexException {
		final String xtext = "Webview url=\"http://heise-online.mobi/\" height=8";
		ChildlessElementXtextKeeper keeper = new ChildlessElementXtextKeeper(xtext);
		Element e = ChildlessElementXtdex.parse(keeper);
		final String actual = ChildlessElementXtdex.toXtext(e);
		assertThat(actual, Matchers.equalTo(xtext));
	}

}
