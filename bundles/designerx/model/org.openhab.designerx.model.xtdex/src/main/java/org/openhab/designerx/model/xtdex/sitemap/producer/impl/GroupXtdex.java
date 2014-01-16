package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import org.openhab.designerx.model.sitemap2.Element;
import org.openhab.designerx.model.sitemap2.Group;
import org.openhab.designerx.model.sitemap2.producer.ElementFactory;
import org.openhab.designerx.model.sitemap2.producer.impl.ElementFactoryImpl;
import org.openhab.designerx.model.xtdex.ModelXtdexException;

import com.google.common.collect.ImmutableList;

/**
 * 
 * Syntax:
 * Group [item="<itemname>"] [label="<labelname>"] [icon="<iconname>"]
 * 
 * @author zhouwei
 *
 */
public final class GroupXtdex {
	private static final String MATCH_REGEX = "\\s*" + Group.TYPE_NAME + "\\b.*";
	private static final ElementFactory factory = new ElementFactoryImpl();
	
	public static Group fromXtext(NestableElementXtextKeeper keeper) throws ModelXtdexException {
		ImmutableList<String> xtext = keeper.getXtext();
		String firstLine = xtext.get(0);
		if (!firstLine.startsWith(Group.TYPE_NAME)) {
			return null;
		}
		Group instance = factory.createGroup();
		// set the elementary parameters
		ElementXtdexImpl.fillWithoutChildren(instance, new NonNestableElementXtextKeeper(firstLine));
		return instance;
	}
	
	private GroupXtdex() {}
	
	public static boolean isGroup(String xtext) {
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
