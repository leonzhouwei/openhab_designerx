package org.openhab.designerx.repo.queryrepo;

import java.util.List;

import org.openhab.designerx.model.sitemap.Sitemap;

public interface SitemapQueryRepo {
	
	public List<Sitemap> listAllAsReplicas();
	
	public Sitemap getReplicaByName(String name);

}
