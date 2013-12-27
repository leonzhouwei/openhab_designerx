package org.openhab.designerx.model.sitemap;

public interface Chart extends NonNestableElement {
	 
	public String getService();

	public void setService(String value);

	public int getRefresh();

	public void setRefresh(int value);

	public String getPeriod();

	public void setPeriod(String value);

}
