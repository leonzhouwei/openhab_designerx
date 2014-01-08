package org.openhab.designerx.model.sitemap.impl;

import org.openhab.designerx.model.sitemap.ColorArray;
import org.openhab.designerx.util.Comparer;

final class ColorArrayImpl implements ColorArray {

	private String arg;
	private String condition;
	private String item;
	private String sign;
	private String state;

	@Override
	public String getItem() {
		return item;
	}

	@Override
	public void setItem(String item) {
		this.item = item;
	}

	@Override
	public String getCondition() {
		return condition;
	}

	@Override
	public void setCondition(String condition) {
		this.condition = condition;
	}

	@Override
	public String getSign() {
		return sign;
	}

	@Override
	public void setSign(String sign) {
		this.sign = sign;
	}

	@Override
	public String getState() {
		return state;
	}

	@Override
	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String getArg() {
		return arg;
	}

	@Override
	public void setArg(String arg) {
		this.arg = arg;
	}

	@Override
	public boolean equalsLogically(ColorArray another) {
		if (!(another instanceof ColorArray)) {
			return false;
		}
		if (this == another) {
			return true;
		}
		final String anotherArg = another.getArg();
		if (Comparer.notEqual(arg, anotherArg)) {
			return false;
		}
		final String anotherCondition = another.getCondition();
		if (Comparer.notEqual(condition, anotherCondition)) {
			return false;
		}
		final String anotherItem = another.getItem();
		if (Comparer.notEqual(item, anotherItem)) {
			return false;
		}
		final String anotherSign = another.getSign();
		if (Comparer.notEqual(sign, anotherSign)) {
			return false;
		}
		final String anotherState = another.getState();
		if (Comparer.notEqual(state, anotherState)) {
			return false;
		}
		return true;
	}

}
