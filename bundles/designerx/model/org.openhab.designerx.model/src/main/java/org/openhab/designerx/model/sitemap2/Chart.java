package org.openhab.designerx.model.sitemap2;

public interface Chart extends Element {
	
	public final String TYPE_NAME = "Chart";
	
	public String getService();

	public void setService(String service);

	public int getRefresh();

	public void setRefresh(int refresh);

	public String getPeriod();

	public void setPeriod(String period);
	
}
