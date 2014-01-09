package org.openhab.designerx.model.sitemap.impl;

import java.util.List;

import org.openhab.designerx.model.sitemap.ColorArray;
import org.openhab.designerx.model.sitemap.Element;
import org.openhab.designerx.model.sitemap.Image;
import org.openhab.designerx.model.sitemap.NestableElement;
import org.openhab.designerx.model.sitemap.VisibilityRule;
import org.openhab.designerx.util.Comparer;

import com.google.common.collect.Lists;

final class ImageImpl implements Image {

	private NestableElement element = new NestableElementImpl(); 
	private int refresh = 0;
	private String url;
	private List<ColorArray> iconColor = Lists.newArrayList();
	
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
	public String getUrl() {
		return url;
	}

	@Override
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public int getRefresh() {
		return refresh;
	}
	
	public void setRefresh(String refresh) {
		int i = Integer.parseInt(refresh);
		setRefresh(i);
	}

	@Override
	public void setRefresh(int refresh) {
		this.refresh = refresh;
	}

	@Override
	public List<ColorArray> getIconColor() {
		return iconColor;
	}

	@Override
	public void addIconColor(List<ColorArray> iconColor) {
		this.iconColor.addAll(iconColor);
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
	public boolean equalsLogically(Image another) {
		if (!(another instanceof Image)) {
			return false;
		}
		if (this == another) {
			return true;
		}
		if (!element.equalsLogically(another)) {
			return false;
		}
		// refresh
		if (refresh != another.getRefresh()) {
			return false;
		}
		// url
		final String anotherUrl = another.getUrl();
		if (Comparer.notEqual(url, anotherUrl)) {
			return false;
		}
		// icon color
		final List<ColorArray> anotherIconColor = another.getIconColor();
		if (iconColor.size() != anotherIconColor.size()) {
			return false;
		}
		for (ColorArray outer : iconColor) {
			boolean findEqual = false;
			for (ColorArray inner : anotherIconColor) {
				if (outer.equalsLogically(inner)) {
					findEqual = true;
					break;
				}
			}
			if (findEqual == false) {
				return false;
			}
		}
		return true;
	}

}
