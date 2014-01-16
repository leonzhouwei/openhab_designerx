package org.openhab.designerx.model.sitemap2;

import java.util.List;

public interface Switch extends Element {
	
	public final String TYPE_NAME = "Switch";
	
	public void addMappings(List<Mapping> mappings);
	
	public void addMapping(Mapping mapping);
	
	public List<Mapping> getMappings();
	
}
