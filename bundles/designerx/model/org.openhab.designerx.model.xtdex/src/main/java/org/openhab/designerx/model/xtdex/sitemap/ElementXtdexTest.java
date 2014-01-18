package org.openhab.designerx.model.xtdex.sitemap;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerx.model.sitemap.Chart;
import org.openhab.designerx.model.sitemap.Colorpicker;
import org.openhab.designerx.model.sitemap.Element;
import org.openhab.designerx.model.sitemap.List;
import org.openhab.designerx.model.sitemap.Selection;
import org.openhab.designerx.model.sitemap.Setpoint;
import org.openhab.designerx.model.sitemap.Slider;
import org.openhab.designerx.model.sitemap.Switch;
import org.openhab.designerx.model.sitemap.Video;
import org.openhab.designerx.model.sitemap.Webview;
import org.openhab.designerx.model.xtdex.ModelXtdexException;
import org.openhab.designerx.model.xtdex.sitemap.producer.impl.ElementXtdexBuilderImpl;

public class ElementXtdexTest {
	private ElementXtdex xtdex = new ElementXtdexBuilderImpl().build();

	@Test
	public void testParseChart() throws ModelXtdexException {
		final String xtext = "Chart item=Weather_Chart visibility=[Weather_Chart_Period==0,Weather_Chart_Period==\"Uninitialized\"] period=h refresh=600";
		Chart e = (Chart) xtdex.parse(xtext);
		final String actual = xtdex.toXtext(e);
		assertThat(actual, Matchers.equalTo(xtext));
	}

	@Test
	public void testParseColorpicker() throws ModelXtdexException {
		final String xtext = "Colorpicker item=RGBLight icon=\"slider\" sendFrequency=0";
		Colorpicker e = (Colorpicker) xtdex.parse(xtext);
		final String actual = xtdex.toXtext(e);
		assertThat(actual, Matchers.equalTo(xtext));
	}

	@Test
	public void testParseFrame() throws ModelXtdexException {
		
	}

	@Test
	public void testParseGroup() throws ModelXtdexException {
		
	}

	@Test
	public void testParseImage() throws ModelXtdexException {
		
	}

	@Test
	public void testParseList() throws ModelXtdexException {
		final String xtext = "List item=what";
		List e = (List) xtdex.parse(xtext);
		final String actual = xtdex.toXtext(e);
		assertThat(actual, Matchers.equalTo(xtext));
	}

	@Test
	public void testParseSelection() throws ModelXtdexException {
		final String xtext = "Selection item=Scene_General label=\"Scene Selection\" mappings=[0=off,1=HR3,2=SWR3,3=FFH]";
		Selection e = (Selection) xtdex.parse(xtext);
		final String actual = xtdex.toXtext(e);
		assertThat(actual, Matchers.equalTo(xtext));
	}

	@Test
	public void testParseSetpoint() throws ModelXtdexException {
		final String xtext = "Setpoint item=Temperature_Setpoint minValue=16 maxValue=28 step=0.5";
		Setpoint e = (Setpoint) xtdex.parse(xtext);
		final String actual = xtdex.toXtext(e);
		assertThat(actual, Matchers.equalTo(xtext));
	}

	@Test
	public void testParseSlider() throws ModelXtdexException {
		final String xtext = "Slider item=DimmedLight sendFrequency=0 switchSupport";
		Slider e = (Slider) xtdex.parse(xtext);
		final String actual = xtdex.toXtext(e);
		assertThat(actual, Matchers.equalTo(xtext));
	}

	@Test
	public void testParseSwitch() throws ModelXtdexException {
		final String xtext = "Switch item=Weather_Chart_Period label=\"Chart Period\" mappings=[0=\"Hour\",1=\"Day\",2=\"Week\"]";
		Switch e = (Switch) xtdex.parse(xtext);
		final String actual = xtdex.toXtext(e);
		assertThat(actual, Matchers.equalTo(xtext));
	}

	@Test
	public void testParseText() throws ModelXtdexException {
		
	}

	@Test
	public void testParseVideo() throws ModelXtdexException {
		final String xtext = "Video url=\"http://demo.openhab.org/Hue.m4v\"";
		Video e = (Video) xtdex.parse(xtext);
		final String actual = xtdex.toXtext(e);
		assertThat(actual, Matchers.equalTo(xtext));
	}

	@Test
	public void testParseWebview() throws ModelXtdexException {
		final String xtext = "Webview url=\"http://heise-online.mobi/\" height=8";
		Webview e = (Webview) xtdex.parse(xtext);
		final String actual = xtdex.toXtext(e);
		assertThat(actual, Matchers.equalTo(xtext));
	}

	@Test
	public void testParse() throws ModelXtdexException {
		String xtext = null;
		String actual = null;
		Element e = null;
		//
		xtext = "Chart item=Weather_Chart visibility=[Weather_Chart_Period==0,Weather_Chart_Period==\"Uninitialized\"] period=h refresh=600";
		e = xtdex.parse(xtext);
		actual = xtdex.toXtext(e);
		assertThat(actual, Matchers.equalTo(xtext));
		//
		xtext = "Colorpicker item=RGBLight icon=\"slider\" sendFrequency=0";
		e = xtdex.parse(xtext);
		actual = xtdex.toXtext(e);
		assertThat(actual, Matchers.equalTo(xtext));
		//
		
		//
		
		//
		
		//
		xtext = "List item=what";
		e = xtdex.parse(xtext);
		actual = xtdex.toXtext(e);
		assertThat(actual, Matchers.equalTo(xtext));
		//
		xtext = "Selection item=Scene_General label=\"Scene Selection\" mappings=[0=off,1=HR3,2=SWR3,3=FFH]";
		e = xtdex.parse(xtext);
		actual = xtdex.toXtext(e);
		assertThat(actual, Matchers.equalTo(xtext));
		//
		xtext = "Setpoint item=Temperature_Setpoint minValue=16 maxValue=28 step=0.5";
		e = xtdex.parse(xtext);
		actual = xtdex.toXtext(e);
		assertThat(actual, Matchers.equalTo(xtext));
		//
		xtext = "Slider item=DimmedLight sendFrequency=0 switchSupport";
		e = xtdex.parse(xtext);
		actual = xtdex.toXtext(e);
		assertThat(actual, Matchers.equalTo(xtext));
		//
		xtext = "Switch item=Weather_Chart_Period label=\"Chart Period\" mappings=[0=\"Hour\",1=\"Day\",2=\"Week\"]";
		e = xtdex.parse(xtext);
		actual = xtdex.toXtext(e);
		assertThat(actual, Matchers.equalTo(xtext));
		//
		
		//
		xtext = "Video url=\"http://demo.openhab.org/Hue.m4v\"";
		e = xtdex.parse(xtext);
		actual = xtdex.toXtext(e);
		assertThat(actual, Matchers.equalTo(xtext));
		//
		xtext = "Webview url=\"http://heise-online.mobi/\" height=8";
		e = xtdex.parse(xtext);
		actual = xtdex.toXtext(e);
		assertThat(actual, Matchers.equalTo(xtext));
	}

}
