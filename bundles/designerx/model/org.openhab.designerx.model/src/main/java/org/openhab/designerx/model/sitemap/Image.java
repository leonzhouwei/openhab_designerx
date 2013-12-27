package org.openhab.designerx.model.sitemap;

import java.util.List;

public interface Image extends NestableElement {

	String getUrl();

	void setUrl(String value);

	int getRefresh();

	void setRefresh(int value);

	List<ColorArray> getIconColor();

}