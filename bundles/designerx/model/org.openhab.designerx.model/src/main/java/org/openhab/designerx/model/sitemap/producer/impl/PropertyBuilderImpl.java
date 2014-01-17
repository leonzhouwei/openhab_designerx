package org.openhab.designerx.model.sitemap.producer.impl;

import org.openhab.designerx.model.sitemap.Property;
import org.openhab.designerx.model.sitemap.producer.PropertyBuilder;

public class PropertyBuilderImpl implements PropertyBuilder {
	
	@Override
	public Property build() {
		return new PropertyImpl();
	}
	
}
