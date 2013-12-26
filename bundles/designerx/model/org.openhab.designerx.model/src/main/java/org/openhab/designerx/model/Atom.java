package org.openhab.designerx.model;

import java.util.Collection;

public interface Atom {

	/**
	 * 
	 * @return "sitemap", "Chart", "Colorpicker", ...
	 */
	public String getType();

	public Properties getProperties();

	public boolean addProperty(Property property);

	public boolean addProperties(Collection<? extends Property> properties);
	
	public String toXtext();

}
