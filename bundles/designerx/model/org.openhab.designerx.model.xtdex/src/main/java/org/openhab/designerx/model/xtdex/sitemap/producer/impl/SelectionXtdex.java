package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import java.util.List;

import org.openhab.designerx.model.sitemap.Element;
import org.openhab.designerx.model.sitemap.Mapping;
import org.openhab.designerx.model.sitemap.Selection;
import org.openhab.designerx.model.sitemap.producer.ElementFactory;
import org.openhab.designerx.model.sitemap.producer.impl.ElementFactoryImpl;
import org.openhab.designerx.model.xtdex.ModelXtdexConstants;

/**
 * 
 * Syntax:
 * Selection item="<itemname>" [label="<labelname>"] [icon="<iconname>"] [mappings="<mapping definition>"]
 * 
 * @author zhouwei
 *
 */
final class SelectionXtdex {
	private static final String MATCH_REGEX = "\\s*" + Selection.TYPE_NAME + "\\b.*";
	
	private static final ElementFactory factory = new ElementFactoryImpl();

	static boolean isSelection(String xtext) {
		boolean result = false;
		if (xtext.matches(MATCH_REGEX)) {
			result = true;
		}
		return result;
	}
	
	static <T extends Element> boolean isSelection(T e) {
		boolean result = false;
		if (e instanceof Selection) {
			result = true;
		}
		return result;
	}

	static Selection parseIgnoringChildren(ChildlessElementXtextKeeper keeper) {
		String xtext = keeper.getXtext();
		if (!xtext.startsWith(Selection.TYPE_NAME)) {
			return null;
		}
		Selection instance = factory.createSelection();
		// set the elementary parameters
		ElementFiller.fillWithoutChildren(instance, keeper);
		// set the specific parameters
		// mappings
		instance.addMappings(MappingsXtdex.fromXtext(xtext));
		return instance;
	}

	static String toXtextIgnoringChildren(Selection e) {
		StringBuilder sb = new StringBuilder();
		// convert the elementary parameters
		sb.append(ElementXtextualizer.toXtextIgnoringChildren(e));
		sb.append(ModelXtdexConstants.SPACE_MARK);
		// convert the specific parameters below
		// mappings
		List<Mapping> mappings = e.getMappings();
		if (!mappings.isEmpty()) {
			sb.append(MappingsXtdex.toXtext(mappings));	
			sb.append(ModelXtdexConstants.SPACE_MARK);
		}
		return sb.toString().trim();
	}

	private SelectionXtdex() {}

}
