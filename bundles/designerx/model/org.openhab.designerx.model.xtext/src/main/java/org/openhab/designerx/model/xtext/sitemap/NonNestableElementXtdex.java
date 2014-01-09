package org.openhab.designerx.model.xtext.sitemap;

import org.openhab.designerx.model.sitemap.NonNestableElement;

public final class NonNestableElementXtdex {
	
	public static final NonNestableElement fromXtext(String xtext) {
		xtext = xtext.trim();
		// Chart
		if (xtext.startsWith(ChartXtdex.TARGET_TYPE_NAME)) {
			return ChartXtdex.fromXtext(xtext);
		}
		if (xtext.startsWith(ColorpickerXtdex.TARGET_TYPE_NAME)) {
			return ColorpickerXtdex.fromXtext(xtext);
		}
		if (xtext.startsWith(ListXtdex.TARGET_TYPE_NAME)) {
			return ListXtdex.fromXtext(xtext);
		}
		if (xtext.startsWith(SelectionXtdex.TARGET_TYPE_NAME)) {
			return SelectionXtdex.fromXtext(xtext);
		}
		if (xtext.startsWith(SetpointXtdex.TARGET_TYPE_NAME)) {
			return SetpointXtdex.fromXtext(xtext);
		}
		if (xtext.startsWith(SliderXtdex.TARGET_TYPE_NAME)) {
			return SliderXtdex.fromXtext(xtext);
		}
		if (xtext.startsWith(SwitchXtdex.TARGET_TYPE_NAME)) {
			return SwitchXtdex.fromXtext(xtext);
		}
		if (xtext.startsWith(VideoXtdex.TARGET_TYPE_NAME)) {
			return VideoXtdex.fromXtext(xtext);
		}
		if (xtext.startsWith(WebviewXtdex.TARGET_TYPE_NAME)) {
			return WebviewXtdex.fromXtext(xtext);
		}
		return null;
	}

}
