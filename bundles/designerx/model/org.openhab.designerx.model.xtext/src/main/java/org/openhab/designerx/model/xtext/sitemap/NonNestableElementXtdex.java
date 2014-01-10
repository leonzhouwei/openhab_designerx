package org.openhab.designerx.model.xtext.sitemap;

import org.openhab.designerx.model.sitemap.Chart;
import org.openhab.designerx.model.sitemap.Colorpicker;
import org.openhab.designerx.model.sitemap.List;
import org.openhab.designerx.model.sitemap.NonNestableElement;
import org.openhab.designerx.model.sitemap.Selection;
import org.openhab.designerx.model.sitemap.Setpoint;
import org.openhab.designerx.model.sitemap.Slider;
import org.openhab.designerx.model.sitemap.Switch;
import org.openhab.designerx.model.sitemap.Video;
import org.openhab.designerx.model.sitemap.Webview;

import com.google.common.collect.ImmutableSet;

final class NonNestableElementXtdex {
	
	private static ImmutableSet<String> validTypeNames = ImmutableSet.<String>builder()
			.add(ChartXtdex.TARGET_TYPE_NAME)
			.add(ColorpickerXtdex.TARGET_TYPE_NAME)
			.add(ListXtdex.TARGET_TYPE_NAME)
			.add(SelectionXtdex.TARGET_TYPE_NAME)
			.add(SetpointXtdex.TARGET_TYPE_NAME)
			.add(SliderXtdex.TARGET_TYPE_NAME)
			.add(SwitchXtdex.TARGET_TYPE_NAME)
			.add(VideoXtdex.TARGET_TYPE_NAME)
			.add(WebviewXtdex.TARGET_TYPE_NAME)
			.build();
	
	static final NonNestableElement fromXtext(String xtext) {
		xtext = xtext.trim();
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
	
	static boolean isNonNestableElement(String xtext) {
		boolean result = false;
		xtext = xtext.trim();
		for (String type : validTypeNames) {
			if (xtext.startsWith(type)) {
				result = true;
				break;
			}
		}
		return result;
	}
	
	static String toXtext(NonNestableElement e) {
		String result = "";
		if (e instanceof Chart) {
			result = ChartXtdex.toXtext((Chart) e);
		}
		if (e instanceof Colorpicker) {
			result = ColorpickerXtdex.toXtext((Colorpicker) e);
		}
		if (e instanceof List) {
			result = ListXtdex.toXtext((List) e);
		}
		if (e instanceof Selection) {
			result = SelectionXtdex.toXtext((Selection) e);
		}
		if (e instanceof Setpoint) {
			result = SetpointXtdex.toXtext((Setpoint) e);
		}
		if (e instanceof Slider) {
			result = SliderXtdex.toXtext((Slider) e);
		}
		if (e instanceof Switch) {
			result = SwitchXtdex.toXtext((Switch) e);
		}
		if (e instanceof Video) {
			result = VideoXtdex.toXtext((Video) e);
		}
		if (e instanceof Webview) {
			result = WebviewXtdex.toXtext((Webview) e);
		}
		return result;
	}

}
