package org.openhab.designerx.model.sitemap;

public interface Video extends NonNestableElement {
	
	public String getUrl();
 
	public void setUrl(String url);
	
	public boolean equalsLogically(Video another);

}
