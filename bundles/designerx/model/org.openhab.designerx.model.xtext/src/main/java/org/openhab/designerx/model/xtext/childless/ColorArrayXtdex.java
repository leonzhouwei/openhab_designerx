package org.openhab.designerx.model.xtext.childless;

import org.openhab.designerx.model.sitemap.ColorArray;
import org.openhab.designerx.model.sitemap.impl.ColorArrayBuilder;

public final class ColorArrayXtdex {
	
	public static final String TYPE = "colorarry";
	
	public static ColorArray fromXtext(String xtext) {
		xtext = xtext.replaceAll("\\{", "").trim();
		if (!xtext.startsWith(TYPE)) {
			throw new RuntimeException(xtext + " is NOT a " + TYPE);
		}
		ColorArray instance = new ColorArrayBuilder().build();
		// set the parameters
		String arg = Extractor.extract(xtext, Constants.ARG_EQU, "\\b" + Constants.ARG_EQU + "\\w*");
		instance.setArg(arg);
		String condition = Extractor.extract(xtext, Constants.CONDITION_EQU, "\\b" + Constants.CONDITION_EQU + "\\w*");
		instance.setCondition(condition);
		String item = Extractor.extract(xtext, Constants.ITEM_EQU, "\\b" + Constants.ITEM_EQU + "\\w*");
		instance.setItem(item);
		String sign = Extractor.extract(xtext, Constants.SIGN_EQU, "\\b" + Constants.SIGN_EQU + "\\w*");
		instance.setSign(sign);
		String state = Extractor.extract(xtext, Constants.STATE_EQU, "\\b" + Constants.STATE_EQU + "\\w*");
		instance.setState(state);
		return instance;
	}
	
	public static String toXtext(ColorArray colorArray) {
		return null;
	}
	
	private ColorArrayXtdex() {}

}
