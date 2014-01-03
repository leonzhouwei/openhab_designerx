package org.openhab.designerx.model.sitemap.childlesselement.xtext;

import org.openhab.designerx.model.sitemap.ColorArray;
import org.openhab.designerx.model.sitemap.Element;
import org.openhab.designerx.model.sitemap.VisibilityRule;
import org.openhab.designerx.model.sitemap.impl.ElementBuilder;

public final class ElementXtdex {
	
	public static Element fromXtext(String xtext) {
		xtext = PreProcessor.preProcess(xtext);
		Element e = new ElementBuilder().build();
		String item = PropertyHandler.getValue(xtext, Constants.ITEM);
		e.setItem(item);
		String label = PropertyHandler.getValue(xtext, Constants.LABEL, "\"", "\"");
		e.setLabel(label);
		String icon = PropertyHandler.getValue(xtext, Constants.ICON, "\"", "\"");
		e.setIcon(icon);
		ColorArray lableColor = null;
		e.addLabelColor(lableColor);
		ColorArray valueColor = null;
		e.addValueColor(valueColor);
		VisibilityRule vr = null;
		e.addVisibility(vr);
		return e;
	}
	
	public static String toXtext(Element e) {
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
			sb.append(e.getLabel());
			sb.append(Constants.SPACE_MARK);
		}
		if (e.getIcon() != null) {
			sb.append(Constants.ICON);
			sb.append(Constants.EQU_MARK);
			sb.append(e.getIcon());
			sb.append(Constants.SPACE_MARK);
		}
		return sb.toString().trim();
	}
	
}
