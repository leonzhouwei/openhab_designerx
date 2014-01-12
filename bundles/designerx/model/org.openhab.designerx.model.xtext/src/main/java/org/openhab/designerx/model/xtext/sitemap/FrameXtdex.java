package org.openhab.designerx.model.xtext.sitemap;

import org.openhab.designerx.model.sitemap.Frame;
import org.openhab.designerx.model.sitemap.NestableElement;
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
	
	static final String TARGET_TYPE_NAME = "Frame";
	
	public static Frame fromXtext(NestableElementXtextKeeper keeper) {
		return (Frame) NestableElementXtdex.fromXtext(keeper);
	}
	
	static Frame fromXtextWithoutChildren(String xtext) {
		xtext = PreProcessor.preProcess(xtext);
		if (!xtext.startsWith(TARGET_TYPE_NAME)) {
			return null;
		}
		Frame instance = new FrameBuilder().build();
		// set the elementary parameters
		ElementXtdex.set(instance, xtext);
		return instance;
	}
	
	public static String toXtext(Frame e) {
		return toXtext(e, "");
	}
	
	public static String toXtext(Frame e, String indentation) {
		return NestableElementXtdex.toXtext((NestableElement) e, indentation);
	}
	
	static String toXtextWithoutChildren(Frame e) {
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
	
	private FrameXtdex() {}
	
	public static boolean isFrame(String xtext) {
		boolean result = false;
		if (xtext.trim().startsWith(TARGET_TYPE_NAME)) {
			result = true;
		}
		return result;
	}

}
