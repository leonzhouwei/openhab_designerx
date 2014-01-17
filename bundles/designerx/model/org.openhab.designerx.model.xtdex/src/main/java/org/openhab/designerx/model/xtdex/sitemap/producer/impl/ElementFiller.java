package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import java.util.List;

import org.openhab.designerx.model.sitemap.ColorArray;
import org.openhab.designerx.model.sitemap.Element;
import org.openhab.designerx.model.sitemap.VisibilityRule;
import org.openhab.designerx.model.xtdex.ModelXtdexConstants;

final class ElementFiller {
	
	static void fillWithoutChildren(Element e, ChildlessElementXtextKeeper keeper) {
		String xtext = keeper.getXtext();
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
	}
	
	private ElementFiller() {}

}
