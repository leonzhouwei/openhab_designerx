package org.openhab.designerx.model.sitemap.childlesselement.xtext;

import org.openhab.designerx.model.sitemap.Mapping;
import org.openhab.designerx.model.sitemap.VisibilityRule;
import org.openhab.designerx.model.sitemap.impl.VisibilityRuleBuilder;

public final class VisibilityRuleXtdex {
	
	public static final String TYPE = "VisibilityRule";
	
	public static VisibilityRule fromXtext(String xtext) {
		xtext = PreProcessor.preProcess(xtext);
		if (!xtext.startsWith(TYPE)) {
			throw new RuntimeException(xtext + " is NOT a " + TYPE);
		}
		VisibilityRule instance = new VisibilityRuleBuilder().build();
		// set the parameters
		String condition = PropertyHandler.extract(xtext, Constants.CONDITION_EQU, "\\b" + Constants.CONDITION_EQU + "\\w*");
		instance.setCondition(condition);
		String item = PropertyHandler.extract(xtext, Constants.ITEM_EQU, "\\b" + Constants.ITEM_EQU + "\\w*");
		instance.setItem(item);
		String sign = PropertyHandler.extract(xtext, Constants.SIGN_EQU, "\\b" + Constants.SIGN_EQU + "\\w*");
		instance.setSign(sign);
		String state = PropertyHandler.extract(xtext, Constants.STATE_EQU, "\\b" + Constants.STATE_EQU + "\\w*");
		instance.setState(state);
		return instance;
	}
	
	public static String toXtext(Mapping e) {
		return null;
	}
	
	private VisibilityRuleXtdex() {}

}
