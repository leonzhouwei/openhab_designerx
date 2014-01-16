package org.openhab.designerx.model.sitemap2.producer;

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

public interface ElementFactory {
	
	public Chart createChart();
	
	public Colorpicker createColorpicker();
	
	public Element createElement();
	
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
	
	public Webview createWebviewWebview();

}
