package org.openhab.designerx.model.sitemap;

public interface Webview extends NonNestableElement {
	 
	public int getHeight();

	public void setHeight(int height);
 
	public String getUrl();

	public void setUrl(String url);
	
	public boolean equalsLogically(Webview another);

}
