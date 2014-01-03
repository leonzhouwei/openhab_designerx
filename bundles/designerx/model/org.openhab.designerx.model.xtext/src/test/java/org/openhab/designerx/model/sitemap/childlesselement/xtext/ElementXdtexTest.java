package org.openhab.designerx.model.sitemap.childlesselement.xtext;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerx.model.sitemap.Element;

public class ElementXdtexTest {
	
	@Test
	public void testFromXtext_1() {
		final String expected = "item=gFF";
		Element e = ElementXdtex.fromXtext(expected);
		final String actual = ElementXdtex.toXtext(e);
		assertThat(actual, Matchers.equalTo(expected));
	}

	@Test
	public void testFromXtext_2() {
		final String expected = "item=gFF label=\"First Floor\" icon=\"firstfloor\"";
		Element e = ElementXdtex.fromXtext(expected);
		final String actual = ElementXdtex.toXtext(e);
		assertThat(actual, Matchers.equalTo(expected));
	}

	@Test
	public void testToXtext() {
		final String expected = "item=gFF label=\"First Floor\" icon=\"firstfloor\"";
		Element e = ElementXdtex.fromXtext(expected);
		final String actual = ElementXdtex.toXtext(e);
		assertThat(actual, Matchers.equalTo(expected));
	}

}
