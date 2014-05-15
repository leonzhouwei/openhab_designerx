package org.openhab.designerx.repo.queryrepo.impl;

import org.openhab.designerx.repo.queryrepo.ItemResourceQueryRepo;
import org.openhab.designerx.repo.queryrepo.SitemapQueryRepo;

public class QueryRepo {
	
	public static ItemResourceQueryRepo itemResourceQueryRepo() {
		return RealItemResourceQueryRepoImpl.getInstance();
	}
	
	public static SitemapQueryRepo sitemapQueryRepo() {
		return RealSitemapQueryRepoImpl.getInstance();
	}
	

	private QueryRepo() {}
}
