package org.openhab.designerx.model.sitemap.childlesselement.xtext;

import java.util.List;
import java.util.Set;

import org.openhab.designerx.model.sitemap.VisibilityRule;
import org.openhab.designerx.model.sitemap.impl.VisibilityRuleBuilder;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;

final class VisibilityRulesXtdex {
	
	//  Valid operators are the ==, >=, <=, !=, >, <.
	private static Set<String> VALIDE_OPERATORS = ImmutableSet.<String>builder()
			.add("==")
			.add(">=")
			.add("<=")
			.add("!=")
			.add(">")
			.add("<")
			.build();
	
	public static List<VisibilityRule> fromXtext(String xtext, String type) {
		xtext = PreProcessor.preProcess(xtext);
		if (!xtext.matches(".*" + type + "=\\[.*\\]")) {
			throw new RuntimeException(xtext + " is NOT a " + type);
		}
		List<VisibilityRule> ret = Lists.newArrayList();
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
			VisibilityRule e = parseRule(rule);
			ret.add(e);
		}
		// set the parameters
		return ret;
	}
	
	public static String toXtext(List<VisibilityRule> list, String type) {
		StringBuilder sb = new StringBuilder();
		sb.append(type);
		sb.append(Constants.EQU_MARK);
		sb.append("[");
		for (VisibilityRule e : list) {
			String itemName = e.getItem();
			if (itemName != null) {
				sb.append(itemName);
			}
			String condition = e.getCondition();
			if (condition != null) {
				sb.append(condition);
			}
			sb.append(Constants.COMMA_MARK);
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("]");
		return sb.toString().trim();
	}
	
	private static VisibilityRule parseRule(String rule) {
		VisibilityRule e = new VisibilityRuleBuilder().build();
		int equ = rule.lastIndexOf("=");
		String pre = rule.substring(0, equ).trim();
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
		return e;
	}
	
	private VisibilityRulesXtdex() {}

}
