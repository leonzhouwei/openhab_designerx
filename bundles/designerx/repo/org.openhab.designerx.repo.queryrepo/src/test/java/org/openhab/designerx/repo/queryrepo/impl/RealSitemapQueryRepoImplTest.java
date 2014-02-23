package org.openhab.designerx.repo.queryrepo.impl;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerx.bizlogic.cqrs.eventbus.EventBus;
import org.openhab.designerx.bizlogic.cqrs.eventbus.Publisher;
import org.openhab.designerx.bizlogic.cqrs.eventbus.SitemapUpdatedEvent;
import org.openhab.designerx.bizlogic.cqrs.eventbus.impl.EventBusImpl;
import org.openhab.designerx.model.sitemap.Sitemap;
import org.openhab.designerx.model.xtdex.sitemap.SitemapXtdex;
import org.openhab.designerx.model.xtdex.sitemap.impl.SitemapXtdexImpl;

public class RealSitemapQueryRepoImplTest {
	private static final RealSitemapQueryRepoImpl repo = RealSitemapQueryRepoImpl.getInstance();
	private static final SitemapXtdex xtdex = new SitemapXtdexImpl();
	private static final EventBus eventBus = EventBusImpl.getInstance();

	@Test
	public void testUpdate() {
		final String sitemapName = "test";
		final String expected = 
				"sitemap test label=\"Main Menu\" {\n" +
				"    Frame {\n" + 
				"        Text item=test_text\n" + 
				"    }\n" + 
				"}";
		//
		Publisher pub = eventBus.newPublisher();
		pub.publish(new SitemapUpdatedEvent() {
			@Override
			public String sitemapName() {
				return sitemapName;
			}
			
			@Override
			public String sitemapXtext() {
				Sitemap ir = null;
				try {
					ir = xtdex.parse(expected);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
				return xtdex.toXtext(ir);
			}
		});
		//
		String actual = xtdex.toXtext(repo.getReplicaByName("test")).trim();
		assertThat(actual, Matchers.equalTo(expected));
	}

}
