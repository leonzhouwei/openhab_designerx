package org.openhab.designerx.model.sitemap;

import java.util.List;

public interface NestableElement extends Element {
	
	public void appendChild(Element child);
	
	public List<Element> getChildren();

}
