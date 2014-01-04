package org.openhab.designerx.model.sitemap.childlesselement.xtext;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

public class PropertyHandlerTest {

	@Test
	public void testGetValue_1() {
		final String expected = "gFF";
		String xtext = "item=" + expected + " label=item";
		String item = PropertyHandler.getValue(xtext, "item");
		assertThat(item, Matchers.equalTo(expected));
	}
	
	@Test
	public void testGetValue_2() {
		final String expectedItem = "gFF";
		final String expectedLabel = "\"First Floor\"";
		final String expectedIcon = "\"firstfloor\"";
		String xtext = "item=" + expectedItem + " label=" + expectedLabel + " icon=" + expectedIcon;
		String actualItem = PropertyHandler.getValue(xtext, "item");
		assertThat(actualItem, Matchers.equalTo(expectedItem));
		String actualLabel = PropertyHandler.getValue(xtext, "label", "\"", "\"");
		assertThat(actualLabel, Matchers.equalTo(expectedLabel));
		String actualIcon = PropertyHandler.getValue(xtext, "icon", "\"", "\"");
		assertThat(actualIcon, Matchers.equalTo(expectedIcon));
	}

}
