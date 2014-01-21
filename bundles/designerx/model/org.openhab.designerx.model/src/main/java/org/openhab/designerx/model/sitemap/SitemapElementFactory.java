package org.openhab.designerx.model.sitemap;

public interface SitemapElementFactory {
	
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
	
	public ColorArray createColorArray();
	
	public Mapping createMapping();
	
	public Property createProperty();
	
	public VisibilityRule createVisibilityRule();
	
}
