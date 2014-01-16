package org.openhab.designerx.model.sitemap2;

import java.util.List;

public interface Sitemap {
	
	public void setName(String name);
	
	public String getName();
	
	public void setLabel(String label);
	
	public String getLabel();
	
	public void setIcon(String icon);
	
	public String getIcon();
	
	public void appendChild(Element e);
	
	public List<Element> getChildren();
	
	public String toXtext();
	
	public boolean equalsLogically(Sitemap another);

}
