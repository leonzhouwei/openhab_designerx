package org.openhab.designerx.model.sitemap2.producer.impl;

import java.util.List;

import org.openhab.designerx.model.sitemap.ColorArray;
import org.openhab.designerx.model.sitemap.Element;
import org.openhab.designerx.model.sitemap.Frame;
import org.openhab.designerx.model.sitemap.NestableElement;
import org.openhab.designerx.model.sitemap.VisibilityRule;

final class FrameImpl implements Frame {
	
	private NestableElement element = new NestableElementImpl(); 
	
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
	public void addLabelColor(List<ColorArray> labelColor) {
		element.addLabelColor(labelColor);
	}

	@Override
	public void addLabelColor(ColorArray labelColor) {
		element.addLabelColor(labelColor);
	}
	
	@Override
	public List<ColorArray> getLabelColor() {
		return element.getLabelColor();
	}

	@Override
	public void addValueColor(List<ColorArray> valueColor) {
		element.addValueColor(valueColor);
	}

	@Override
	public void addValueColor(ColorArray valueColor) {
		element.addValueColor(valueColor);
	}
	
	@Override
	public List<ColorArray> getValueColor() {
		return element.getValueColor();
	}

	@Override
	public void addVisibility(List<VisibilityRule> visibility) {
		element.addVisibility(visibility);
	}

	@Override
	public void addVisibility(VisibilityRule visibility) {
		element.addVisibility(visibility);
	}
	
	@Override
	public List<VisibilityRule> getVisibility() {
		return element.getVisibility();
	}
	
	@Override
	public void appendChild(Element child) {
		element.appendChild(child);
	}

	@Override
	public List<Element> getChildren() {
		return element.getChildren();
	}

	@Override
	public boolean equalsLogically(NestableElement another) {
		return element.equalsLogically(another);
	}

	@Override
	public boolean equalsLogically(Element another) {
		return element.equalsLogically(another);
	}

	@Override
	public boolean equalsLogically(Frame another) {
		if (!(another instanceof Frame)) {
			return false;
		}
		if (this == another) {
			return true;
		}
		if (!element.equalsLogically(another)) {
			return false;
		}
		return true;
	}
	
}
