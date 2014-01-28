package org.openhab.designerx.persistence.xtext.sitemap;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openhab.designerx.model.ModelException;
import org.openhab.designerx.model.sitemap.Sitemap;
import org.openhab.designerx.model.xtdex.ModelXtdexException;

public interface SitemapQuery {

	public Set<String> nameSet();
	
	public List<Sitemap> replicas() throws IOException, ModelXtdexException, ModelException;
	
	public Sitemap getReplicaByName(String name) throws IOException, ModelXtdexException, ModelException;
	
}
