package org.openhab.designerx.model.xtext.sitemap;

import org.openhab.designerx.model.sitemap.Image;
import org.openhab.designerx.model.sitemap.NestableElement;
import org.openhab.designerx.model.sitemap.impl.ImageBuilder;
import org.openhab.designerx.model.xtext.XtextConstants;

/**
 * 
 * Syntax:
 * Image [item="<itemname>"] [icon="<iconname>"] url="<url of image>" [label="<labelname>"] [refresh=IMAGE]
 * 
 * @author zhouwei
 *
 */
public final class ImageXtdex {
	
	static final String TARGET_TYPE_NAME = "Image";
	private static final String MATCH_REGEX = "\\s*" + TARGET_TYPE_NAME + "\\b.*";
	
	public static Image fromXtext(NestableElementXtextKeeper keeper) {
		return (Image) NestableElementXtdex.fromXtext(keeper);
	}
	
	static Image fromXtextWithoutChildren(String xtext) {
		xtext = PreProcessor.preProcess(xtext);
		if (!xtext.startsWith(TARGET_TYPE_NAME)) {
			return null;
		}
		Image instance = new ImageBuilder().build();
		// set the elementary parameters
		ElementXtdex.set(instance, xtext);
		// icon color
		instance.addIconColor(ColorArrayXtdex.fromXtext(xtext, XtextConstants.ICONCOLOR));
		// refresh
		String refresh = PropertyHandler.getValue(xtext, XtextConstants.REFRESH);
		if (refresh != null) {
			int i = Integer.parseInt(refresh);
			instance.setRefresh(i);
		}
		// url
		String url = PropertyHandler.getValueBetweenDoubleQuotes(xtext, XtextConstants.URL);
		instance.setUrl(url);
		return instance;
	}
	
	public static String toXtext(Image e) {
		return toXtext(e, "");
	}
	
	public static String toXtext(Image e, String indentation) {
		return NestableElementXtdex.toXtext((NestableElement) e, indentation);
	}
	
	static String toXtextWithoutChildren(Image e) {
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
		String url = e.getUrl();
		if (url != null) {
			sb.append(XtextConstants.URL);
			sb.append(XtextConstants.EQU_MARK);
			sb.append(XtextConstants.DOUBLE_QUOTE_MARK);
			sb.append(url);
			sb.append(XtextConstants.DOUBLE_QUOTE_MARK);
			sb.append(XtextConstants.SPACE_MARK);
		}
		// refresh
		sb.append(XtextConstants.REFRESH);
		sb.append(XtextConstants.EQU_MARK);
		sb.append(e.getRefresh());
		sb.append(XtextConstants.SPACE_MARK);
		return sb.toString().trim();
	}
	
	private ImageXtdex() {}
	
	public static boolean isImage(String xtext) {
		boolean result = false;
		if (xtext.matches(MATCH_REGEX)) {
			result = true;
		}
		return result;
	}
	
}
