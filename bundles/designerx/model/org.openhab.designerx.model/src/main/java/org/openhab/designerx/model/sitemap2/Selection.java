package org.openhab.designerx.model.sitemap2;

import java.util.List;

public interface Selection extends Element {
	
	public final String TYPE_NAME = "Selection";
	
	public void addMappings(List<Mapping> mappings);
	
	public void addMapping(Mapping mapping);
	 
	public List<Mapping> getMappings();
	
}
