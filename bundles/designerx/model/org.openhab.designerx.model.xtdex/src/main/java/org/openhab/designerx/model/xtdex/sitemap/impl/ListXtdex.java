package org.openhab.designerx.model.xtdex.sitemap.impl;

import org.openhab.designerx.model.sitemap.Element;
import org.openhab.designerx.model.sitemap.SitemapElementFactory;
import org.openhab.designerx.model.sitemap.List;
import org.openhab.designerx.model.sitemap.impl.SitemapElementFactoryImpl;
import org.openhab.designerx.model.xtdex.ModelXtdexConstants;

/**
 * 
 * Syntax:
 * List item="<itemname>" [label="<labelname>"] [icon="<iconname>"] [separator=""]
 * 
 * @author zhouwei
 *
 */
final class ListXtdex {
	private static final String MATCH_REGEX = "\\s*" + List.TYPE_NAME + "\\b.*";
	
	private static final String SEPARATOR = "separator";
	
	private static final SitemapElementFactory factory = new SitemapElementFactoryImpl();

	static boolean isList(ChildlessElementXtextKeeper keeper) {
		boolean result = false;
		String xtext = keeper.getXtext();
		if (xtext.matches(MATCH_REGEX)) {
			result = true;
		}
		return result;
	}
	
	static <T extends Element> boolean isList(T e) {
		boolean result = false;
		if (e instanceof List) {
			result = true;
		}
		return result;
	}

	static List parseIgnoringChildren(ChildlessElementXtextKeeper keeper) {
		String xtext = keeper.getXtext();
		if (!xtext.startsWith(List.TYPE_NAME)) {
			return null;
		}
		List instance = factory.createList();
		// set the elementary parameters
		ElementFiller.fillWithoutChildren(instance, keeper);
		// set the specific parameters
		// separator
		String separator = PropertyHandler.getValue(xtext, SEPARATOR);
		instance.setSeparator(separator);
		return instance;
	}

	static String toXtextIgnoringChildren(List e) {
		StringBuilder sb = new StringBuilder();
		// convert the elementary parameters
		sb.append(ElementXtextualizer.toXtextIgnoringChildren(e));
		sb.append(ModelXtdexConstants.SPACE_MARK);
		// convert the specific parameters below
		// separator
		String separator = e.getSeparator();
		if (separator != null) {
			sb.append(SEPARATOR);
			sb.append(ModelXtdexConstants.EQU_MARK);
			sb.append(separator);
			sb.append(ModelXtdexConstants.SPACE_MARK);
		}
		return sb.toString().trim();
	}

	private ListXtdex() {}

}
