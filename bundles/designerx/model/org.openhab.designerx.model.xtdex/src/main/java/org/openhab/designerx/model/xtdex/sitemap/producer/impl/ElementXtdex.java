package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import java.util.List;

import org.openhab.designerx.model.sitemap.ColorArray;
import org.openhab.designerx.model.sitemap.Element;
import org.openhab.designerx.model.sitemap.VisibilityRule;
import org.openhab.designerx.model.sitemap.impl.ElementBuilder;
import org.openhab.designerx.model.xtdex.ModelXtdexConstants;

final class ElementXtdex {
	
	static void set(Element target, String xtext) {
		Element source = parseIgnoringChildren(xtext);
		target.setIcon(source.getIcon());
		target.setItem(source.getItem());
		target.setLabel(source.getLabel());
		target.addLabelColor(source.getLabelColor());
		target.addValueColor(source.getValueColor());
		target.addVisibility(source.getVisibility());
	}
	
	static Element parseIgnoringChildren(String xtext) {
		xtext = PreProcessor.preProcess(xtext);
		Element e = new ElementBuilder().build();
		String item = PropertyHandler.getValue(xtext, ModelXtdexConstants.ITEM);
		e.setItem(item);
		String label = PropertyHandler.getValueBetweenDoubleQuotes(xtext, ModelXtdexConstants.LABEL);
		e.setLabel(label);
		String icon = PropertyHandler.getValueBetweenDoubleQuotes(xtext, ModelXtdexConstants.ICON);
		e.setIcon(icon);
		List<ColorArray> labelcolor = ColorArrayXtdex.fromXtext(xtext, ModelXtdexConstants.LABELCOLOR);
		e.addLabelColor(labelcolor);
		List<ColorArray> valuecolor = ColorArrayXtdex.fromXtext(xtext, ModelXtdexConstants.VALUECOLOR);
		e.addValueColor(valuecolor);
		List<VisibilityRule> visibility = VisibilityRulesXtdex.fromXtext(xtext);
		e.addVisibility(visibility);
		return e;
	}
	
	static String toXtext(Element e) {
		StringBuilder sb = new StringBuilder();
		//
		String item = e.getItem();
		if (e.getItem() != null) {
			sb.append(ModelXtdexConstants.ITEM);
			sb.append(ModelXtdexConstants.EQU_MARK);
			sb.append(item);
			sb.append(ModelXtdexConstants.SPACE_MARK);
		}
		String label = e.getLabel();
		if (label != null) {
			sb.append(ModelXtdexConstants.LABEL);
			sb.append(ModelXtdexConstants.EQU_MARK);
			sb.append(ModelXtdexConstants.DOUBLE_QUOTE_MARK);
			sb.append(label);
			sb.append(ModelXtdexConstants.DOUBLE_QUOTE_MARK);
			sb.append(ModelXtdexConstants.SPACE_MARK);
		}
		String icon = e.getIcon();
		if (icon != null) {
			sb.append(ModelXtdexConstants.ICON);
			sb.append(ModelXtdexConstants.EQU_MARK);
			sb.append(ModelXtdexConstants.DOUBLE_QUOTE_MARK);
			sb.append(icon);
			sb.append(ModelXtdexConstants.DOUBLE_QUOTE_MARK);
			sb.append(ModelXtdexConstants.SPACE_MARK);
		}
		List<ColorArray> labelColor = e.getLabelColor();
		if (!labelColor.isEmpty()) {
			sb.append(ModelXtdexConstants.LABELCOLOR);
			sb.append(ModelXtdexConstants.EQU_MARK);
			sb.append(ColorArrayXtdex.toXtext(labelColor, ModelXtdexConstants.LABELCOLOR));
			sb.append(ModelXtdexConstants.SPACE_MARK);
		}
		List<ColorArray> valueColor = e.getValueColor();
		if (!valueColor.isEmpty()) {
			sb.append(ColorArrayXtdex.toXtext(valueColor, ModelXtdexConstants.VALUECOLOR));
			sb.append(ModelXtdexConstants.SPACE_MARK);
		}
		List<VisibilityRule> visibility = e.getVisibility();
		if (!visibility.isEmpty()) {
			sb.append(VisibilityRulesXtdex.toXtext(visibility));
			sb.append(ModelXtdexConstants.SPACE_MARK);
		}
		return sb.toString().trim();
	}
	
}
