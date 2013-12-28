package org.openhab.designerx.modelrepository;

import java.util.List;

import org.openhab.designerx.model.sitemap.Sitemap;

public interface SitemapReader {
	
	public Sitemap fromXtext(List<String> lines);

}
