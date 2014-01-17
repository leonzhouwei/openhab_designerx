package org.openhab.designerx.model.sitemap;

public interface Webview extends Element {
	
	public final String TYPE_NAME = "Webview";
	 
	public int getHeight();

	public void setHeight(int height);
 
	public String getUrl();

	public void setUrl(String url);
	
}
