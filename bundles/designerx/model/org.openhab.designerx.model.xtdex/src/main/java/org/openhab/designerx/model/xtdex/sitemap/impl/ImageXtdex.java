package org.openhab.designerx.model.xtdex.sitemap.impl;

import org.openhab.designerx.model.sitemap.Element;
import org.openhab.designerx.model.sitemap.Image;
import org.openhab.designerx.model.sitemap.producer.ElementFactory;
import org.openhab.designerx.model.sitemap.producer.impl.ElementFactoryImpl;
import org.openhab.designerx.model.xtdex.ModelXtdexConstants;

/**
 * 
 * Syntax:
 * Image [item="<itemname>"] [icon="<iconname>"] url="<url of image>" [label="<labelname>"] [refresh=IMAGE]
 * 
 * @author zhouwei
 *
 */
final class ImageXtdex {
	private static final String MATCH_REGEX = "\\s*" + Image.TYPE_NAME + "\\b.*";
	
	private static final ElementFactory factory = new ElementFactoryImpl();
	
	static boolean isImage(ChildfulElementXtextKeeper keeper) {
		String xtext = keeper.getXtext().get(0);
		boolean result = false;
		if (xtext.matches(MATCH_REGEX)) {
			result = true;
		}
		return result;
	}
	
	static <T extends Element> boolean isImage(T e) {
		boolean result = false;
		if (e instanceof Image) {
			result = true;
		}
		return result;
	}

	static Image parseIgnoringChildren(ChildlessElementXtextKeeper keeper) {
		String xtext = keeper.getXtext();
		if (!xtext.startsWith(Image.TYPE_NAME)) {
			return null;
		}
		Image instance = factory.createImage();
		// set the elementary parameters
		ElementFiller.fillWithoutChildren(instance, keeper);
		// set the specific parameters
		// icon color
		instance.addIconColor(ColorArrayXtdex.fromXtext(xtext, ModelXtdexConstants.ICONCOLOR));
		// refresh
		String refresh = PropertyHandler.getValue(xtext, ModelXtdexConstants.REFRESH);
		if (refresh != null) {
			int i = Integer.parseInt(refresh);
			instance.setRefresh(i);
		}
		// url
		String url = PropertyHandler.getValueBetweenDoubleQuotes(xtext, ModelXtdexConstants.URL);
		instance.setUrl(url);
		return instance;
	}

	static String toXtextIgnoringChildren(Image e) {
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
		// refresh
		sb.append(ModelXtdexConstants.REFRESH);
		sb.append(ModelXtdexConstants.EQU_MARK);
		sb.append(e.getRefresh());
		sb.append(ModelXtdexConstants.SPACE_MARK);
		return sb.toString().trim();
	}

	private ImageXtdex() {}

}
