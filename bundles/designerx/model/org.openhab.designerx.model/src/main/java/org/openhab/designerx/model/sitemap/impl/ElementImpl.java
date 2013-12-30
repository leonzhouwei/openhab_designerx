package org.openhab.designerx.model.sitemap.impl;

import java.util.List;

import org.openhab.designerx.model.sitemap.ColorArray;
import org.openhab.designerx.model.sitemap.Element;
import org.openhab.designerx.model.sitemap.VisibilityRule;

import com.google.common.collect.Lists;

final class ElementImpl implements Element {

	private String item;
	private String label;
	private String icon;
	private List<ColorArray> labelColor = Lists.newArrayList();
	private List<ColorArray> valueColor = Lists.newArrayList();
	private List<VisibilityRule> visibility = Lists.newArrayList();

	@Override
	public void setItem(String item) {
		this.item = item;
	}

	@Override
	public String getItem() {
		return item;
	}

	@Override
	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Override
	public String getIcon() {
		return icon;
	}

	@Override
	public void addLabelColor(List<ColorArray> labelColor) {
		this.labelColor.addAll(labelColor);
	}

	@Override
	public void addLabelColor(ColorArray labelColor) {
		this.labelColor.add(labelColor);
	}

	@Override
	public List<ColorArray> getLabelColor() {
		return labelColor;
	}

	@Override
	public void addValueColor(List<ColorArray> valueColor) {
		this.valueColor.addAll(valueColor);
	}

	@Override
	public void addValueColor(ColorArray valueColor) {
		this.valueColor.add(valueColor);
	}

	@Override
	public List<ColorArray> getValueColor() {
		return valueColor;
	}

	@Override
	public void addVisibility(List<VisibilityRule> visibility) {
		this.visibility.addAll(visibility);
	}

	@Override
	public void addVisibility(VisibilityRule visibility) {
		this.visibility.add(visibility);
	}

	@Override
	public List<VisibilityRule> getVisibility() {
		return visibility;
	}

}
