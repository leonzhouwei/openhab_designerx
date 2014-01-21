package org.openhab.designerx.model.sitemap;

import java.util.List;

import org.openhab.designerx.model.ModelException;

public interface Sitemap {
	
	public void setName(String name) throws ModelException;
	
	public String getName();
	
	public void setLabel(String label);
	
	public String getLabel();
	
	public void setIcon(String icon);
	
	public String getIcon();
	
	public void appendChild(Element e);
	
	public List<Element> getChildren();
	
}
