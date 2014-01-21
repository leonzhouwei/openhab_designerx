package org.openhab.designerx.model.xtdex.sitemap.impl;

import org.openhab.designerx.model.sitemap.Element;
import org.openhab.designerx.model.sitemap.SitemapElementFactory;
import org.openhab.designerx.model.sitemap.Video;
import org.openhab.designerx.model.sitemap.impl.SitemapElementFactoryImpl;
import org.openhab.designerx.model.xtdex.ModelXtdexConstants;

/**
 * 
 * Syntax:
 * Video item="<itemname>"  [icon="<iconname>"] url="<url of video to embed>"
 * 
 * @author zhouwei
 *
 */
final class VideoXtdex {
	private static final String MATCH_REGEX = "\\s*" + Video.TYPE_NAME + "\\b.*";
	
	private static final SitemapElementFactory factory = new SitemapElementFactoryImpl();

	static boolean isVideo(ChildlessElementXtextKeeper keeper) {
		boolean result = false;
		String xtext = keeper.getXtext();
		if (xtext.matches(MATCH_REGEX)) {
			result = true;
		}
		return result;
	}
	
	static <T extends Element> boolean isVideo(T e) {
		boolean result = false;
		if (e instanceof Video) {
			result = true;
		}
		return result;
	}

	static Video parseIgnoringChildren(ChildlessElementXtextKeeper keeper) {
		String xtext = keeper.getXtext();
		if (!xtext.startsWith(Video.TYPE_NAME)) {
			return null;
		}
		Video instance = factory.createVideo();
		// set the elementary parameters
		ElementFiller.fillWithoutChildren(instance, keeper);
		// set the specific parameters
		String url = PropertyHandler.getValueBetweenDoubleQuotes(xtext, ModelXtdexConstants.URL);
		instance.setUrl(url);
		return instance;
	}

	static String toXtextIgnoringChildren(Video e) {
		StringBuilder sb = new StringBuilder();
		// convert the elementary parameters
		sb.append(ElementXtextualizer.toXtextIgnoringChildren(e));
		sb.append(ModelXtdexConstants.SPACE_MARK);
		// convert the specific parameters below
		// url
		if (e.getUrl() != null) {
			sb.append(ModelXtdexConstants.URL);
			sb.append(ModelXtdexConstants.EQU_MARK);
			sb.append(ModelXtdexConstants.DOUBLE_QUOTE_MARK);
			sb.append(e.getUrl());
			sb.append(ModelXtdexConstants.DOUBLE_QUOTE_MARK);
			sb.append(ModelXtdexConstants.SPACE_MARK);
		}
		return sb.toString().trim();
	}

	private VideoXtdex() {}

}
