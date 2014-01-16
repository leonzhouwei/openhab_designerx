package org.openhab.designerx.model.sitemap2.producer.impl;

import org.openhab.designerx.model.sitemap2.Property;
import org.openhab.designerx.model.sitemap2.producer.PropertyBuilder;

public class PropertyBuilderImpl implements PropertyBuilder {
	
	@Override
	public Property build() {
		return new PropertyImpl();
	}
	
}
