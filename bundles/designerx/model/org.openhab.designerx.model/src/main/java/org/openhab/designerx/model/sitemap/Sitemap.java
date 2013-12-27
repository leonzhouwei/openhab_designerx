package org.openhab.designerx.model.sitemap;

import java.util.List;

public interface Sitemap {
	
	public void setName(String name);
	
	public String getName();
	
	public void setLabel(String label);
	
	public String getLabel();
	
	public void setIcon(String icon);
	
	public String getIcon();
	
	public List<Element> getChildren();

}
