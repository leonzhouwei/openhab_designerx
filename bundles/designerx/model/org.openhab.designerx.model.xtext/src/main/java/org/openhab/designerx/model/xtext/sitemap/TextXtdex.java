package org.openhab.designerx.model.xtext.sitemap;

import org.openhab.designerx.model.sitemap.Text;
import org.openhab.designerx.model.sitemap.impl.TextBuilder;

/**
 * 
 * Syntax:
 * Text item="<itemname>" [label="<labelname>"] [icon="<iconname>"] [valuecolor=xxxx]
 * 
 * @author zhouwei
 *
 */
public final class TextXtdex {
	
	public static final String TARGET_TYPE_NAME = "Text";
	
	public static Text fromXtext(String xtext) {
		xtext = PreProcessor.preProcess(xtext);
		if (!xtext.startsWith(TARGET_TYPE_NAME)) {
			throw new RuntimeException(xtext + " is NOT a " + TARGET_TYPE_NAME);
		}
		Text instance = new TextBuilder().build();
		// set the elementary parameters
		ElementXtdex.set(instance, xtext);
		// set the specific parameters
		return instance;
	}
	
	public static String toXtext(Text e) {
		return toXtextWithoutChildren(e);
	}
	
	public static String toXtextWithoutChildren(Text e) {
		StringBuilder sb = new StringBuilder();
		sb.append(TARGET_TYPE_NAME);
		// element
		String elemStr = ElementXtdex.toXtext(e);
		if (!elemStr.isEmpty()) {
			sb.append(Constants.SPACE_MARK);
			sb.append(elemStr);	
		}
		return sb.toString();
	}
	
	private TextXtdex() {}
	
}
