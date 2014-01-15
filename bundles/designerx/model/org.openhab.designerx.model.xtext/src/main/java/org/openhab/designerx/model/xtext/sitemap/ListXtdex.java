package org.openhab.designerx.model.xtext.sitemap;

import org.openhab.designerx.model.sitemap.List;
import org.openhab.designerx.model.sitemap.impl.ListBuilder;
import org.openhab.designerx.model.xtext.XtextConstants;

/**
 * 
 * Syntax:
 * List item="<itemname>" [label="<labelname>"] [icon="<iconname>"] [separator=""]
 * 
 * @author zhouwei
 *
 */
public final class ListXtdex {
	
	static final String TARGET_TYPE_NAME = "List";
	private static final String MATCH_REGEX = "\\s*" + TARGET_TYPE_NAME + "\\b.*";
	
	private static final String SEPARATOR = "separator";
	
	static List fromXtext(NonNestableElementXtextKeeper keeper) {
		return fromXtext(keeper.getXtext());
	}
	
	static List fromXtext(String xtext) {
		xtext = PreProcessor.preProcess(xtext);
		if (!xtext.startsWith(TARGET_TYPE_NAME)) {
			return null;
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
		sb.append(XtextConstants.SPACE_MARK);
		// element
		String elemStr = ElementXtdex.toXtext(e);
		if (!elemStr.isEmpty()) {
			sb.append(elemStr);	
			sb.append(XtextConstants.SPACE_MARK);
		}
		// separator
		String separator = e.getSeparator();
		if (separator != null) {
			sb.append(SEPARATOR);
			sb.append(XtextConstants.EQU_MARK);
			sb.append(separator);
			sb.append(XtextConstants.SPACE_MARK);
		}
		return sb.toString().trim();
	}
	
	private ListXtdex() {}
	
	public static boolean isList(String xtext) {
		boolean result = false;
		if (xtext.matches(MATCH_REGEX)) {
			result = true;
		}
		return result;
	}
	
}
