package org.openhab.designerx.model.xtext.sitemap;

import java.util.List;

import org.openhab.designerx.model.sitemap.ColorArray;
import org.openhab.designerx.model.sitemap.Element;
import org.openhab.designerx.model.sitemap.VisibilityRule;
import org.openhab.designerx.model.sitemap.impl.ElementBuilder;

final class ElementXtdex {
	
	static void set(Element target, String xtext) {
		Element source = fromXtext(xtext);
		target.setIcon(source.getIcon());
		target.setItem(source.getItem());
		target.setLabel(source.getLabel());
		target.addLabelColor(source.getLabelColor());
		target.addValueColor(source.getValueColor());
		target.addVisibility(source.getVisibility());
	}
	
	static Element fromXtext(String xtext) {
		xtext = PreProcessor.preProcess(xtext);
		Element e = new ElementBuilder().build();
		String item = PropertyHandler.getValue(xtext, Constants.ITEM);
		e.setItem(item);
		String label = PropertyHandler.getValueBetweenDoubleQuotes(xtext, Constants.LABEL);
		e.setLabel(label);
		String icon = PropertyHandler.getValueBetweenDoubleQuotes(xtext, Constants.ICON);
		e.setIcon(icon);
		List<ColorArray> labelcolor = ColorArrayXtdex.fromXtext(xtext, Constants.LABELCOLOR);
		e.addLabelColor(labelcolor);
		List<ColorArray> valuecolor = ColorArrayXtdex.fromXtext(xtext, Constants.VALUECOLOR);
		e.addValueColor(valuecolor);
		List<VisibilityRule> visibility = VisibilityRulesXtdex.fromXtext(xtext);
		e.addVisibility(visibility);
		return e;
	}
	
	static String toXtext(Element e) {
		StringBuilder sb = new StringBuilder();
		sb.append(Constants.SPACE_MARK);
		//
		String item = e.getItem();
		if (e.getItem() != null) {
			sb.append(Constants.ITEM);
			sb.append(Constants.EQU_MARK);
			sb.append(item);
			sb.append(Constants.SPACE_MARK);
		}
		String label = e.getLabel();
		if (label != null) {
			sb.append(Constants.LABEL);
			sb.append(Constants.EQU_MARK);
			sb.append(Constants.DOUBLE_QUOTE_MARK);
			sb.append(label);
			sb.append(Constants.DOUBLE_QUOTE_MARK);
			sb.append(Constants.SPACE_MARK);
		}
		String icon = e.getIcon();
		if (icon != null) {
			sb.append(Constants.ICON);
			sb.append(Constants.EQU_MARK);
			sb.append(Constants.DOUBLE_QUOTE_MARK);
			sb.append(icon);
			sb.append(Constants.DOUBLE_QUOTE_MARK);
			sb.append(Constants.SPACE_MARK);
		}
		List<ColorArray> labelColor = e.getLabelColor();
		if (!labelColor.isEmpty()) {
			sb.append(Constants.LABELCOLOR);
			sb.append(Constants.EQU_MARK);
			sb.append(ColorArrayXtdex.toXtext(labelColor, Constants.LABELCOLOR));
			sb.append(Constants.SPACE_MARK);
		}
		List<ColorArray> valueColor = e.getValueColor();
		if (!valueColor.isEmpty()) {
			sb.append(ColorArrayXtdex.toXtext(valueColor, Constants.VALUECOLOR));
			sb.append(Constants.SPACE_MARK);
		}
		List<VisibilityRule> visibility = e.getVisibility();
		if (!visibility.isEmpty()) {
			sb.append(VisibilityRulesXtdex.toXtext(visibility));
			sb.append(Constants.SPACE_MARK);
		}
		return sb.toString().trim();
	}
	
}
