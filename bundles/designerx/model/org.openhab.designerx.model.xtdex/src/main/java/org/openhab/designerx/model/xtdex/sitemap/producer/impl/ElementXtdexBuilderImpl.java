package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import org.openhab.designerx.model.sitemap.Chart;
import org.openhab.designerx.model.sitemap.Colorpicker;
import org.openhab.designerx.model.sitemap.Element;
import org.openhab.designerx.model.sitemap.Frame;
import org.openhab.designerx.model.sitemap.Group;
import org.openhab.designerx.model.sitemap.Image;
import org.openhab.designerx.model.sitemap.List;
import org.openhab.designerx.model.sitemap.Selection;
import org.openhab.designerx.model.sitemap.Setpoint;
import org.openhab.designerx.model.sitemap.Slider;
import org.openhab.designerx.model.sitemap.Switch;
import org.openhab.designerx.model.sitemap.Text;
import org.openhab.designerx.model.sitemap.Video;
import org.openhab.designerx.model.sitemap.Webview;
import org.openhab.designerx.model.xtdex.ModelXtdexException;
import org.openhab.designerx.model.xtdex.sitemap.ElementXtdex;
import org.openhab.designerx.model.xtdex.sitemap.producer.ElementXtdexBuilder;

public final class ElementXtdexBuilderImpl implements ElementXtdexBuilder {

	public ElementXtdex build() {
		return new ElementXtdexImpl();
	}
	
	private class ElementXtdexImpl implements ElementXtdex {
		@Override
		public Chart parseChart(String xtext) throws ModelXtdexException {
			ChildlessElementXtextKeeper keeper = new ChildlessElementXtextKeeper(xtext);
			Element e = ChildlessElementXtdex.parse(keeper);
			Chart result = (Chart) e;
			return result;
		}

		@Override
		public Colorpicker parseColorpicker(String xtext)
				throws ModelXtdexException {
			ChildlessElementXtextKeeper keeper = new ChildlessElementXtextKeeper(xtext);
			Element e = ChildlessElementXtdex.parse(keeper);
			Colorpicker result = (Colorpicker) e;
			return result;
		}

		@Override
		public Frame parseFrame(String xtext) throws ModelXtdexException {
			ChildfulElementXtextKeeper keeper = new ChildfulElementXtextKeeper(xtext);
			Element e = ChildfulElementXtdex.parse(keeper);
			Frame result = (Frame) e;
			return result;
		}

		@Override
		public Group parseGroup(String xtext) throws ModelXtdexException {
			ChildfulElementXtextKeeper keeper = new ChildfulElementXtextKeeper(xtext);
			Element e = ChildfulElementXtdex.parse(keeper);
			Group result = (Group) e;
			return result;
		}

		@Override
		public Image parseImage(String xtext) throws ModelXtdexException {
			ChildfulElementXtextKeeper keeper = new ChildfulElementXtextKeeper(xtext);
			Element e = ChildfulElementXtdex.parse(keeper);
			Image result = (Image) e;
			return result;
		}

		@Override
		public List parseList(String xtext) throws ModelXtdexException {
			ChildlessElementXtextKeeper keeper = new ChildlessElementXtextKeeper(xtext);
			Element e = ChildlessElementXtdex.parse(keeper);
			List result = (List) e;
			return result;
		}

		@Override
		public Selection parseSelection(String xtext)
				throws ModelXtdexException {
			ChildlessElementXtextKeeper keeper = new ChildlessElementXtextKeeper(xtext);
			Element e = ChildlessElementXtdex.parse(keeper);
			Selection result = (Selection) e;
			return result;
		}

		@Override
		public Setpoint parseSetpoint(String xtext) throws ModelXtdexException {
			ChildlessElementXtextKeeper keeper = new ChildlessElementXtextKeeper(xtext);
			Element e = ChildlessElementXtdex.parse(keeper);
			Setpoint result = (Setpoint) e;
			return result;
		}

		@Override
		public Slider parseSlider(String xtext) throws ModelXtdexException {
			ChildlessElementXtextKeeper keeper = new ChildlessElementXtextKeeper(xtext);
			Element e = ChildlessElementXtdex.parse(keeper);
			Slider result = (Slider) e;
			return result;
		}

		@Override
		public Switch parseSwitch(String xtext) throws ModelXtdexException {
			ChildlessElementXtextKeeper keeper = new ChildlessElementXtextKeeper(xtext);
			Element e = ChildlessElementXtdex.parse(keeper);
			Switch result = (Switch) e;
			return result;
		}

		@Override
		public Text parseText(String xtext) throws ModelXtdexException {
			ChildfulElementXtextKeeper keeper = new ChildfulElementXtextKeeper(xtext);
			Element e = ChildfulElementXtdex.parse(keeper);
			Text result = (Text) e;
			return result;
		}

		@Override
		public Video parseVideo(String xtext) throws ModelXtdexException {
			ChildlessElementXtextKeeper keeper = new ChildlessElementXtextKeeper(xtext);
			Element e = ChildlessElementXtdex.parse(keeper);
			Video result = (Video) e;
			return result;
		}

		@Override
		public Webview parseWebview(String xtext) throws ModelXtdexException {
			ChildlessElementXtextKeeper keeper = new ChildlessElementXtextKeeper(xtext);
			Element e = ChildlessElementXtdex.parse(keeper);
			Webview result = (Webview) e;
			return result;
		}

		@Override
		public Element parse(String xtext) throws ModelXtdexException {
			ChildlessElementXtextKeeper childlessKeeper = new ChildlessElementXtextKeeper(xtext);
			if (ChildlessElementXtdex.isChildlessElement(childlessKeeper)) {
				return ChildlessElementXtdex.parse(childlessKeeper);
			} 
			
			ChildfulElementXtextKeeper childfulKeeper = new ChildfulElementXtextKeeper(xtext);
			if (ChildfulElementXtdex.isChildfulElement(childfulKeeper)) {
				return ChildfulElementXtdex.parse(childfulKeeper);
			} 
			
			return null;
		}
		
		@Override
		public <T extends Element> String toXtext(T e) {
			return toXtext(e, "");
		}

		@Override
		public <T extends Element> String toXtext(T e, String indentation) {
			if (ChildlessElementXtdex.isChildlessElement(e)) {
				return ChildlessElementXtdex.toXtext(e);
			} 
			
			if (ChildfulElementXtdex.isChildfulElement(e)) {
				return ChildfulElementXtdex.toXtext(e, indentation);
			} 
			
			return null;
		}
	}

}
