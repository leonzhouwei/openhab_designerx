package org.openhab.designerx.model.sitemap2.producer.impl;

import java.util.List;

import org.openhab.designerx.model.sitemap.ColorArray;
import org.openhab.designerx.model.sitemap.Element;
import org.openhab.designerx.model.sitemap.NonNestableElement;
import org.openhab.designerx.model.sitemap.Slider;
import org.openhab.designerx.model.sitemap.VisibilityRule;

final class SliderImpl implements Slider {
	
	private NonNestableElementImpl element = new NonNestableElementImpl();
	private int frequency = 0;
	private boolean switchEnabled = false;
	
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

	@Override
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	@Override
	public boolean isSwitchEnabled() {
		return switchEnabled;
	}

	@Override
	public void setSwitchEnabled(boolean switchEnabled) {
		this.switchEnabled = switchEnabled;
	}
	
	public void setFrequency(String frequency) {
		int i = Integer.parseInt(frequency);
		setFrequency(i);
	}

	public void setSwitchEnabled(String switchEnabled) {
		boolean b = Boolean.parseBoolean(switchEnabled);
		setSwitchEnabled(b);
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
	public boolean equalsLogically(Slider another) {
		if (!(another instanceof Slider)) {
			return false;
		}
		if (this == another) {
			return true;
		}
		// frequency
		final int anotherFreq = another.getFrequency();
		if (frequency != anotherFreq) {
			return false;
		}
		// switchEnabled
		if (switchEnabled != another.isSwitchEnabled()) {
			return false;
		}
		if (!element.equalsLogically(another)) {
			return false;
		}
		return true;
	}
	
}
