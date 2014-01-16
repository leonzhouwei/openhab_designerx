package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import org.openhab.designerx.model.sitemap.NestableElement;
import org.openhab.designerx.model.sitemap.Text;
import org.openhab.designerx.model.sitemap.impl.TextBuilder;
import org.openhab.designerx.model.xtext.XtextConstants;

/**
 * 
 * Syntax:
 * Text item="<itemname>" [label="<labelname>"] [icon="<iconname>"] [valuecolor=xxxx]
 * 
 * @author zhouwei
 *
 */
public final class TextXtdex {
	
	static final String TARGET_TYPE_NAME = "Text";
	private static final String MATCH_REGEX = "\\s*" + TARGET_TYPE_NAME + "\\b.*";
	
	public static Text fromXtext(NestableElementXtextKeeper keeper) {
		return (Text) NestableElementXtdex.fromXtext(keeper);
	}
	
	static Text fromXtextWithoutChildren(String xtext) {
		xtext = PreProcessor.preProcess(xtext);
		if (!xtext.startsWith(TARGET_TYPE_NAME)) {
			return null;
		}
		Text instance = new TextBuilder().build();
		// set the elementary parameters
		ElementXtdex.set(instance, xtext);
		// set the specific parameters
		return instance;
	}
	
	static String toXtext(Text e) {
		return toXtext(e, "");
	}
	
	public static String toXtext(Text e, String indentation) {
		return NestableElementXtdex.toXtext((NestableElement) e, indentation);
	}
	
	public static String toXtextWithoutChildren(Text e) {
		StringBuilder sb = new StringBuilder();
		sb.append(TARGET_TYPE_NAME);
		sb.append(XtextConstants.SPACE_MARK);
		// element
		String elemStr = ElementXtdex.toXtext(e);
		if (!elemStr.isEmpty()) {
			sb.append(elemStr);	
			sb.append(XtextConstants.SPACE_MARK);
		}
		return sb.toString().trim();
	}
	
	private TextXtdex() {}
	
	public static boolean isText(String xtext) {
		boolean result = false;
		if (xtext.matches(MATCH_REGEX)) {
			result = true;
		}
		return result;
	}
	
}
