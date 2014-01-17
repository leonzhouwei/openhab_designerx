package org.openhab.designerx.model.sitemap.producer.impl;

import org.openhab.designerx.model.sitemap.ColorArray;
import org.openhab.designerx.model.sitemap.producer.ColorArrayBuilder;

public final class ColorArrayBuilderImpl implements ColorArrayBuilder {
	
	@Override
	public ColorArray build() {
		return new ColorArrayImpl();
	}
	
	private class ColorArrayImpl implements ColorArray {
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
	}
	
}
