package org.openhab.designerx.model.xtdex.sitemap.impl;

import org.openhab.designerx.model.sitemap.Element;
import org.openhab.designerx.model.sitemap.SitemapElementFactory;
import org.openhab.designerx.model.sitemap.Group;
import org.openhab.designerx.model.sitemap.impl.SitemapElementFactoryImpl;
import org.openhab.designerx.model.xtdex.ModelXtdexConstants;

/**
 * 
 * Syntax:
 * Group [item="<itemname>"] [label="<labelname>"] [icon="<iconname>"]
 * 
 * @author zhouwei
 *
 */
final class GroupXtdex {
	private static final String MATCH_REGEX = "\\s*" + Group.TYPE_NAME + "\\b.*";
	
	private static final SitemapElementFactory factory = new SitemapElementFactoryImpl();
	
	static boolean isGroup(ChildfulElementXtextKeeper keeper) {
		String xtext = keeper.getXtext().get(0);
		boolean result = false;
		if (xtext.matches(MATCH_REGEX)) {
			result = true;
		}
		return result;
	}
	
	static <T extends Element> boolean isGroup(T e) {
		boolean result = false;
		if (e instanceof Group) {
			result = true;
		}
		return result;
	}

	static Group parseIgnoringChildren(ChildlessElementXtextKeeper keeper) {
		String xtext = keeper.getXtext();
		if (!xtext.startsWith(Group.TYPE_NAME)) {
			return null;
		}
		Group instance = factory.createGroup();
		// set the elementary parameters
		ElementFiller.fillWithoutChildren(instance, keeper);
		// set the specific parameters
		return instance;
	}

	static String toXtextIgnoringChildren(Group e) {
		StringBuilder sb = new StringBuilder();
		// convert the elementary parameters
		sb.append(ElementXtextualizer.toXtextIgnoringChildren(e));
		sb.append(ModelXtdexConstants.SPACE_MARK);
		// convert the specific parameters below
		return sb.toString().trim();
	}

	private GroupXtdex() {}

}
