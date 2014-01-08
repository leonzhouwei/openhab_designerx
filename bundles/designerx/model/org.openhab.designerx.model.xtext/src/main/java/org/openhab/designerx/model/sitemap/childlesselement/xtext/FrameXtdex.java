package org.openhab.designerx.model.sitemap.childlesselement.xtext;

import org.openhab.designerx.model.sitemap.Frame;
import org.openhab.designerx.model.sitemap.Element;
import org.openhab.designerx.model.sitemap.impl.FrameBuilder;

public final class FrameXtdex {
	
	public static final String TARGET_TYPE_NAME = "Frame";
	
	public static Frame fromXtext(String xtext) {
		xtext = PreProcessor.preProcess(xtext);
		if (!xtext.startsWith(TARGET_TYPE_NAME)) {
			throw new RuntimeException(xtext + " is NOT a " + TARGET_TYPE_NAME);
		}
		Frame instance = new FrameBuilder().build();
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
	
	public static String toXtext(Frame e) {
		StringBuilder sb = new StringBuilder();
		sb.append(TARGET_TYPE_NAME);
		sb.append(Constants.SPACE_MARK);
		sb.append(ElementXtdex.toXtext(e).trim());
		return sb.toString().trim();
	}
	
	private FrameXtdex() {}

}