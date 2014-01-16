package org.openhab.designerx.model.sitemap2.producer.impl;

import org.openhab.designerx.model.sitemap2.VisibilityRule;
import org.openhab.designerx.model.sitemap2.producer.VisibilityRuleBuilder;

public final class VisibilityRuleBuilderImpl implements VisibilityRuleBuilder {
	
	@Override
	public VisibilityRule build() {
		return new VisibilityRuleImpl();
	}
	
}
