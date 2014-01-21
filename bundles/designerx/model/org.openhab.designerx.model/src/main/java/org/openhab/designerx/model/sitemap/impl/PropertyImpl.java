package org.openhab.designerx.model.sitemap.impl;

import org.openhab.designerx.model.sitemap.Property;

final class PropertyImpl implements Property {
	private String name; // should not be null or empty
	private String value;
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getValue() {
		return value;
	}
	
	@Override
	public void setName(String name) {
		this.name = name.trim();
	}
	
	@Override
	public void setValue(String value) {
		if (value != null) {
			value = value.trim();
		}
		this.value = value;
	}

}
