package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import org.openhab.designerx.model.sitemap.Video;
import org.openhab.designerx.model.xtdex.ModelXtdexException;

public class ChildlessElementXtdexTest {

//	@Test
	public void testParse() throws ModelXtdexException {
		final String xtext = "Video url=\"http://demo.openhab.org/Hue.m4v\"";
		ChildlessElementXtextKeeper keeper = new ChildlessElementXtextKeeper(xtext);
		Video video = (Video) ChildlessElementXtdex.parse(keeper);
		System.out.println(VideoXtdex.toXtextIgnoringChildren(video));
	}

}
