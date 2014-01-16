package org.openhab.designerx.model.xtdex.sitemap;

import org.openhab.designerx.model.sitemap2.Chart;
import org.openhab.designerx.model.sitemap2.Colorpicker;
import org.openhab.designerx.model.sitemap2.Element;
import org.openhab.designerx.model.sitemap2.Frame;
import org.openhab.designerx.model.sitemap2.Group;
import org.openhab.designerx.model.sitemap2.Image;
import org.openhab.designerx.model.sitemap2.List;
import org.openhab.designerx.model.sitemap2.Selection;
import org.openhab.designerx.model.sitemap2.Setpoint;
import org.openhab.designerx.model.sitemap2.Slider;
import org.openhab.designerx.model.sitemap2.Switch;
import org.openhab.designerx.model.sitemap2.Text;
import org.openhab.designerx.model.sitemap2.Video;
import org.openhab.designerx.model.sitemap2.Webview;
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

}
