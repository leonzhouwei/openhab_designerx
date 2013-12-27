package org.openhab.designerx.model.sitemap;

public interface Element {
	
	public ElementType getType();

	public boolean isNestable();
	
	public void setItem();
	
	public String getItem();
	
	public void setLabel();
	
	public String getLabel();
	
	public void setIcon(String icon);
	
	public String getIcon();
	
}
