package org.openhab.designerx.model.xtext.sitemap;

import org.openhab.designerx.model.sitemap.Image;
import org.openhab.designerx.model.sitemap.impl.ImageBuilder;

/**
 * 
 * Syntax:
 * Image [item="<itemname>"] [icon="<iconname>"] url="<url of image>" [label="<labelname>"] [refresh=IMAGE]
 * 
 * @author zhouwei
 *
 */
public final class ImageXtdex {
	
	public static final String TARGET_TYPE_NAME = "Image";
	
	public static Image fromXtext(String xtext) {
		xtext = PreProcessor.preProcess(xtext);
		if (!xtext.startsWith(TARGET_TYPE_NAME)) {
			throw new RuntimeException(xtext + " is NOT a " + TARGET_TYPE_NAME);
		}
		Image instance = new ImageBuilder().build();
		// set the elementary parameters
		ElementXtdex.set(instance, xtext);
		// icon color
		instance.addIconColor(ColorArrayXtdex.fromXtext(xtext, Constants.ICONCOLOR));
		// refresh
		String refresh = PropertyHandler.getValue(xtext, Constants.REFRESH);
		if (refresh != null) {
			int i = Integer.parseInt(refresh);
			instance.setRefresh(i);
		}
		// url
		String url = PropertyHandler.getValueBetweenDoubleQuotes(xtext, Constants.URL);
		instance.setUrl(url);
		return instance;
	}
	
	public static String toXtext(Image e) {
		return toXtextWithoutChildren(e);
	}
	
	public static String toXtextWithoutChildren(Image e) {
		StringBuilder sb = new StringBuilder();
		sb.append(TARGET_TYPE_NAME);
		// element
		String elemStr = ElementXtdex.toXtext(e);
		if (!elemStr.isEmpty()) {
			sb.append(Constants.SPACE_MARK);
			sb.append(elemStr);	
		}
		// url
		String url = e.getUrl();
		if (url != null) {
			sb.append(Constants.SPACE_MARK);
			sb.append(Constants.URL);
			sb.append(Constants.EQU_MARK);
			sb.append(Constants.DOUBLE_QUOTE_MARK);
			sb.append(url);
			sb.append(Constants.DOUBLE_QUOTE_MARK);
		}
		// refresh
		sb.append(Constants.SPACE_MARK);
		sb.append(Constants.REFRESH);
		sb.append(Constants.EQU_MARK);
		sb.append(e.getRefresh());
		return sb.toString();
	}
	
	private ImageXtdex() {}
}
