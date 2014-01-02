package org.openhab.designerx.model.xtext.childless;

import org.openhab.designerx.model.sitemap.ColorArray;
import org.openhab.designerx.model.sitemap.Element;
import org.openhab.designerx.model.sitemap.VisibilityRule;
import org.openhab.designerx.model.sitemap.impl.ElementBuilder;

public final class ElementXdtex {
	
	public static Element fromXtext(String xtext) {
		xtext = Extractor.preProcess(xtext);
		Element e = new ElementBuilder().build();
		String item = Extractor.extract(xtext, Constants.ITEM_EQU, "\\b" + Constants.ITEM_EQU + "\\w*");
		e.setItem(item);
		String label = Extractor.extract(xtext, Constants.LABEL_EQU, "\\b" + Constants.LABEL_EQU + "\".*?\"\\s?");
		e.setLabel(label);
		String icon = Extractor.extract(xtext, Constants.ICON_EQU, "\\b" + Constants.ICON_EQU + "\".*?\"\\s");
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
			sb.append(Constants.ITEM_EQU);
			sb.append(e.getItem());
			sb.append(Constants.SPACE_MARK);
		}
		if (e.getLabel() != null) {
			sb.append(Constants.LABEL_EQU);
			sb.append(e.getLabel());
			sb.append(Constants.SPACE_MARK);
		}
		if (e.getIcon() != null) {
			sb.append(Constants.ICON_EQU);
			sb.append(e.getIcon());
			sb.append(Constants.SPACE_MARK);
		}
		return sb.toString().trim();
	}
	
}
