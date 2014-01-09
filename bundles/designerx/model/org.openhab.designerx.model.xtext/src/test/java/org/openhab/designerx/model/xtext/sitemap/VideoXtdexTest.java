package org.openhab.designerx.model.xtext.sitemap;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerx.model.sitemap.Video;
import org.openhab.designerx.model.sitemap.impl.VideoBuilder;
import org.openhab.designerx.model.xtext.sitemap.PropertyHandler;
import org.openhab.designerx.model.xtext.sitemap.VideoXtdex;

public class VideoXtdexTest {

	@Test
	public void testFromXtext() {
		final String xtext = "Video url=\"http://demo.openhab.org/Hue.m4v\"";
		final String url = PropertyHandler.getValueBetweenDoubleQuotes(xtext, "url");
		final Video expected = new VideoBuilder().build();
		expected.setUrl(url);
		final Video actual = VideoXtdex.fromXtext(xtext);
		assertThat(expected.equalsLogically(actual), Matchers.equalTo(true));
	}

}