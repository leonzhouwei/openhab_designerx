package org.openhab.designerx.model.sitemap;

public interface Chart extends NonNestableElement {
	 
	String getService();

	void setService(String value);

	int getRefresh();

	void setRefresh(int value);

	String getPeriod();

	void setPeriod(String value);

}
