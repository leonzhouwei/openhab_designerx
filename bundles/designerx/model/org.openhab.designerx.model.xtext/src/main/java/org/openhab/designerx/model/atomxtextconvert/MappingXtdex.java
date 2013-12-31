package org.openhab.designerx.model.atomxtextconvert;

import java.util.Map;

import org.openhab.designerx.model.sitemap.Mapping;
import org.openhab.designerx.model.sitemap.impl.MappingBuilder;

import com.google.common.collect.ImmutableSet;

public final class MappingXtdex {

	public static final String TYPE = "Mapping";

	public static final ImmutableSet<String> KEYWORDS = ImmutableSet.<String> builder()
			.add(TYPE)
			.add("cmd=")
			.add("label=")
			.build();
	
	public static Mapping fromXtext(String xtext) {
		xtext = xtext.replaceAll("\\{", "").trim();
		if (!xtext.startsWith(TYPE)) {
			throw new RuntimeException(xtext + " is NOT a " + TYPE);
		}
		Mapping instance = new MappingBuilder().build();
		Map<String, String> map = Separator.separate(xtext, KEYWORDS);
		// set the parameters
		String cmd = map.get("cmd=");
		if (cmd != null) {
			instance.setCmd(cmd);
		}
		String label = map.get("label=");
		if (label != null) {
			instance.setLabel(label);
		}
		return instance;
	}
	
	public static String toXtext(Mapping e) {
		return null;
	}
	
	private MappingXtdex() {}
	
}
