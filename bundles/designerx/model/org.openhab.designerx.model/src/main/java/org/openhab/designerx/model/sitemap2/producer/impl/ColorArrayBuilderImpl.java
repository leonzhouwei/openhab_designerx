package org.openhab.designerx.model.sitemap2.producer.impl;

import org.openhab.designerx.model.sitemap2.ColorArray;
import org.openhab.designerx.model.sitemap2.producer.ColorArrayBuilder;

public final class ColorArrayBuilderImpl implements ColorArrayBuilder {
	
	@Override
	public ColorArray build() {
		return new ColorArrayImpl();
	}
	
}
