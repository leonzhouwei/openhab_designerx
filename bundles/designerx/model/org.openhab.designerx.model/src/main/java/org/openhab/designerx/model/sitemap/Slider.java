package org.openhab.designerx.model.sitemap;

public interface Slider extends NonNestableElement {
	 
	int getFrequency();

	void setFrequency(int value);

	boolean isSwitchEnabled();

	void setSwitchEnabled(boolean value);

}
