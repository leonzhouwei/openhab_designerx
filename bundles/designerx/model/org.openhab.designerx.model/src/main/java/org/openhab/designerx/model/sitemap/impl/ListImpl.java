package org.openhab.designerx.model.sitemap.impl;

import java.util.Collection;

import org.openhab.designerx.model.sitemap.ColorArray;
import org.openhab.designerx.model.sitemap.Element;
import org.openhab.designerx.model.sitemap.List;
import org.openhab.designerx.model.sitemap.VisibilityRule;

final class ListImpl implements List {
	private Element element = new ElementImpl(List.TYPE_NAME);
	private String separator;
	
	@Override
	public void setItem(String item) {
		element.setItem(item);
	}

	@Override
	public String getItem() {
		return element.getItem();
	}

	@Override
	public void setLabel(String label) {
		element.setLabel(label);
	}

	@Override
	public String getLabel() {
		return element.getLabel();
	}

	@Override
	public void setIcon(String icon) {
		element.setIcon(icon);
	}

	@Override
	public String getIcon() {
		return element.getIcon();
	}

	@Override
	public void addLabelColor(java.util.List<ColorArray> labelColor) {
		element.addLabelColor(labelColor);
	}

	@Override
	public void addLabelColor(ColorArray labelColor) {
		element.addLabelColor(labelColor);
	}
	
	@Override
	public java.util.List<ColorArray> getLabelColor() {
		return element.getLabelColor();
	}

	@Override
	public void addValueColor(java.util.List<ColorArray> valueColor) {
		element.addValueColor(valueColor);
	}

	@Override
	public void addValueColor(ColorArray valueColor) {
		element.addValueColor(valueColor);
	}
	
	@Override
	public java.util.List<ColorArray> getValueColor() {
		return element.getValueColor();
	}

	@Override
	public void addVisibility(java.util.List<VisibilityRule> visibility) {
		element.addVisibility(visibility);
	}

	@Override
	public void addVisibility(VisibilityRule visibility) {
		element.addVisibility(visibility);
	}

	@Override
	public java.util.List<VisibilityRule> getVisibility() {
		return element.getVisibility();
	}
	
	@Override
	public String getSeparator() {
		return separator;
	}

	@Override
	public void setSeparator(String separator) {
		this.separator = separator;
	}

	@Override
	public String getTypeName() {
		return element.getTypeName();
	}

	@Override
	public boolean canHaveChildren() {
		return element.canHaveChildren();
	}

	@Override
	public java.util.List<Element> getChildren() {
		return element.getChildren();
	}

	@Override
	public void addChild(Element child) {
		element.addChild(child);
	}

	@Override
	public void addChildren(Collection<? extends Element> children) {
		element.addChildren(children);
	}

}
