package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import org.junit.Test;
import org.openhab.designerx.model.sitemap.Video;
import org.openhab.designerx.model.xtdex.ModelXtdexException;

public class VideoXtdexTest {

	@Test
	public void testParseIgnoringChildren() throws ModelXtdexException {
		final String xtext = "Video url=\"http://demo.openhab.org/Hue.m4v\"";
		ChildlessElementXtextKeeper keeper = new ChildlessElementXtextKeeper(xtext);
		Video video = VideoXtdex.parseIgnoringChildren(keeper);
		System.out.println(VideoXtdex.toXtextIgnoringChildren(video));
	}

}
