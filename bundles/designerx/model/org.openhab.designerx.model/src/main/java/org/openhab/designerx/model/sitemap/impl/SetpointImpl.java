package org.openhab.designerx.model.sitemap.impl;

import java.math.BigDecimal;
import java.util.List;

import org.openhab.designerx.model.sitemap.ColorArray;
import org.openhab.designerx.model.sitemap.Element;
import org.openhab.designerx.model.sitemap.NonNestableElement;
import org.openhab.designerx.model.sitemap.Setpoint;
import org.openhab.designerx.model.sitemap.VisibilityRule;
import org.openhab.designerx.util.Comparer;

final class SetpointImpl implements Setpoint {
	
	private NonNestableElement element = new NonNestableElementImpl();
	private BigDecimal minValue;
	private BigDecimal maxValue;
	private BigDecimal step;
	
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
	public BigDecimal getMinValue() {
		return minValue;
	}

	@Override
	public void setMinValue(BigDecimal minValue) {
		this.minValue = minValue;
	}
	
	public void setMinValue(String minValue) {
		BigDecimal bd = new BigDecimal(minValue);
		setMinValue(bd);
	}

	@Override
	public BigDecimal getMaxValue() {
		return maxValue;
	}

	@Override
	public void setMaxValue(BigDecimal maxValue) {
		this.maxValue = maxValue;
	}
	
	public void setMaxValue(String maxValue) {
		BigDecimal bd = new BigDecimal(maxValue);
		setMaxValue(bd);
	}

	@Override
	public BigDecimal getStep() {
		return step;
	}

	@Override
	public void setStep(BigDecimal step) {
		this.step = step;
	}
	
	public void setStep(String step) {
		BigDecimal bd = new BigDecimal(step);
		setStep(bd);
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
	public boolean equalsLogically(Setpoint another) {
		if (!(another instanceof Setpoint)) {
			return false;
		}
		if (this == another) {
			return true;
		}
		// minValue
		BigDecimal anotherMinValue = another.getMinValue();
		if (Comparer.notEqual(minValue, anotherMinValue)) {
			return false;
		}
		// maxValue
		BigDecimal anotherMaxValue = another.getMaxValue();
		if (Comparer.notEqual(maxValue, anotherMaxValue)) {
			return false;
		}
		// step
		BigDecimal anotherStep = another.getStep();
		if (Comparer.notEqual(step, anotherStep)) {
			return false;
		}
		if (!element.equalsLogically(another)) {
			return false;
		}
		return true;
	}

}
