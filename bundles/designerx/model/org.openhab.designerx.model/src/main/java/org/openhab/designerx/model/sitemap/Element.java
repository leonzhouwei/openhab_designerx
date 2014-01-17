package org.openhab.designerx.model.sitemap;

import java.util.Collection;
import java.util.List;

public interface Element {
	
	public String getTypeName();
	
	public void setItem(String item);
	
	public String getItem();
	
	public void setLabel(String label);
	
	public String getLabel();
	
	public void setIcon(String icon);
	
	public String getIcon();
	
	public void addLabelColor(List<ColorArray> labelColor);
	
	public void addLabelColor(ColorArray labelColor);
	
	public List<ColorArray> getLabelColor();
	
	public void addValueColor(List<ColorArray> valueColor);
	
	public void addValueColor(ColorArray valueColor);
	
	public List<ColorArray> getValueColor();
	
	public void addVisibility(List<VisibilityRule> visibility);
	
	public void addVisibility(VisibilityRule visibility);
	
	public List<VisibilityRule> getVisibility();
	
	public boolean canHaveChildren();
	
	public List<Element> getChildren();
	
	public void addChild(Element child);
	
	public void addChildren(Collection<? extends Element> children);
	
}
