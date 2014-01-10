package org.openhab.designerx.model.xtext.sitemap;

import org.openhab.designerx.model.sitemap.Frame;
import org.openhab.designerx.model.sitemap.impl.FrameBuilder;

/**
 * 
 * Syntax:
 * Frame [label="<labelname>"] [icon="<icon>"] [item="<item">]
 * 
 * @author zhouwei
 *
 */
public final class FrameXtdex {
	
	public static final String TARGET_TYPE_NAME = "Frame";
	
	public static Frame fromXtext(String xtext) {
		xtext = PreProcessor.preProcess(xtext);
		if (!xtext.startsWith(TARGET_TYPE_NAME)) {
			throw new RuntimeException(xtext + " is NOT a " + TARGET_TYPE_NAME);
		}
		Frame instance = new FrameBuilder().build();
		// set the elementary parameters
		ElementXtdex.set(instance, xtext);
		return instance;
	}
	
	public static String toXtext(Frame e) {
		StringBuilder sb = new StringBuilder();
		sb.append(TARGET_TYPE_NAME);
		sb.append(Constants.SPACE_MARK);
		sb.append(ElementXtdex.toXtext(e).trim());
		return sb.toString().trim();
	}
	
	public static String toXtextWithoutChildren(Frame e) {
		StringBuilder sb = new StringBuilder();
		sb.append(TARGET_TYPE_NAME);
		sb.append(Constants.SPACE_MARK);
		sb.append(ElementXtdex.toXtext(e));
		return sb.toString();
	}
	
	private FrameXtdex() {}

}
