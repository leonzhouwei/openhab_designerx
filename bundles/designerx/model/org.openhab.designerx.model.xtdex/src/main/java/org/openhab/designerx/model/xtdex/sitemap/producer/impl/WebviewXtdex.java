package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import org.openhab.designerx.model.sitemap.Element;
import org.openhab.designerx.model.sitemap.Webview;
import org.openhab.designerx.model.sitemap.producer.ElementFactory;
import org.openhab.designerx.model.sitemap.producer.impl.ElementFactoryImpl;
import org.openhab.designerx.model.xtdex.ModelXtdexConstants;

/**
 * 
 * Syntax:
 * Webview item="<itemname>" [label="<labelname>"] [icon="<iconname>"] url="<url>" [height="<heightvalue"]
 * 
 * @author zhouwei
 *
 */
final class WebviewXtdex {
	private static final String MATCH_REGEX = "\\s*" + Webview.TYPE_NAME + "\\b.*";
	private static final String HEIGHT = "height";
	
	private static final ElementFactory factory = new ElementFactoryImpl();

	static boolean isWebview(String xtext) {
		boolean result = false;
		if (xtext.matches(MATCH_REGEX)) {
			result = true;
		}
		return result;
	}
	
	static <T extends Element> boolean isWebview(T e) {
		boolean result = false;
		if (e instanceof Webview) {
			result = true;
		}
		return result;
	}

	static Webview parseIgnoringChildren(ChildlessElementXtextKeeper keeper) {
		String xtext = keeper.getXtext();
		if (!xtext.startsWith(Webview.TYPE_NAME)) {
			return null;
		}
		Webview instance = factory.createWebview();
		// set the elementary parameters
		ElementFiller.fillWithoutChildren(instance, keeper);
		// set the specific parameters
		String url = PropertyHandler.getValueBetweenDoubleQuotes(xtext, ModelXtdexConstants.URL);
		instance.setUrl(url);
		String height = PropertyHandler.getValue(xtext, HEIGHT);
		if (height != null) {
			int i = Integer.parseInt(height);
			instance.setHeight(i);
		}
		return instance;
	}

	static String toXtextIgnoringChildren(Webview e) {
		StringBuilder sb = new StringBuilder();
		// convert the elementary parameters
		sb.append(ElementXtextualizer.toXtextIgnoringChildren(e));
		sb.append(ModelXtdexConstants.SPACE_MARK);
		// convert the specific parameters below
		// url
		String url = e.getUrl();
		if (url != null) {
			sb.append(ModelXtdexConstants.URL);
			sb.append(ModelXtdexConstants.EQU_MARK);
			sb.append(ModelXtdexConstants.DOUBLE_QUOTE_MARK);
			sb.append(url);
			sb.append(ModelXtdexConstants.DOUBLE_QUOTE_MARK);
			sb.append(ModelXtdexConstants.SPACE_MARK);
		}
		// height
		sb.append(HEIGHT);
		sb.append(ModelXtdexConstants.EQU_MARK);
		sb.append(e.getHeight());
		sb.append(ModelXtdexConstants.SPACE_MARK);
		return sb.toString().trim();
	}

	private WebviewXtdex() {}

}
