package org.openhab.designerx.model.sitemap.producer.impl;

import org.openhab.designerx.model.sitemap.ColorArray;
import org.openhab.designerx.model.sitemap.producer.ColorArrayBuilder;

public final class ColorArrayBuilderImpl implements ColorArrayBuilder {
	
	@Override
	public ColorArray build() {
		return new ColorArrayImpl();
	}
	
}
