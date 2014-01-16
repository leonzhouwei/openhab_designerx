package org.openhab.designerx.model.sitemap2.producer.impl;

import java.util.Collection;
import java.util.List;

import org.openhab.designerx.model.sitemap2.ColorArray;
import org.openhab.designerx.model.sitemap2.Element;
import org.openhab.designerx.model.sitemap2.Property;
import org.openhab.designerx.model.sitemap2.Slider;
import org.openhab.designerx.model.sitemap2.VisibilityRule;

final class SliderImpl implements Slider {
	private Element element = new ElementImpl(Slider.TYPE_NAME);
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
	public String getTypeName() {
		return element.getTypeName();
	}

	@Override
	public boolean canHaveChildren() {
		return element.canHaveChildren();
	}

	@Override
	public List<Element> getChildren() {
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

	@Override
	public List<Property> getExtraProperties() {
		return element.getExtraProperties();
	}

	@Override
	public void addExtraProperty(Property property) {
		element.addExtraProperty(property);
	}

	@Override
	public void addExtraProperties(Collection<? extends Property> properties) {
		element.addExtraProperties(properties);
	}
	
}
