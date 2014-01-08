package org.openhab.designerx.model.sitemap;

public interface Chart extends NonNestableElement {
	
	public String getService();

	public void setService(String service);

	public int getRefresh();

	public void setRefresh(int refresh);

	public String getPeriod();

	public void setPeriod(String period);
	
	public boolean equalsLogically(Chart another);

}
