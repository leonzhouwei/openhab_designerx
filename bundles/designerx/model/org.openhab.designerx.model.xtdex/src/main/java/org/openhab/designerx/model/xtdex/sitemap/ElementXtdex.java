package org.openhab.designerx.model.xtdex.sitemap;

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

public interface ElementXtdex {
	
	public Chart parseChart(String xtext) throws ModelXtdexException;
	
	public Colorpicker parseColorpicker(String xtext) throws ModelXtdexException;
	
	public Frame parseFrame(String xtext) throws ModelXtdexException;
	
	public Group parseGroup(String xtext) throws ModelXtdexException;
	
	public Image parseImage(String xtext) throws ModelXtdexException;
	
	public List parseList(String xtext) throws ModelXtdexException;
	
	public Selection parseSelection(String xtext) throws ModelXtdexException;
	
	public Setpoint parseSetpoint(String xtext) throws ModelXtdexException;
	
	public Slider parseSlider(String xtext) throws ModelXtdexException;
	
	public Switch parseSwitch(String xtext) throws ModelXtdexException;
	
	public Text parseText(String xtext) throws ModelXtdexException;
	
	public Video parseVideo(String xtext) throws ModelXtdexException;
	
	public Webview parseWebview(String xtext) throws ModelXtdexException;
	
	public Element parse(String xtext) throws ModelXtdexException;
	
	public <T extends Element> String toXtext(T e);
	
	public <T extends Element> String toXtext(T e, String indentation);
	
	public boolean isChildlessElement(String xtext) throws ModelXtdexException;
	
	public boolean isChildfulElement(String xtext) throws ModelXtdexException;
	
	public Element parseChildfulElement(java.util.List<String> xtext) throws ModelXtdexException;
	
	public Element parseChildlessElement(String xtext) throws ModelXtdexException;
	
}
