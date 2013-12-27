package org.openhab.designerx.model.sitemap;

public interface Slider extends NonNestableElement {
	 
	public int getFrequency();

	public void setFrequency(int value);

	public boolean isSwitchEnabled();

	public void setSwitchEnabled(boolean value);

}
