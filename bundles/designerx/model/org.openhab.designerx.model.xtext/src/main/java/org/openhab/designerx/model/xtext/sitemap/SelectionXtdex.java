package org.openhab.designerx.model.xtext.sitemap;

import java.util.List;

import org.openhab.designerx.model.sitemap.Mapping;
import org.openhab.designerx.model.sitemap.Selection;
import org.openhab.designerx.model.sitemap.impl.SelectionBuilder;

/**
 * 
 * Syntax:
 * Selection item="<itemname>" [label="<labelname>"] [icon="<iconname>"] [mappings="<mapping definition>"]
 * 
 * @author zhouwei
 *
 */
public final class SelectionXtdex {
	
	static final String TARGET_TYPE_NAME = "Selection";
	private static final String MATCH_REGEX = "\\s" + TARGET_TYPE_NAME + "\\b.*";
	
	public static Selection fromXtext(NonNestableElementXtextKeeper keeper) {
		return fromXtext(keeper.getXtext());
	}
	
	static Selection fromXtext(String xtext) {
		xtext = PreProcessor.preProcess(xtext);
		if (!xtext.startsWith(TARGET_TYPE_NAME)) {
			return null;
		}
		Selection instance = new SelectionBuilder().build();
		// set the elementary parameters
		ElementXtdex.set(instance, xtext);
		// mappings
		instance.addMappings(MappingsXtdex.fromXtext(xtext));
		return instance;
	}
	
	public static String toXtext(Selection e) {
		StringBuilder sb = new StringBuilder();
		sb.append(TARGET_TYPE_NAME);
		sb.append(Constants.SPACE_MARK);
		// element
		String elemStr = ElementXtdex.toXtext(e);
		if (!elemStr.isEmpty()) {
			sb.append(elemStr);	
			sb.append(Constants.SPACE_MARK);
		}
		// mappings
		List<Mapping> mappings = e.getMappings();
		if (!mappings.isEmpty()) {
			sb.append(MappingsXtdex.toXtext(mappings));	
			sb.append(Constants.SPACE_MARK);
		}
		return sb.toString().trim();
	}
	
	private SelectionXtdex() {}
	
	public static boolean isSelection(String xtext) {
		boolean result = false;
		if (xtext.matches(MATCH_REGEX)) {
			result = true;
		}
		return result;
	}
	
}
