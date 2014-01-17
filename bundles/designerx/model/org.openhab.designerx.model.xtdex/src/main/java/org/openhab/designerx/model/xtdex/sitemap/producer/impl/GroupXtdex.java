package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import org.openhab.designerx.model.sitemap.Group;
import org.openhab.designerx.model.sitemap.producer.ElementFactory;
import org.openhab.designerx.model.sitemap.producer.impl.ElementFactoryImpl;
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
	
	private static final ElementFactory factory = new ElementFactoryImpl();

	static boolean isGroup(String xtext) {
		boolean result = false;
		if (xtext.matches(MATCH_REGEX)) {
			result = true;
		}
		return result;
	}

	static Group parseIgnoringChildren(NonNestableElementXtextKeeper keeper) {
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
