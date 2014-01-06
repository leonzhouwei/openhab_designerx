package org.openhab.designerx.model.sitemap;

public interface List extends NonNestableElement {

	public String getSeparator();

	public void setSeparator(String separator);
	
	public boolean equalsLogically(List another);

}