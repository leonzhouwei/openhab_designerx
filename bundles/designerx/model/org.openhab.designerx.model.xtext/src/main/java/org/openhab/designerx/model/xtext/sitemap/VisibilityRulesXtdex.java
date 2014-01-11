package org.openhab.designerx.model.xtext.sitemap;

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
	
	public static List<VisibilityRule> fromXtext(String xtext) {
		xtext = PreProcessor.preProcess(xtext);
		List<VisibilityRule> visibility = Lists.newArrayList();
		if (!xtext.matches(".*" + Constants.VISIBILITY + "\\s*=.*\\[.*\\].*")) {
			return visibility;
		}
		// extract the "[...]" part
		xtext = PropertyHandler.getValueBetweenBraces(xtext, Constants.VISIBILITY);
		xtext = xtext.trim();
		String[] rules = xtext.split(",");
		// parse
		for (String rule : rules) {
			VisibilityRule e = parseRule(rule);
			visibility.add(e);
		}
		// set the parameters
		return visibility;
	}
	
	public static String toXtext(List<VisibilityRule> list) {
		StringBuilder sb = new StringBuilder();
		sb.append(Constants.VISIBILITY);
		sb.append(Constants.EQU_MARK);
		sb.append("[");
		int count = 0;
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
			count += 1;
		}
		if (count > 0) {
			sb.deleteCharAt(sb.length() - 1);
		}
		sb.append("]");
		return sb.toString().trim();
	}
	
	private static VisibilityRule parseRule(String rule) {
		VisibilityRule e = new VisibilityRuleBuilder().build();
		//  Valid operators are the ==, >=, <=, !=, >, <.
		for (String operator : VALIDE_OPERATORS) {
			if (rule.contains(operator)) {
				String[] split = rule.split(operator);
				String item = split[0].trim();
				e.setItem(item);
				String condition = (operator + split[1]).trim();
				e.setCondition(condition);
				break;
			}
		}
		return e;
	}
	
	private VisibilityRulesXtdex() {}

}
