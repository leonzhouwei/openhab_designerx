package org.openhab.designerx.model.xtext.sitemap;

import java.util.List;

import org.openhab.designerx.model.sitemap.ColorArray;
import org.openhab.designerx.model.sitemap.Element;
import org.openhab.designerx.model.sitemap.VisibilityRule;
import org.openhab.designerx.model.sitemap.impl.ElementBuilder;
import org.openhab.designerx.model.xtext.XtextConstants;

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
		String item = PropertyHandler.getValue(xtext, XtextConstants.ITEM);
		e.setItem(item);
		String label = PropertyHandler.getValueBetweenDoubleQuotes(xtext, XtextConstants.LABEL);
		e.setLabel(label);
		String icon = PropertyHandler.getValueBetweenDoubleQuotes(xtext, XtextConstants.ICON);
		e.setIcon(icon);
		List<ColorArray> labelcolor = ColorArrayXtdex.fromXtext(xtext, XtextConstants.LABELCOLOR);
		e.addLabelColor(labelcolor);
		List<ColorArray> valuecolor = ColorArrayXtdex.fromXtext(xtext, XtextConstants.VALUECOLOR);
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
			sb.append(XtextConstants.ITEM);
			sb.append(XtextConstants.EQU_MARK);
			sb.append(item);
			sb.append(XtextConstants.SPACE_MARK);
		}
		String label = e.getLabel();
		if (label != null) {
			sb.append(XtextConstants.LABEL);
			sb.append(XtextConstants.EQU_MARK);
			sb.append(XtextConstants.DOUBLE_QUOTE_MARK);
			sb.append(label);
			sb.append(XtextConstants.DOUBLE_QUOTE_MARK);
			sb.append(XtextConstants.SPACE_MARK);
		}
		String icon = e.getIcon();
		if (icon != null) {
			sb.append(XtextConstants.ICON);
			sb.append(XtextConstants.EQU_MARK);
			sb.append(XtextConstants.DOUBLE_QUOTE_MARK);
			sb.append(icon);
			sb.append(XtextConstants.DOUBLE_QUOTE_MARK);
			sb.append(XtextConstants.SPACE_MARK);
		}
		List<ColorArray> labelColor = e.getLabelColor();
		if (!labelColor.isEmpty()) {
			sb.append(XtextConstants.LABELCOLOR);
			sb.append(XtextConstants.EQU_MARK);
			sb.append(ColorArrayXtdex.toXtext(labelColor, XtextConstants.LABELCOLOR));
			sb.append(XtextConstants.SPACE_MARK);
		}
		List<ColorArray> valueColor = e.getValueColor();
		if (!valueColor.isEmpty()) {
			sb.append(ColorArrayXtdex.toXtext(valueColor, XtextConstants.VALUECOLOR));
			sb.append(XtextConstants.SPACE_MARK);
		}
		List<VisibilityRule> visibility = e.getVisibility();
		if (!visibility.isEmpty()) {
			sb.append(VisibilityRulesXtdex.toXtext(visibility));
			sb.append(XtextConstants.SPACE_MARK);
		}
		return sb.toString().trim();
	}
	
}
