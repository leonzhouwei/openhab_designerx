package org.openhab.designerx.repo.queryrepo;

import java.util.List;
import java.util.Set;

import org.openhab.designerx.model.sitemap.Sitemap;

public interface SitemapQueryRepo {
	
	public List<Sitemap> listAllAsReplicas();
	
	public Sitemap getReplicaByName(String name);

	public Set<String> names();

}
