package org.openhab.designerx.model.sitemap.impl;

import org.openhab.designerx.model.sitemap.ColorArray;

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
		if (arg == null && anotherArg != null ||
			arg != null && anotherArg == null ||
			arg != null && anotherArg != null && arg.compareTo(anotherArg) != 0) {
			return false;
		}
		final String anotherCondition = another.getCondition();
		if (condition == null && anotherCondition != null ||
			condition != null && anotherCondition == null ||
			condition != null && anotherCondition != null && condition.compareTo(anotherCondition) != 0) {
			return false;
		}
		final String anotherItem = another.getItem();
		if (item == null && anotherItem != null ||
			item != null && anotherItem == null ||
			item != null && anotherItem != null && item.compareTo(anotherItem) != 0) {
			return false;
		}
		final String anotherSign = another.getSign();
		if (sign == null && anotherSign != null ||
			sign != null && anotherSign == null ||
			sign != null && anotherSign != null && sign.compareTo(anotherSign) != 0) {
			return false;
		}
		final String anotherState = another.getState();
		if (state == null && anotherState != null ||
			state != null && anotherState == null ||
			state != null && anotherState != null && state.compareTo(anotherState) != 0) {
			return false;
		}
		return true;
	}

}
