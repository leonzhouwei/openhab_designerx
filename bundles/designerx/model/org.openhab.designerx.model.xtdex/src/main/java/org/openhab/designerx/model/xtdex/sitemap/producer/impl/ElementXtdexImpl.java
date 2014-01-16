package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import java.util.List;

import org.openhab.designerx.model.sitemap2.Chart;
import org.openhab.designerx.model.sitemap2.ColorArray;
import org.openhab.designerx.model.sitemap2.Colorpicker;
import org.openhab.designerx.model.sitemap2.Element;
import org.openhab.designerx.model.sitemap2.Frame;
import org.openhab.designerx.model.sitemap2.Group;
import org.openhab.designerx.model.sitemap2.Image;
import org.openhab.designerx.model.sitemap2.Selection;
import org.openhab.designerx.model.sitemap2.Setpoint;
import org.openhab.designerx.model.sitemap2.Slider;
import org.openhab.designerx.model.sitemap2.Switch;
import org.openhab.designerx.model.sitemap2.Text;
import org.openhab.designerx.model.sitemap2.Video;
import org.openhab.designerx.model.sitemap2.VisibilityRule;
import org.openhab.designerx.model.sitemap2.Webview;
import org.openhab.designerx.model.xtdex.ModelXtdexConstants;
import org.openhab.designerx.model.xtdex.ModelXtdexException;
import org.openhab.designerx.model.xtdex.sitemap.ElementXtdex;

import com.google.common.collect.ImmutableList;

final class ElementXtdexImpl implements ElementXtdex {
	
	static Element fillWithoutChildren(Element e, NonNestableElementXtextKeeper keeper) {
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
		return e;
	}
	
	static boolean isNonNestableElement(String xtext) {
		boolean result = false;
		if (ChartXtdex.isChart(xtext)) {
			result = true;
		} else if (ColorpickerXtdex.isColorpicker(xtext)) {
			result = true;
		} else if (ListXtdex.isList(xtext)) {
			result = true;
		} else if (SelectionXtdex.isSelection(xtext)) {
			result = true;
		} else if (SetpointXtdex.isSetpoint(xtext)) {
			result = true;
		} else if (SliderXtdex.isSlider(xtext)) {
			result = true;
		} else if (SwitchXtdex.isSwitch(xtext)) {
			result = true;
		} else if (VideoXtdex.isVideo(xtext)) {
			result = true;
		} else if (WebviewXtdex.isWebview(xtext)) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}
	
	static boolean isNestableElement(String xtext) {
		boolean result = false;
		if (FrameXtdex.isFrame(xtext)) {
			result = true;
		} else if (GroupXtdex.isGroup(xtext)) {
			result = true;
		} else if (ImageXtdex.isImage(xtext)) {
			result = true;
		} else if (TextXtdex.isText(xtext)) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}
	
	static int endIndexOf(List<String> list, final int start) {
		if (!list.get(start).trim().endsWith("{")) {
			return start;
		}
		int end = -1;
		int unpairedOpenBraceCount = 1;
		final int size = list.size();
		for (int i = start + 1; i < size && unpairedOpenBraceCount != 0; ++i) {
			String s = list.get(i).trim();
			if (s.compareTo("}") == 0) {
				end = i;
				unpairedOpenBraceCount -= 1;
			}
			if (s.endsWith("{")) {
				unpairedOpenBraceCount += 1;
			}
		}
		return end;
	}

	@Override
	public Chart parseChart(String xtext) throws ModelXtdexException {
		NonNestableElementXtextKeeper keeper = new NonNestableElementXtextKeeper(xtext);
		return ChartXtdex.fromXtext(keeper);
	}

	@Override
	public Colorpicker parseColorpicker(String xtext) throws ModelXtdexException {
		NonNestableElementXtextKeeper keeper = new NonNestableElementXtextKeeper(xtext);
		return ColorpickerXtdex.fromXtext(keeper);
	}

	@Override
	public Frame parseFrame(String xtext) throws ModelXtdexException {
		NestableElementXtextKeeper keeper = new NestableElementXtextKeeper(xtext);
		return FrameXtdex.fromXtext(keeper);
	}

	@Override
	public Group parseGroup(String xtext) throws ModelXtdexException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image parseImage(String xtext) throws ModelXtdexException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openhab.designerx.model.sitemap2.List parseList(String xtext) throws ModelXtdexException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Selection parseSelection(String xtext) throws ModelXtdexException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Setpoint parseSetpoint(String xtext) throws ModelXtdexException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Slider parseSlider(String xtext) throws ModelXtdexException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Switch parseSwitch(String xtext) throws ModelXtdexException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Text parseText(String xtext) throws ModelXtdexException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Video parseVideo(String xtext) throws ModelXtdexException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Webview parseWebview(String xtext) throws ModelXtdexException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Element parse(String xtext) throws ModelXtdexException {
		Element e = null;
		if (isNonNestableElement(xtext)) {
			e = parseChildlessElement(xtext);
		} else if (isNestableElement(xtext)) {
			NestableElementXtextKeeper keeper = new NestableElementXtextKeeper(xtext);
			ImmutableList<String> il = keeper.getXtext();
			e = parseChildlfulElement(il, 0, il.size() - 1);
		} else {
			e = null;
		}
		return e;
	}

	@Override
	public <T extends Element> String toXtext(T e) {
		StringBuilder sb = new StringBuilder();
		//
		sb.append(toXtextIgnoringChildren(e, ""));
		if (e.canHaveChildren() && !e.getChildren().isEmpty()) {
			sb.append(ModelXtdexConstants.SPACE_MARK);
			sb.append(ModelXtdexConstants.OPEN_BRACE_MARK);
			sb.append(ModelXtdexConstants.LINE_SEPARATOR);
			for (Element child : e.getChildren()) {
				String s = toXtextIgnoringChildren(child, "    ");
				sb.append(s);
				sb.append(ModelXtdexConstants.LINE_SEPARATOR);
			}
			sb.append(ModelXtdexConstants.CLOSE_BRACE_MARK);
			sb.append(ModelXtdexConstants.LINE_SEPARATOR);
		}
		return sb.toString().trim();
	}
	
	static String toXtextIgnoringChildren(Element e, String indentation) {
		StringBuilder sb = new StringBuilder();
		//
		sb.append(indentation);
		sb.append(e.getTypeName());
		sb.append(ModelXtdexConstants.SPACE_MARK);
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
	
	static Element parseChildlessElement(String xtext) throws ModelXtdexException {
		Element e = null;
		NonNestableElementXtextKeeper keeper = new NonNestableElementXtextKeeper(xtext);
		if (ChartXtdex.isChart(xtext)) {
			e = ChartXtdex.fromXtext(keeper);
		} else if (ColorpickerXtdex.isColorpicker(xtext)) {
			e = ColorpickerXtdex.fromXtext(keeper);
		} else if (ListXtdex.isList(xtext)) {
			e = ListXtdex.fromXtext(keeper);
		} else if (SelectionXtdex.isSelection(xtext)) {
			e = SelectionXtdex.fromXtext(keeper);
		} else if (SetpointXtdex.isSetpoint(xtext)) {
			e = SetpointXtdex.fromXtext(keeper);
		} else if (SliderXtdex.isSlider(xtext)) {
			e = SliderXtdex.fromXtext(keeper);
		} else if (SwitchXtdex.isSwitch(xtext)) {
			e = SwitchXtdex.fromXtext(keeper);
		} else if (VideoXtdex.isVideo(xtext)) {
			e = VideoXtdex.fromXtext(keeper);
		} else if (WebviewXtdex.isWebview(xtext)) {
			e = WebviewXtdex.fromXtext(keeper);
		} else {
			e = null;
		}
		return e;
	}
	
	static Element parseChildlfulElement(ImmutableList<String> il, final int start, final int end) throws ModelXtdexException {
		Element root = null;
		String xtext = il.get(start);
		NonNestableElementXtextKeeper keeper = new NonNestableElementXtextKeeper(xtext);
		if (FrameXtdex.isFrame(xtext)) {
			root = FrameXtdex.parseIgnoringChildren(keeper);
		} else if (GroupXtdex.isGroup(xtext)) {
			root = FrameXtdex.parseIgnoringChildren(keeper);
		} else if (ImageXtdex.isImage(xtext)) {
			root = FrameXtdex.parseIgnoringChildren(keeper);
		} else if (TextXtdex.isText(xtext)) {
			root = FrameXtdex.parseIgnoringChildren(keeper);
		} else {
			root = null;
		}
		if (root != null) {
			for (int i = start + 1; i > start && i < end; ++i) {
				String innerXtext = il.get(i);
				if (isNonNestableElement(innerXtext)) {
					Element child = parseChildlessElement(innerXtext);
					root.addChild(child);
					i += 1;
				} else {
					int innerEnd = endIndexOf(il, i);
					Element child = parseChildlfulElement(il, i + 1, innerEnd);
					root.addChild(child);
					i = innerEnd + 1;
				}
			}
		}
		return root;
	}
	
}
