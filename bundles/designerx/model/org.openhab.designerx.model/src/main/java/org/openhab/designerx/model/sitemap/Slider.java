package org.openhab.designerx.model.sitemap;

public interface Slider extends Element {
	
	public final String TYPE_NAME = "Slider";
	 
	public int getFrequency();

	public void setFrequency(int frequency);

	public boolean isSwitchEnabled();

	public void setSwitchEnabled(boolean switchEnabled);
	
}
