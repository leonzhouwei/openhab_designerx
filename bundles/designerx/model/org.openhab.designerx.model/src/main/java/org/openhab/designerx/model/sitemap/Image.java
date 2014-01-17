package org.openhab.designerx.model.sitemap;

import java.util.List;

public interface Image extends Element {
	
	public final String TYPE_NAME = "Image";

	public String getUrl();

	public void setUrl(String url);

	public int getRefresh();

	public void setRefresh(int refresh);

	public List<ColorArray> getIconColor();
	
	public void addIconColor(List<ColorArray> iconColor);
	
}