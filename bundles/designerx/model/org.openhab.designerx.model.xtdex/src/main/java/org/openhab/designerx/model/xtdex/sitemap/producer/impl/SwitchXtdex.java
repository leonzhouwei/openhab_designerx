package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import org.openhab.designerx.model.sitemap2.Switch;
import org.openhab.designerx.model.sitemap2.producer.ElementFactory;
import org.openhab.designerx.model.sitemap2.producer.impl.ElementFactoryImpl;

/**
 * 
 * Syntax:
 * Switch item="<itemname>" [label="<labelname>"] [icon="<iconname>"] [mappings="<mapping definition>"]
 * 
 * @author zhouwei
 *
 */
public final class SwitchXtdex {
	private static final String MATCH_REGEX = "\\s*" + Switch.TYPE_NAME + "\\b.*";
	private static final ElementFactory factory = new ElementFactoryImpl();
	
	static Switch fromXtext(NonNestableElementXtextKeeper keeper) {
		String xtext = keeper.getXtext();
		if (!xtext.startsWith(Switch.TYPE_NAME)) {
			return null;
		}
		Switch instance = factory.createSwitch();
		// set the elementary parameters
		ElementXtdexImpl.fillWithoutChildren(instance, keeper);
		// set the specific parameters
		instance.addMappings(MappingsXtdex.fromXtext(xtext));
		return instance;
	}
	
	private SwitchXtdex() {}
	
	public static boolean isSwitch(String xtext) {
		boolean result = false;
		if (xtext.matches(MATCH_REGEX)) {
			result = true;
		}
		return result;
	}
	
}
