package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

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

final class NonNestableElementXtdex {
	
	static NonNestableElement fromXtext(NonNestableElementXtextKeeper keeper) {
		return fromXtext(keeper.getXtext());
	}
	
	static final NonNestableElement fromXtext(String xtext) {
		if (ChartXtdex.isChart(xtext)) {
			return ChartXtdex.fromXtext(xtext);
		}
		if (ColorpickerXtdex.isColorpicker(xtext)) {
			return ColorpickerXtdex.fromXtext(xtext);
		}
		if (ListXtdex.isList(xtext)) {
			return ListXtdex.fromXtext(xtext);
		}
		if (SelectionXtdex.isSelection(xtext)) {
			return SelectionXtdex.fromXtext(xtext);
		}
		if (SetpointXtdex.isSetpoint(xtext)) {
			return SetpointXtdex.fromXtext(xtext);
		}
		if (SliderXtdex.isSlider(xtext)) {
			return SliderXtdex.fromXtext(xtext);
		}
		if (SwitchXtdex.isSwitch(xtext)) {
			return SwitchXtdex.fromXtext(xtext);
		}
		if (VideoXtdex.isVideo(xtext)) {
			return VideoXtdex.fromXtext(xtext);
		}
		if (WebviewXtdex.isWebview(xtext)) {
			return WebviewXtdex.fromXtext(xtext);
		}
		return null;
	}
	
	static boolean isNonNestableElement(String xtext) {
		if (ChartXtdex.isChart(xtext)) {
			return true;
		}
		if (ColorpickerXtdex.isColorpicker(xtext)) {
			return true;
		}
		if (ListXtdex.isList(xtext)) {
			return true;
		}
		if (SelectionXtdex.isSelection(xtext)) {
			return true;
		}
		if (SetpointXtdex.isSetpoint(xtext)) {
			return true;
		}
		if (SliderXtdex.isSlider(xtext)) {
			return true;
		}
		if (SwitchXtdex.isSwitch(xtext)) {
			return true;
		}
		if (VideoXtdex.isVideo(xtext)) {
			return true;
		}
		if (WebviewXtdex.isWebview(xtext)) {
			return true;
		}
		return false;
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
