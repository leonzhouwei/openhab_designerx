package org.openhab.designerx.modelrepository;

import org.openhab.designerx.model.sitemap.Sitemap;

public class SitemapReaderBuilder {
	
	private String name;
	
	public SitemapReaderBuilder(String name) {
		this.name = name;
	}
	
	public SitemapReader build() {
		return new SitemapReaderImpl(name);
	}
	
	private static class SitemapReaderImpl implements SitemapReader {
		private String name;
		
		public SitemapReaderImpl(String name) {
			this.name = name;
		}

		@Override
		public Sitemap read() {
			System.out.println(name);
			return null;
		}
	}
	
}
