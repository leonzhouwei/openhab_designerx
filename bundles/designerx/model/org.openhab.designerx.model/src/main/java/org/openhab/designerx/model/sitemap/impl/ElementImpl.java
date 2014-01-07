package org.openhab.designerx.model.sitemap.impl;

import java.util.List;

import org.openhab.designerx.model.sitemap.ColorArray;
import org.openhab.designerx.model.sitemap.Element;
import org.openhab.designerx.model.sitemap.VisibilityRule;

import com.google.common.collect.Lists;

final class ElementImpl implements Element {

	private String item;
	private String icon;
	private String label;
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

	@Override
	public boolean equalsLogically(Element another) {
		if (!(another instanceof Element)) {
			return false;
		}
		if (this == another) {
			return true;
		}
		final String anotherItem = another.getItem();
		if (item == null && anotherItem != null ||
			item != null && anotherItem == null ||
			item != null && anotherItem != null && item.compareTo(anotherItem) != 0) {
			return false;
		}
		final String anotherIcon = another.getIcon();
		if (icon == null && anotherIcon != null ||
			icon != null && anotherIcon == null ||
			icon != null && anotherIcon != null && icon.compareTo(anotherIcon) != 0) {
			return false;
		}
		final String anotherLabel = another.getLabel();
		if (label == null && anotherLabel != null ||
			label != null && anotherLabel == null ||
			label != null && anotherLabel != null && label.compareTo(anotherLabel) != 0) {
			return false;
		}
		final List<ColorArray> anotherLabelColor = another.getLabelColor();
		for (ColorArray outer : labelColor) {
			boolean findEqual = false;
			for (ColorArray inner : anotherLabelColor) {
				if (outer.equalsLogically(inner)) {
					findEqual = true;
					break;
				}
			}
			if (!findEqual) {
				return false;
			}
		}
		final List<ColorArray> anotherValueColor = another.getValueColor();
		for (ColorArray outer : valueColor) {
			boolean findEqual = false;
			for (ColorArray inner : anotherValueColor) {
				if (outer.equalsLogically(inner)) {
					findEqual = true;
					break;
				}
			}
			if (!findEqual) {
				return false;
			}
		}
		final List<VisibilityRule> anotherVisibility = another.getVisibility();
		for (VisibilityRule outer : visibility) {
			boolean findEqual = false;
			for (VisibilityRule inner : anotherVisibility) {
				if (outer.equalsLogically(inner)) {
					findEqual = true;
					break;
				}
			}
			if (!findEqual) {
				return false;
			}
		}
		return true;
	}

}
