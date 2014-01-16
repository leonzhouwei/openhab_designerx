package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import org.openhab.designerx.model.sitemap2.Webview;
import org.openhab.designerx.model.sitemap2.producer.ElementFactory;
import org.openhab.designerx.model.sitemap2.producer.impl.ElementFactoryImpl;
import org.openhab.designerx.model.xtdex.ModelXtdexConstants;

/**
 * 
 * Syntax:
 * Webview item="<itemname>" [label="<labelname>"] [icon="<iconname>"] url="<url>" [height="<heightvalue"]
 * 
 * @author zhouwei
 *
 */
public final class WebviewXtdex {
	private static final String HEIGHT = "height";
	private static final String MATCH_REGEX = "\\s*" + Webview.TYPE_NAME + "\\b.*";
	private static final ElementFactory factory = new ElementFactoryImpl();
	
	static Webview fromXtext(NonNestableElementXtextKeeper keeper) {
		String xtext = keeper.getXtext();
		if (!xtext.startsWith(Webview.TYPE_NAME)) {
			return null;
		}
		Webview instance = factory.createWebview();
		// set the elementary parameters
		ElementXtdexImpl.fillWithoutChildren(instance, keeper);
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
	
	private WebviewXtdex() {}
	
	public static boolean isWebview(String xtext) {
		boolean result = false;
		if (xtext.matches(MATCH_REGEX)) {
			result = true;
		}
		return result;
	}
	
}
