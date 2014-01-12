package org.openhab.designerx.model.xtext.sitemap;

import org.openhab.designerx.model.sitemap.Group;
import org.openhab.designerx.model.sitemap.NestableElement;
import org.openhab.designerx.model.sitemap.impl.GroupBuilder;

/**
 * 
 * Syntax:
 * Group [item="<itemname>"] [label="<labelname>"] [icon="<iconname>"]
 * 
 * @author zhouwei
 *
 */
public final class GroupXtdex {
	
	static final String TARGET_TYPE_NAME = "Group";
	
	public static Group fromXtext(NestableElementXtextKeeper keeper) {
		return (Group) NestableElementXtdex.fromXtext(keeper);
	}
	
	static Group fromXtextWithoutChildren(String xtext) {
		xtext = PreProcessor.preProcess(xtext);
		if (!xtext.startsWith(TARGET_TYPE_NAME)) {
			return null;
		}
		Group instance = new GroupBuilder().build();
		// set the elementary parameters
		ElementXtdex.set(instance, xtext);
		return instance;
	}
	
	public static String toXtext(Group e) {
		return toXtext(e, "");
	}
	
	public static String toXtext(Group e, String indentation) {
		return NestableElementXtdex.toXtext((NestableElement) e, indentation);
	}
	
	static String toXtextWithoutChildren(Group e) {
		StringBuilder sb = new StringBuilder();
		sb.append(TARGET_TYPE_NAME);
		sb.append(Constants.SPACE_MARK);
		// element
		String elemStr = ElementXtdex.toXtext(e);
		if (!elemStr.isEmpty()) {
			sb.append(elemStr);	
			sb.append(Constants.SPACE_MARK);
		}
		return sb.toString().trim();
	}
	
	private GroupXtdex() {}
	
	public static boolean isGroup(String xtext) {
		boolean result = false;
		if (xtext.trim().startsWith(TARGET_TYPE_NAME)) {
			result = true;
		}
		return result;
	}
	
}
