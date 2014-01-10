package org.openhab.designerx.model.xtext.sitemap;

import org.openhab.designerx.model.sitemap.Video;
import org.openhab.designerx.model.sitemap.impl.VideoBuilder;

/**
 * 
 * Syntax:
 * Video item="<itemname>"  [icon="<iconname>"] url="<url of video to embed>"
 * 
 * @author zhouwei
 *
 */
public final class VideoXtdex {
	
	public static final String TARGET_TYPE_NAME = "Video";
	
	public static Video fromXtext(String xtext) {
		xtext = PreProcessor.preProcess(xtext);
		if (!xtext.startsWith(TARGET_TYPE_NAME)) {
			throw new RuntimeException(xtext + " is NOT a " + TARGET_TYPE_NAME);
		}
		Video instance = new VideoBuilder().build();
		// set the elementary parameters
		ElementXtdex.set(instance, xtext);
		// set the specific parameters
		String url = PropertyHandler.getValueBetweenDoubleQuotes(xtext, Constants.URL);
		instance.setUrl(url);
		return instance;
	}
	
	public static String toXtext(Video e) {
		StringBuilder sb = new StringBuilder();
		sb.append(TARGET_TYPE_NAME);
		sb.append(Constants.SPACE_MARK);
		sb.append(ElementXtdex.toXtext(e).trim());
		if (e.getUrl() != null) {
			sb.append(Constants.SPACE_MARK);
			sb.append(Constants.URL);
			sb.append(Constants.EQU_MARK);
			sb.append(Constants.DOUBLE_QUOTE_MARK);
			sb.append(e.getUrl());
			sb.append(Constants.DOUBLE_QUOTE_MARK);
			sb.append(Constants.SPACE_MARK);
		}
		return sb.toString().trim();
	}
	
	private VideoXtdex() {}
	
}
