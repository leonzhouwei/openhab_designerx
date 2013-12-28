package org.openhab.designerx.model.sitemap;

public interface Element {
	
	public boolean isNestable();
	
	public void setItem(String item);
	
	public String getItem();
	
	public void setLabel(String label);
	
	public String getLabel();
	
	public void setIcon(String icon);
	
	public String getIcon();
	
}
