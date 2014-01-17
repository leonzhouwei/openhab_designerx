package org.openhab.designerx.model.sitemap.producer;

import org.openhab.designerx.model.sitemap.Chart;
import org.openhab.designerx.model.sitemap.Colorpicker;
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

public interface ElementFactory {
	
	public Chart createChart();
	
	public Colorpicker createColorpicker();
	
	public Frame createFrame();
	
	public Group createGroup();
	
	public Image createImage();
	
	public List createList();
	
	public Selection createSelection();
	
	public Setpoint createSetpoint();
	
	public Slider createSlider();
	
	public Switch createSwitch();
	
	public Text createText();
	
	public Video createVideo();
	
	public Webview createWebview();

}
