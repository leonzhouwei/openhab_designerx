package org.openhab.designerx.model.sitemap;

import java.util.List;

public interface Image extends NestableElement {

	public String getUrl();

	public void setUrl(String value);

	public int getRefresh();

	public void setRefresh(int value);

	public List<ColorArray> getIconColor();

}