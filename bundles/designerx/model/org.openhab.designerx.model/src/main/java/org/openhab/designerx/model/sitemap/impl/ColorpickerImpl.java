package org.openhab.designerx.model.sitemap.impl;

import java.util.List;

import org.openhab.designerx.model.sitemap.ColorArray;
import org.openhab.designerx.model.sitemap.Colorpicker;
import org.openhab.designerx.model.sitemap.Element;
import org.openhab.designerx.model.sitemap.NonNestableElement;
import org.openhab.designerx.model.sitemap.VisibilityRule;

final class ColorpickerImpl implements Colorpicker {

	private NonNestableElement element = new NonNestableElementImpl();
	private int frequency = 0;

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
	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		int freq = Integer.parseInt(frequency);
		setFrequency(freq);
	}

	@Override
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	@Override
	public boolean equalsLogically(NonNestableElement another) {
		return element.equalsLogically(another);
	}

	@Override
	public boolean equalsLogically(Element another) {
		return element.equalsLogically(another);
	}

	@Override
	public boolean equalsLogically(Colorpicker another) {
		if (!(another instanceof Colorpicker)) {
			return false;
		}
		if (this == another) {
			return true;
		}
		if (!element.equalsLogically(another)) {
			return false;
		}
		if (frequency != another.getFrequency()) {
			return false;
		}
		return true;
	}

}
