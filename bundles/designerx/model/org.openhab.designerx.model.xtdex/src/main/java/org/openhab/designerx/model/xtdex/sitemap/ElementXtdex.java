package org.openhab.designerx.model.xtdex.sitemap;

import org.openhab.designerx.model.sitemap2.Chart;
import org.openhab.designerx.model.sitemap2.Colorpicker;
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

public interface ElementXtdex {
	
	public Chart parseChart(String xtext);
	
	public Colorpicker parseColorpicker(String xtext);
	
	public Frame parseFrame(String xtext);
	
	public Group parseGroup(String xtext);
	
	public Image parseImage(String xtext);
	
	public List parseList(String xtext);
	
	public Selection parseSelection(String xtext);
	
	public Setpoint parseSetpoint(String xtext);
	
	public Slider parseSlider(String xtext);
	
	public Switch parseSwitch(String xtext);
	
	public Text parseText(String xtext);
	
	public Video parseVideo(String xtext);
	
	public Webview parseWebview(String xtext);

}
