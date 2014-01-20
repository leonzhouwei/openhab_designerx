package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import org.openhab.designerx.model.sitemap.Chart;
import org.openhab.designerx.model.sitemap.Colorpicker;
import org.openhab.designerx.model.sitemap.Element;
import org.openhab.designerx.model.sitemap.List;
import org.openhab.designerx.model.sitemap.Selection;
import org.openhab.designerx.model.sitemap.Setpoint;
import org.openhab.designerx.model.sitemap.Slider;
import org.openhab.designerx.model.sitemap.Switch;
import org.openhab.designerx.model.sitemap.Video;
import org.openhab.designerx.model.sitemap.Webview;
import org.openhab.designerx.model.xtdex.ModelXtdexException;

final class ChildlessElementXtdex {
	
	static boolean isChildlessElement(ChildlessElementXtextKeeper keeper) {
		boolean result = false;
		if (ChartXtdex.isChart(keeper)) {
			result = true;
		} else if (ColorpickerXtdex.isColorpicker(keeper)) {
			result = true;
		} else if (ListXtdex.isList(keeper)) {
			result = true;
		} else if (SelectionXtdex.isSelection(keeper)) {
			result = true;
		} else if (SetpointXtdex.isSetpoint(keeper)) {
			result = true;
		} else if (SliderXtdex.isSlider(keeper)) {
			result = true;
		} else if (SwitchXtdex.isSwitch(keeper)) {
			result = true;
		} else if (VideoXtdex.isVideo(keeper)) {
			result = true;
		} else if (WebviewXtdex.isWebview(keeper)) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}
	
	static Element parse(ChildlessElementXtextKeeper keeper) throws ModelXtdexException {
		Element result = null;
		if (ChartXtdex.isChart(keeper)) {
			result = ChartXtdex.parseIgnoringChildren(keeper);
		} else if (ColorpickerXtdex.isColorpicker(keeper)) {
			result = ColorpickerXtdex.parseIgnoringChildren(keeper);
		} else if (ListXtdex.isList(keeper)) {
			result = ListXtdex.parseIgnoringChildren(keeper);
		} else if (SelectionXtdex.isSelection(keeper)) {
			result = SelectionXtdex.parseIgnoringChildren(keeper);
		} else if (SetpointXtdex.isSetpoint(keeper)) {
			result = SetpointXtdex.parseIgnoringChildren(keeper);
		} else if (SliderXtdex.isSlider(keeper)) {
			result = SliderXtdex.parseIgnoringChildren(keeper);
		} else if (SwitchXtdex.isSwitch(keeper)) {
			result = SwitchXtdex.parseIgnoringChildren(keeper);
		} else if (VideoXtdex.isVideo(keeper)) {
			result = VideoXtdex.parseIgnoringChildren(keeper);
		} else if (WebviewXtdex.isWebview(keeper)) {
			result = WebviewXtdex.parseIgnoringChildren(keeper);
		} else {
			result = null;
		}
		return result;
	}
	
	static <T extends Element> boolean isChildlessElement(T e) {
		boolean result = false;
		if (ChartXtdex.isChart(e)) {
			result = true;
		} else if (ColorpickerXtdex.isColorpicker(e)) {
			result = true;
		} else if (ListXtdex.isList(e)) {
			result = true;
		} else if (SelectionXtdex.isSelection(e)) {
			result = true;
		} else if (SetpointXtdex.isSetpoint(e)) {
			result = true;
		} else if (SliderXtdex.isSlider(e)) {
			result = true;
		} else if (SwitchXtdex.isSwitch(e)) {
			result = true;
		} else if (VideoXtdex.isVideo(e)) {
			result = true;
		} else if (WebviewXtdex.isWebview(e)) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}
	
	static <T extends Element> String toXtext(T e) {
		String result = null;
		if (ChartXtdex.isChart(e)) {
			result = ChartXtdex.toXtextIgnoringChildren((Chart) e);
		} else if (ColorpickerXtdex.isColorpicker(e)) {
			result = ColorpickerXtdex.toXtextIgnoringChildren((Colorpicker) e);
		} else if (ListXtdex.isList(e)) {
			result = ListXtdex.toXtextIgnoringChildren((List) e);
		} else if (SelectionXtdex.isSelection(e)) {
			result = SelectionXtdex.toXtextIgnoringChildren((Selection) e);
		} else if (SetpointXtdex.isSetpoint(e)) {
			result = SetpointXtdex.toXtextIgnoringChildren((Setpoint) e);
		} else if (SliderXtdex.isSlider(e)) {
			result = SliderXtdex.toXtextIgnoringChildren((Slider) e);
		} else if (SwitchXtdex.isSwitch(e)) {
			result = SwitchXtdex.toXtextIgnoringChildren((Switch) e);
		} else if (VideoXtdex.isVideo(e)) {
			result = VideoXtdex.toXtextIgnoringChildren((Video) e);
		} else if (WebviewXtdex.isWebview(e)) {
			result = WebviewXtdex.toXtextIgnoringChildren((Webview) e);
		} else if (!e.canHaveChildren()) {
			result = ElementXtextualizer.toXtextIgnoringChildren(e);
		} else {
			result = null;
		}
		return result;
	}
	
	private ChildlessElementXtdex() {}

}
