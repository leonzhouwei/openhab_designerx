package org.openhab.designerx.model.sitemap;

public interface List extends Element {
	
	public final String TYPE_NAME = "List";

	public String getSeparator();

	public void setSeparator(String separator);
	
}