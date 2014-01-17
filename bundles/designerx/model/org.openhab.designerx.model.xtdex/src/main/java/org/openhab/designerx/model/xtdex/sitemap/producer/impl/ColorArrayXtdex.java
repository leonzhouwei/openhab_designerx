package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import java.util.List;
import java.util.Set;

import org.openhab.designerx.model.sitemap.ColorArray;
import org.openhab.designerx.model.sitemap.producer.ColorArrayBuilder;
import org.openhab.designerx.model.sitemap.producer.impl.ColorArrayBuilderImpl;
import org.openhab.designerx.model.xtdex.ModelXtdexConstants;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;

final class ColorArrayXtdex {
	
	//  Valid operators are the ==, >=, <=, !=, >, <.
	private static Set<String> VALIDE_OPERATORS = ImmutableSet.<String>builder()
			.add("==")
			.add(">=")
			.add("<=")
			.add("!=")
			.add(">")
			.add("<")
			.build();
	private static final ColorArrayBuilder builder = new ColorArrayBuilderImpl();
	
	static List<ColorArray> fromXtext(String xtext, String type) {
		xtext = xtext.trim();
		type = type.trim();
		List<ColorArray> ret = Lists.newArrayList();
		if (!xtext.matches(".*" + type + "=\\[.*\\]")) {
			return ret;
		}
		// extract the "[...]" part
		int i = xtext.indexOf(type);
		i = xtext.indexOf("[", i);
		int j = xtext.indexOf("]", i);
		xtext = xtext.substring(i + 1, j).trim();
		if (xtext.isEmpty()) {
			return ret;
		}
		String[] rules = xtext.split(",");
		// parse
		for (String rule : rules) {
			ColorArray e = parseRule(rule);
			ret.add(e);
		}
		// set the parameters
		return ret;
	}
	
	static String toXtext(List<ColorArray> colorArray, String type) {
		type = type.trim();
		StringBuilder sb = new StringBuilder();
		sb.append(type);
		sb.append(ModelXtdexConstants.EQU_MARK);
		sb.append("[");
		int count = 0;
		for (ColorArray e : colorArray) {
			String itemName = e.getItem();
			if (itemName != null) {
				sb.append(itemName);
			}
			String condition = e.getCondition();
			if (condition != null) {
				sb.append(condition);
			}
			String arg = e.getArg();
			if (arg != null) {
				count += 1;
				sb.append(ModelXtdexConstants.EQU_MARK);
				sb.append(arg);
				sb.append(ModelXtdexConstants.COMMA_MARK);	
			}
		}
		if (count > 0) {
			sb.deleteCharAt(sb.length() - 1);
		}
		sb.append("]");
		return sb.toString().trim();
	}
	
	private static ColorArray parseRule(String rule) {
		rule = rule.trim();
		ColorArray e = builder.build();
		int equ = rule.lastIndexOf("=");
		String pre = rule.substring(0, equ).trim();
		String arg = rule.substring(equ + 1).trim();
		//  Valid operators are the ==, >=, <=, !=, >, <.
		for (String operator : VALIDE_OPERATORS) {
			e.setCondition(pre);
			if (pre.endsWith(operator)) {
				String[] split = pre.split(operator);
				if (split.length == 2) {
					e.setItem(split[0]);
				}
				break;
			}
		}
		e.setArg(arg);
		return e;
	}
	
	private ColorArrayXtdex() {}

}
