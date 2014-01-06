package org.openhab.designerx.model.sitemap;

public interface Slider extends NonNestableElement {
	 
	public int getFrequency();

	public void setFrequency(int frequency);

	public boolean isSwitchEnabled();

	public void setSwitchEnabled(boolean switchEnabled);
	
	public boolean equalsLogically(Slider another);

}
