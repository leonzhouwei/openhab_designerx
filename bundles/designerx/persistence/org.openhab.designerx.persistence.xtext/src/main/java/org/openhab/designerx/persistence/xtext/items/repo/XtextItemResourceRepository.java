package org.openhab.designerx.persistence.xtext.items.repo;

import java.util.Set;

import org.openhab.designerx.persistence.xtext.items.XtextItemResource;

public interface XtextItemResourceRepository {
	
	/**
	 * 
	 * @param name  e.g. 'demo' for $OPENHAB_HOME/configurations/sitemaps/demo.items
	 * @return
	 */
	public XtextItemResource find(String name);
	
	public Set<String> nameSet();
	
}
