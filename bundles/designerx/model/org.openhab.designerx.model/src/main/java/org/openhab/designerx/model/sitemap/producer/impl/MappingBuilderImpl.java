package org.openhab.designerx.model.sitemap.producer.impl;

import org.openhab.designerx.model.sitemap.Mapping;
import org.openhab.designerx.model.sitemap.producer.MappingBuilder;

public final class MappingBuilderImpl implements MappingBuilder {
	
	@Override
	public Mapping build() {
		return new MappingImpl();
	}
	
}
