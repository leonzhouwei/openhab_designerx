package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import java.util.List;

import org.openhab.designerx.model.sitemap.Element;
import org.openhab.designerx.model.sitemap.Mapping;
import org.openhab.designerx.model.sitemap.Switch;
import org.openhab.designerx.model.sitemap.producer.ElementFactory;
import org.openhab.designerx.model.sitemap.producer.impl.ElementFactoryImpl;
import org.openhab.designerx.model.xtdex.ModelXtdexConstants;

/**
 * 
 * Syntax:
 * Switch item="<itemname>" [label="<labelname>"] [icon="<iconname>"] [mappings="<mapping definition>"]
 * 
 * @author zhouwei
 *
 */
final class SwitchXtdex {
	private static final String MATCH_REGEX = "\\s*" + Switch.TYPE_NAME + "\\b.*";
	
	private static final ElementFactory factory = new ElementFactoryImpl();

	static boolean isSwitch(String xtext) {
		boolean result = false;
		if (xtext.matches(MATCH_REGEX)) {
			result = true;
		}
		return result;
	}
	
	static <T extends Element> boolean isSwitch(T e) {
		boolean result = false;
		if (e instanceof Switch) {
			result = true;
		}
		return result;
	}

	static Switch parseIgnoringChildren(NonNestableElementXtextKeeper keeper) {
		String xtext = keeper.getXtext();
		if (!xtext.startsWith(Switch.TYPE_NAME)) {
			return null;
		}
		Switch instance = factory.createSwitch();
		// set the elementary parameters
		ElementFiller.fillWithoutChildren(instance, keeper);
		// set the specific parameters
		instance.addMappings(MappingsXtdex.fromXtext(xtext));
		return instance;
	}

	static String toXtextIgnoringChildren(Switch e) {
		StringBuilder sb = new StringBuilder();
		// convert the elementary parameters
		sb.append(ElementXtextualizer.toXtextIgnoringChildren(e));
		sb.append(ModelXtdexConstants.SPACE_MARK);
		// convert the specific parameters below
		// mappings
		List<Mapping> mappings= e.getMappings();
		if (!mappings.isEmpty()) {
			sb.append(MappingsXtdex.toXtext(mappings));
			sb.append(ModelXtdexConstants.SPACE_MARK);
		}
		return sb.toString().trim();
	}

	private SwitchXtdex() {}

}
