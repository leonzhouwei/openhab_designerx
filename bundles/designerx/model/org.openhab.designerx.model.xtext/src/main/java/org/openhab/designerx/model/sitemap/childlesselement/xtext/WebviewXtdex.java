package org.openhab.designerx.model.sitemap.childlesselement.xtext;

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
	
	public static final String TARGET_TYPE_NAME = "Webview";
	
	private static final String HEIGHT = "height";
	
	public static Webview fromXtext(String xtext) {
		xtext = PreProcessor.preProcess(xtext);
		if (!xtext.startsWith(TARGET_TYPE_NAME)) {
			throw new RuntimeException(xtext + " is NOT a " + TARGET_TYPE_NAME);
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
		sb.append(ElementXtdex.toXtext(e).trim());
		if (e.getUrl() != null) {
			sb.append(Constants.SPACE_MARK);
			sb.append(Constants.URL);
			sb.append(Constants.EQU_MARK);
			sb.append(Constants.DOUBLE_QUOTE_MARK);
			sb.append(e.getUrl());
			sb.append(Constants.DOUBLE_QUOTE_MARK);
		}
		sb.append(Constants.SPACE_MARK);
		sb.append(HEIGHT);
		sb.append(Constants.EQU_MARK);
		sb.append(e.getHeight());
		return sb.toString().trim();
	}
	
	private WebviewXtdex() {}
	
}
