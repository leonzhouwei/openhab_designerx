package org.openhab.designerx.model.sitemap.childlesselement.xtext;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerx.model.sitemap.Element;

public class ElementXdtexTest {
	
	@Test
	public void testFromXtext_1() {
		final String expected = "item=gFF";
		Element e = ElementXtdex.fromXtext(expected);
		final String actual = ElementXtdex.toXtext(e);
		assertThat(actual, Matchers.equalTo(expected));
	}

	@Test
	public void testFromXtext_2() {
		final String expected = "item=gFF label=\"First Floor\" icon=\"firstfloor\"";
		Element e = ElementXtdex.fromXtext(expected);
		final String actual = ElementXtdex.toXtext(e);
		assertThat(actual, Matchers.equalTo(expected));
	}
	
	@Test
	public void testFromXtext_3() {
		final String expected = "item=Weather_Temperature valuecolor=[Weather_LastUpdate==\"Uninitialized\"=\"lightgray\",Weather_LastUpdate>90=\"lightgray\",>25=\"orange\",>15=\"green\",>5=\"orange\",<=5=\"blue\"]";
		Element e = ElementXtdex.fromXtext(expected);
		final String actual = ElementXtdex.toXtext(e);
		assertThat(actual, Matchers.equalTo(expected));
	}

	@Test
	public void testToXtext() {
		final String expected = "item=gFF label=\"First Floor\" icon=\"firstfloor\" visibility=[Weather_Chart_Period==0,Weather_Chart_Period==\"Uninitialized\"]";
		Element e = ElementXtdex.fromXtext(expected);
		final String actual = ElementXtdex.toXtext(e);
		assertThat(actual, Matchers.equalTo(expected));
	}

}
