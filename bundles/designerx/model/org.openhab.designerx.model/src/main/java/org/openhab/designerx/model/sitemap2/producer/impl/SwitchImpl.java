package org.openhab.designerx.model.sitemap2.producer.impl;

import java.util.List;

import org.openhab.designerx.model.sitemap.ColorArray;
import org.openhab.designerx.model.sitemap.Element;
import org.openhab.designerx.model.sitemap.Mapping;
import org.openhab.designerx.model.sitemap.NonNestableElement;
import org.openhab.designerx.model.sitemap.Switch;
import org.openhab.designerx.model.sitemap.VisibilityRule;

import com.google.common.collect.Lists;

final class SwitchImpl implements Switch {

	private NonNestableElement element = new NonNestableElementImpl();
	private List<Mapping> mappings = Lists.newArrayList();
	
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
	public List<Mapping> getMappings() {
		return mappings;
	}

	@Override
	public void addMappings(List<Mapping> mappings) {
		this.mappings.addAll(mappings);
	}

	@Override
	public void addMapping(Mapping mapping) {
		this.mappings.add(mapping);
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
	public boolean equalsLogically(Switch another) {
		if (!(another instanceof Switch)) {
			return false;
		}
		if (this == another) {
			return true;
		}
		final List<Mapping> anotherMappings = another.getMappings();
		if (mappings.size() != anotherMappings.size()) {
			return false;
		}
		for (Mapping outer : mappings) {
			boolean findEqual = false;
			for (Mapping inner : anotherMappings) {
				if (outer.equalsLogically(inner)) {
					findEqual = true;
					break;
				}
			}
			if (findEqual == false) {
				return false;
			}
		}
		if (!element.equalsLogically(another)) {
			return false;
		}
		return true;
	}
	
}
