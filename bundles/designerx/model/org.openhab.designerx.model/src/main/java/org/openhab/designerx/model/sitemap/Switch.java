package org.openhab.designerx.model.sitemap;

import java.util.List;

public interface Switch extends NonNestableElement {
	
	public void addMappings(List<Mapping> mappings);
	
	public void addMapping(Mapping mapping);
	
	public List<Mapping> getMappings();

}
