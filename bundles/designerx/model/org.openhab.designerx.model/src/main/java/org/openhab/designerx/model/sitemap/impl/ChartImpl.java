package org.openhab.designerx.model.sitemap.impl;

import java.util.List;

import org.openhab.designerx.model.sitemap.Chart;
import org.openhab.designerx.model.sitemap.ColorArray;
import org.openhab.designerx.model.sitemap.Element;
import org.openhab.designerx.model.sitemap.NonNestableElement;
import org.openhab.designerx.model.sitemap.VisibilityRule;

/**
 * 
 * Syntax: 
 * Chart [item="<itemname>"] [icon="<iconname>"] [label="<labelname>"] [service="<service>"] [period=xxxx] [refresh=xxxx] [visibility=xxxx]
 * 
 * @author zhouwei
 * 
 */
final class ChartImpl implements Chart {

	private NonNestableElement element = new NonNestableElementImpl();
	private String period;
	private int refresh;
	private String service;

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
	public String getService() {
		return service;
	}

	@Override
	public void setService(String service) {
		this.service = service;
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
	public String getPeriod() {
		return period;
	}

	@Override
	public void setPeriod(String period) {
		this.period = period;
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
	public boolean equalsLogically(Chart another) {
		if (!(another instanceof Chart)) {
			return false;
		}
		if (this == another) {
			return true;
		}
		final String anotherPeriod = another.getPeriod();
		if (period == null && anotherPeriod != null ||
			period != null && anotherPeriod == null ||
			period != null && anotherPeriod != null && period.compareTo(anotherPeriod) != 0) {
			return false;
		}
		final int anotherRefresh = another.getRefresh();
		if (refresh != anotherRefresh) {
			return false;
		}
		final String anotherService = another.getService();
		if (service == null && anotherService != null ||
			service != null && anotherService == null ||
			service != null && anotherService != null && service.compareTo(anotherService) != 0) {
			return false;
		}
		return true;
	}
	
}
