package org.openhab.designerx.model.sitemap;

public interface Colorpicker extends NonNestableElement {
	 
	public int getFrequency();

	public void setFrequency(int frequency);
	
	public boolean equalsLogically(Colorpicker another);
	
}
