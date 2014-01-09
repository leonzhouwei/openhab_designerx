package org.openhab.designerx.model.sitemap.childlesselement.xtext;

import org.openhab.designerx.model.sitemap.List;
import org.openhab.designerx.model.sitemap.impl.ListBuilder;

/**
 * 
 * Syntax:
 * List item="<itemname>" [label="<labelname>"] [icon="<iconname>"] [separator=""]
 * 
 * @author zhouwei
 *
 */
public final class ListXtdex {
	
	public static final String TARGET_TYPE_NAME = "List";
	
	private static final String SEPARATOR = "separator";
	
	public static List fromXtext(String xtext) {
		xtext = PreProcessor.preProcess(xtext);
		if (!xtext.startsWith(TARGET_TYPE_NAME)) {
			throw new RuntimeException(xtext + " is NOT a " + TARGET_TYPE_NAME);
		}
		List instance = new ListBuilder().build();
		// set the elementary parameters
		ElementXtdex.set(instance, xtext);
		// separator
		String separator = PropertyHandler.getValue(xtext, SEPARATOR);
		instance.setSeparator(separator);
		return instance;
	}
	
	public static String toXtext(List e) {
		StringBuilder sb = new StringBuilder();
		sb.append(TARGET_TYPE_NAME);
		sb.append(Constants.SPACE_MARK);
		if (e.getSeparator() != null) {
			sb.append(SEPARATOR);
			sb.append(Constants.EQU_MARK);
			sb.append(e.getSeparator());
		}
		sb.append(ElementXtdex.toXtext(e).trim());
		return sb.toString().trim();
	}
	
	private ListXtdex() {}
	
}
