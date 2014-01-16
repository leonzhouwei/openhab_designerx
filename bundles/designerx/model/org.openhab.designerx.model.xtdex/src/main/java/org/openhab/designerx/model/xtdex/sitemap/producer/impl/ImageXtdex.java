package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import org.openhab.designerx.model.sitemap2.Element;
import org.openhab.designerx.model.sitemap2.Image;
import org.openhab.designerx.model.sitemap2.producer.ElementFactory;
import org.openhab.designerx.model.sitemap2.producer.impl.ElementFactoryImpl;
import org.openhab.designerx.model.xtdex.ModelXtdexConstants;
import org.openhab.designerx.model.xtdex.ModelXtdexException;

import com.google.common.collect.ImmutableList;

/**
 * 
 * Syntax:
 * Image [item="<itemname>"] [icon="<iconname>"] url="<url of image>" [label="<labelname>"] [refresh=IMAGE]
 * 
 * @author zhouwei
 *
 */
public final class ImageXtdex {
	private static final String MATCH_REGEX = "\\s*" + Image.TYPE_NAME + "\\b.*";
	private static final ElementFactory factory = new ElementFactoryImpl();
	
	public static Image fromXtext(NestableElementXtextKeeper keeper) throws ModelXtdexException {
		ImmutableList<String> xtext = keeper.getXtext();
		String firstLine = xtext.get(0);
		if (!firstLine.startsWith(Image.TYPE_NAME)) {
			return null;
		}
		Image instance = factory.createImage();
		// set the elementary parameters
		ElementXtdexImpl.fillWithoutChildren(instance, new NonNestableElementXtextKeeper(firstLine));
		// icon color
		instance.addIconColor(ColorArrayXtdex.fromXtext(firstLine, ModelXtdexConstants.ICONCOLOR));
		// refresh
		String refresh = PropertyHandler.getValue(firstLine, ModelXtdexConstants.REFRESH);
		if (refresh != null) {
			int i = Integer.parseInt(refresh);
			instance.setRefresh(i);
		}
		// url
		String url = PropertyHandler.getValueBetweenDoubleQuotes(firstLine, ModelXtdexConstants.URL);
		instance.setUrl(url);
		return instance;
	}
	
	private ImageXtdex() {}
	
	public static boolean isImage(String xtext) {
		boolean result = false;
		if (xtext.matches(MATCH_REGEX)) {
			result = true;
		}
		return result;
	}
	
	static Element parseIgnoringChildren(NonNestableElementXtextKeeper keeper) {
		Element e = null;
		
		return e;
	}
	
}
