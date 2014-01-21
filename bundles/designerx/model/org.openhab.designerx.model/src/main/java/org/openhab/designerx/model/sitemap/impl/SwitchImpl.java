package org.openhab.designerx.model.sitemap.impl;

import java.util.Collection;
import java.util.List;

import org.openhab.designerx.model.sitemap.ColorArray;
import org.openhab.designerx.model.sitemap.Element;
import org.openhab.designerx.model.sitemap.Mapping;
import org.openhab.designerx.model.sitemap.Switch;
import org.openhab.designerx.model.sitemap.VisibilityRule;

import com.google.common.collect.Lists;

final class SwitchImpl implements Switch {
	private Element element = new ElementImpl(Switch.TYPE_NAME);
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

}
