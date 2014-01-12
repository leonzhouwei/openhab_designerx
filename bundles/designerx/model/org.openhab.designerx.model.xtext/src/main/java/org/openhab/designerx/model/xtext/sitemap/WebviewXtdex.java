package org.openhab.designerx.model.xtext.sitemap;

import org.openhab.designerx.model.sitemap.Webview;
import org.openhab.designerx.model.sitemap.impl.WebviewBuilder;

/**
 * 
 * Syntax:
 * Webview item="<itemname>" [label="<labelname>"] [icon="<iconname>"] url="<url>" [height="<heightvalue"]
 * 
 * @author zhouwei
 *
 */
public final class WebviewXtdex {
	
	static final String TARGET_TYPE_NAME = "Webview";
	
	private static final String HEIGHT = "height";
	private static final String MATCH_REGEX = "\\s" + TARGET_TYPE_NAME + "\\b.*";
	
	static Webview fromXtext(NonNestableElementXtextKeeper keeper) {
		return fromXtext(keeper.getXtext());
	}
	
	static Webview fromXtext(String xtext) {
		xtext = PreProcessor.preProcess(xtext);
		if (!xtext.startsWith(TARGET_TYPE_NAME)) {
			return null;
		}
		Webview instance = new WebviewBuilder().build();
		// set the elementary parameters
		ElementXtdex.set(instance, xtext);
		// set the specific parameters
		String url = PropertyHandler.getValueBetweenDoubleQuotes(xtext, Constants.URL);
		instance.setUrl(url);
		String height = PropertyHandler.getValue(xtext, HEIGHT);
		if (height != null) {
			int i = Integer.parseInt(height);
			instance.setHeight(i);
		}
		return instance;
	}
	
	public static String toXtext(Webview e) {
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
		// height
		sb.append(HEIGHT);
		sb.append(Constants.EQU_MARK);
		sb.append(e.getHeight());
		sb.append(Constants.SPACE_MARK);
		return sb.toString().trim();
	}
	
	private WebviewXtdex() {}
	
	public static boolean isWebview(String xtext) {
		boolean result = false;
		if (xtext.matches(MATCH_REGEX)) {
			result = true;
		}
		return result;
	}
	
}
