package org.openhab.designerx.model.xtext.sitemap;

import java.util.List;

import org.openhab.designerx.model.sitemap.Mapping;
import org.openhab.designerx.model.sitemap.Switch;
import org.openhab.designerx.model.sitemap.impl.SwitchBuilder;

/**
 * 
 * Syntax:
 * Switch item="<itemname>" [label="<labelname>"] [icon="<iconname>"] [mappings="<mapping definition>"]
 * 
 * @author zhouwei
 *
 */
public final class SwitchXtdex {
	
	static final String TARGET_TYPE_NAME = "Switch";
	
	static Switch fromXtext(NonNestableElementXtextKeeper keeper) {
		return fromXtext(keeper.getXtext());
	}
	
	static Switch fromXtext(String xtext) {
		xtext = PreProcessor.preProcess(xtext);
		if (!xtext.startsWith(TARGET_TYPE_NAME)) {
			return null;
		}
		Switch instance = new SwitchBuilder().build();
		// set the elementary parameters
		ElementXtdex.set(instance, xtext);
		// set the specific parameters
		instance.addMappings(MappingsXtdex.fromXtext(xtext));
		return instance;
	}
	
	public static String toXtext(Switch e) {
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
		List<Mapping> mappings= e.getMappings();
		if (!mappings.isEmpty()) {
			sb.append(MappingsXtdex.toXtext(mappings));
			sb.append(Constants.SPACE_MARK);
		}
		return sb.toString().trim();
	}
	
	private SwitchXtdex() {}
	
	public static boolean isSwitch(String xtext) {
		boolean result = false;
		if (xtext.trim().startsWith(TARGET_TYPE_NAME)) {
			result = true;
		}
		return result;
	}
	
}
