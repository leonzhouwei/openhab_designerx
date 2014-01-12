package org.openhab.designerx.model.xtext.sitemap;

import org.openhab.designerx.model.sitemap.Image;
import org.openhab.designerx.model.sitemap.NestableElement;
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
	
	static final String TARGET_TYPE_NAME = "Image";
	
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
		return toXtext(e, "");
	}
	
	public static String toXtext(Image e, String indentation) {
		return NestableElementXtdex.toXtext((NestableElement) e, indentation);
	}
	
	static String toXtextWithoutChildren(Image e) {
		StringBuilder sb = new StringBuilder();
		sb.append(TARGET_TYPE_NAME);
		sb.append(Constants.SPACE_MARK);
		// element
		String elemStr = ElementXtdex.toXtext(e);
		if (!elemStr.isEmpty()) {
			sb.append(elemStr);	
			sb.append(Constants.SPACE_MARK);
		}
		// url
		String url = e.getUrl();
		if (url != null) {
			sb.append(Constants.URL);
			sb.append(Constants.EQU_MARK);
			sb.append(Constants.DOUBLE_QUOTE_MARK);
			sb.append(url);
			sb.append(Constants.DOUBLE_QUOTE_MARK);
			sb.append(Constants.SPACE_MARK);
		}
		// refresh
		sb.append(Constants.REFRESH);
		sb.append(Constants.EQU_MARK);
		sb.append(e.getRefresh());
		sb.append(Constants.SPACE_MARK);
		return sb.toString().trim();
	}
	
	private ImageXtdex() {}
	
	public static boolean isImage(String xtext) {
		boolean result = false;
		if (xtext.trim().startsWith(TARGET_TYPE_NAME)) {
			result = true;
		}
		return result;
	}
	
}
