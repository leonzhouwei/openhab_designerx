package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import org.openhab.designerx.model.sitemap.Video;
import org.openhab.designerx.model.sitemap.impl.VideoBuilder;
import org.openhab.designerx.model.xtext.XtextConstants;

/**
 * 
 * Syntax:
 * Video item="<itemname>"  [icon="<iconname>"] url="<url of video to embed>"
 * 
 * @author zhouwei
 *
 */
public final class VideoXtdex {
	
	static final String TARGET_TYPE_NAME = "Video";
	private static final String MATCH_REGEX = "\\s*" + TARGET_TYPE_NAME + "\\b.*";
	
	static Video fromXtext(NonNestableElementXtextKeeper keeper) {
		return fromXtext(keeper.getXtext());
	}
	
	static Video fromXtext(String xtext) {
		xtext = PreProcessor.preProcess(xtext);
		if (!xtext.startsWith(TARGET_TYPE_NAME)) {
			return null;
		}
		Video instance = new VideoBuilder().build();
		// set the elementary parameters
		ElementXtdex.set(instance, xtext);
		// set the specific parameters
		String url = PropertyHandler.getValueBetweenDoubleQuotes(xtext, XtextConstants.URL);
		instance.setUrl(url);
		return instance;
	}
	
	public static String toXtext(Video e) {
		StringBuilder sb = new StringBuilder();
		sb.append(TARGET_TYPE_NAME);
		sb.append(XtextConstants.SPACE_MARK);
		// element
		String elemStr = ElementXtdex.toXtext(e);
		if (!elemStr.isEmpty()) {
			sb.append(elemStr);	
			sb.append(XtextConstants.SPACE_MARK);
		}
		// url
		if (e.getUrl() != null) {
			sb.append(XtextConstants.URL);
			sb.append(XtextConstants.EQU_MARK);
			sb.append(XtextConstants.DOUBLE_QUOTE_MARK);
			sb.append(e.getUrl());
			sb.append(XtextConstants.DOUBLE_QUOTE_MARK);
			sb.append(XtextConstants.SPACE_MARK);
		}
		return sb.toString().trim();
	}
	
	private VideoXtdex() {}
	
	public static boolean isVideo(String xtext) {
		boolean result = false;
		if (xtext.matches(MATCH_REGEX)) {
			result = true;
		}
		return result;
	}
	
}
