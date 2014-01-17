package org.openhab.designerx.model.sitemap;

public interface VisibilityRule {

	public String getItem();

	public void setItem(String item);

	public String getCondition();

	public void setCondition(String condition);

	public String getSign();

	public void setSign(String sign);

	public String getState();

	public void setState(String state);
	
}
