package org.openhab.designerx.model.sitemap2.producer.impl;

import org.openhab.designerx.model.sitemap2.VisibilityRule;

public final class VisibilityRuleBuilder {
	
	public VisibilityRule build() {
		return new VisibilityRuleImpl();
	}
	
	private class VisibilityRuleImpl implements VisibilityRule {
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
	}
}
