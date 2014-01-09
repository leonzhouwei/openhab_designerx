package org.openhab.designerx.model.sitemap.childlesselement.xtext;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerx.model.sitemap.Webview;
import org.openhab.designerx.model.sitemap.impl.WebviewBuilder;

public class WebviewXtdexTest {

	@Test
	public void testFromXtext() {
		final String xtext = "Webview url=\"http://heise-online.mobi/\" height=8";
		final String url = PropertyHandler.getValueBetweenDoubleQuotes(xtext, "url");
		final Webview expected = new WebviewBuilder().build();
		expected.setUrl(url);
		expected.setHeight(8);
		final Webview actual = WebviewXtdex.fromXtext(xtext);
		assertThat(expected.equalsLogically(actual), Matchers.equalTo(true));
	}

}
