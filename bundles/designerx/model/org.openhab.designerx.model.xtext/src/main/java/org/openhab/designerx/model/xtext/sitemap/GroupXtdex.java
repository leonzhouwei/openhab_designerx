package org.openhab.designerx.model.xtext.sitemap;

import org.openhab.designerx.model.sitemap.Group;
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
	
	public static final String TARGET_TYPE_NAME = "Group";
	
	public static Group fromXtext(String xtext) {
		xtext = PreProcessor.preProcess(xtext);
		if (!xtext.startsWith(TARGET_TYPE_NAME)) {
			throw new RuntimeException(xtext + " is NOT a " + TARGET_TYPE_NAME);
		}
		Group instance = new GroupBuilder().build();
		// set the elementary parameters
		ElementXtdex.set(instance, xtext);
		return instance;
	}
	
	public static String toXtext(Group e) {
		return toXtextWithoutChildren(e);
	}
	
	public static String toXtextWithoutChildren(Group e) {
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
	
}
