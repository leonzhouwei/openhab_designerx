package org.openhab.designerx.model.xtext.childless;

import java.util.Map;

import org.openhab.designerx.model.sitemap.ColorArray;
import org.openhab.designerx.model.sitemap.impl.ColorArrayBuilder;

import com.google.common.collect.ImmutableSet;

public final class ColorArrayXtdex {
	
	public static final String TYPE = "ColorArray";

	public static final ImmutableSet<String> KEYWORDS = ImmutableSet.<String> builder()
			.add(TYPE)
			.add("arg=")
			.add("condition=")
			.add("item")
			.add("sign=")
			.add("state=")
			.build();
	
	public static ColorArray fromXtext(String xtext) {
		xtext = xtext.replaceAll("\\{", "").trim();
		if (!xtext.startsWith(TYPE)) {
			throw new RuntimeException(xtext + " is NOT a " + TYPE);
		}
		ColorArray instance = new ColorArrayBuilder().build();
		Map<String, String> map = Separator.separate(xtext, KEYWORDS);
		// set the parameters
		String value = null;
		value = map.get("arg=");
		if (value != null) {
			instance.setArg(value);
		}
		value = map.get("condition=");
		if (value != null) {
			instance.setCondition(value);
		}
		value = map.get("item=");
		if (value != null) {
			instance.setItem(value);
		}
		value = map.get("sign=");
		if (value != null) {
			instance.setSign(value);
		}
		value = map.get("state=");
		if (value != null) {
			instance.setState(value);
		}
		return instance;
	}
	
	public static String toXtext(ColorArray colorArray) {
		return null;
	}
	
	private ColorArrayXtdex() {}

}
