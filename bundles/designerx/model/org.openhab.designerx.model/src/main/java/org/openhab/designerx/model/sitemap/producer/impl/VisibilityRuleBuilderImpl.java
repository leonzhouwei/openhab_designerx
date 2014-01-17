package org.openhab.designerx.model.sitemap.producer.impl;

import org.openhab.designerx.model.sitemap.VisibilityRule;
import org.openhab.designerx.model.sitemap.producer.VisibilityRuleBuilder;

public final class VisibilityRuleBuilderImpl implements VisibilityRuleBuilder {
	
	@Override
	public VisibilityRule build() {
		return new VisibilityRuleImpl();
	}
	
}
