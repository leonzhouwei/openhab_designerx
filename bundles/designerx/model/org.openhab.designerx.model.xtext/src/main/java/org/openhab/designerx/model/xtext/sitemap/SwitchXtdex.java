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
	
	public static final String TARGET_TYPE_NAME = "Switch";
	
	public static Switch fromXtext(String xtext) {
		xtext = PreProcessor.preProcess(xtext);
		if (!xtext.startsWith(TARGET_TYPE_NAME)) {
			throw new RuntimeException(xtext + " is NOT a " + TARGET_TYPE_NAME);
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
		// element
		String elemStr = ElementXtdex.toXtext(e);
		if (!elemStr.isEmpty()) {
			sb.append(Constants.SPACE_MARK);
			sb.append(elemStr);	
		}
		// mappings
		List<Mapping> mappings= e.getMappings();
		if (!mappings.isEmpty()) {
			sb.append(Constants.SPACE_MARK);
			sb.append(MappingsXtdex.toXtext(mappings));
		}
		return sb.toString();
	}
	
	private SwitchXtdex() {}
	
}
