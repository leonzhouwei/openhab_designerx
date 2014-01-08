package org.openhab.designerx.model.sitemap.childlesselement.xtext;

import org.openhab.designerx.model.sitemap.Element;
import org.openhab.designerx.model.sitemap.Group;
import org.openhab.designerx.model.sitemap.impl.GroupBuilder;

public final class GroupXtdex {
	
	public static final String TARGET_TYPE_NAME = "Group";
	
	public static Group fromXtext(String xtext) {
		xtext = PreProcessor.preProcess(xtext);
		if (!xtext.startsWith(TARGET_TYPE_NAME)) {
			throw new RuntimeException(xtext + " is NOT a " + TARGET_TYPE_NAME);
		}
		Group instance = new GroupBuilder().build();
		// set the elementary parameters
		Element e = ElementXtdex.fromXtext(xtext);
		instance.setIcon(e.getIcon());
		instance.setItem(e.getItem());
		instance.setLabel(e.getLabel());
		instance.addLabelColor(e.getLabelColor());
		instance.addValueColor(e.getValueColor());
		instance.addVisibility(e.getVisibility());
		return instance;
	}
	
	public static String toXtext(Group e) {
		StringBuilder sb = new StringBuilder();
		sb.append(TARGET_TYPE_NAME);
		sb.append(Constants.SPACE_MARK);
		sb.append(ElementXtdex.toXtext(e).trim());
		return sb.toString().trim();
	}
	
	private GroupXtdex() {}
	
}
