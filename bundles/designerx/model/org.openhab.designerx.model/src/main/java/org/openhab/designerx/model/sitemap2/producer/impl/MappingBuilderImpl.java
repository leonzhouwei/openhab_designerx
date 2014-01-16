package org.openhab.designerx.model.sitemap2.producer.impl;

import org.openhab.designerx.model.sitemap2.Mapping;
import org.openhab.designerx.model.sitemap2.producer.MappingBuilder;

public final class MappingBuilderImpl implements MappingBuilder {
	
	@Override
	public Mapping build() {
		return new MappingImpl();
	}
	
}
