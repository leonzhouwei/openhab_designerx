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
		if (e.getItem() != null) {
			sb.append(Constants.ITEM);
			sb.append(Constants.EQU_MARK);
			sb.append(e.getItem());
			sb.append(Constants.SPACE_MARK);
		}
		if (e.getLabel() != null) {
			sb.append(Constants.LABEL);
			sb.append(Constants.EQU_MARK);
			sb.append(Constants.DOUBLE_QUOTE_MARK);
			sb.append(e.getLabel());
			sb.append(Constants.DOUBLE_QUOTE_MARK);
			sb.append(Constants.SPACE_MARK);
		}
		if (e.getIcon() != null) {
			sb.append(Constants.ICON);
			sb.append(Constants.EQU_MARK);
			sb.append(Constants.DOUBLE_QUOTE_MARK);
			sb.append(e.getIcon());
			sb.append(Constants.DOUBLE_QUOTE_MARK);
			sb.append(Constants.SPACE_MARK);
		}
		if (!e.getLabelColor().isEmpty()) {
			sb.append(Constants.LABELCOLOR);
			sb.append(Constants.EQU_MARK);
			sb.append(ColorArrayXtdex.toXtext(e.getLabelColor(), Constants.LABELCOLOR));
			sb.append(Constants.SPACE_MARK);
		}
		if (!e.getValueColor().isEmpty()) {
			sb.append(ColorArrayXtdex.toXtext(e.getValueColor(), Constants.VALUECOLOR));
			sb.append(Constants.SPACE_MARK);
		}
		if (!e.getVisibility().isEmpty()) {
			sb.append(VisibilityRulesXtdex.toXtext(e.getVisibility()));
			sb.append(Constants.SPACE_MARK);
		}
		return sb.toString().trim();
	}
	
}
