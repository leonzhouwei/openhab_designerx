package org.openhab.designerx.model.atomxtextconvert;

import java.util.Map;

import org.openhab.designerx.model.sitemap.Mapping;
import org.openhab.designerx.model.sitemap.VisibilityRule;
import org.openhab.designerx.model.sitemap.impl.VisibilityRuleBuilder;

import com.google.common.collect.ImmutableSet;

public final class VisibilityRuleXtdex {
	
	public static final String TYPE = "VisibilityRule";
	
	public static final ImmutableSet<String> KEYWORDS = ImmutableSet.<String> builder()
			.add(TYPE)
			.add("condition=")
			.add("item=")
			.add("sign=")
			.add("state=")
			.build();
	
	public static VisibilityRule fromXtext(String xtext) {
		xtext = xtext.replaceAll("\\{", "").trim();
		if (!xtext.startsWith(TYPE)) {
			throw new RuntimeException(xtext + " is NOT a " + TYPE);
		}
		VisibilityRule instance = new VisibilityRuleBuilder().build();
		Map<String, String> map = Separator.separate(xtext, KEYWORDS);
		// set the parameters
		String condition = map.get("condition=");
		if (condition != null) {
			instance.setCondition(condition);
		}
		String item = map.get("item=");
		if (item != null) {
			instance.setItem(item);
		}
		String sign = map.get("sign=");
		if (sign != null) {
			instance.setSign(sign);
		}
		String state = map.get("state=");
		if (state != null) {
			instance.setState(state);
		}
		return instance;
	}
	
	public static String toXtext(Mapping e) {
		return null;
	}
	
	private VisibilityRuleXtdex() {}

}
