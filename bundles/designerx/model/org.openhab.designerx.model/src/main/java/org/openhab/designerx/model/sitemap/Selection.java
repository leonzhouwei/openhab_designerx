package org.openhab.designerx.model.sitemap;

import java.util.List;

public interface Selection extends NonNestableElement {
	
	public void addMappings(List<Mapping> mappings);
	
	public void addMapping(Mapping mapping);
	 
	public List<Mapping> getMappings();
	
	public boolean equalsLogically(Selection another);

}
