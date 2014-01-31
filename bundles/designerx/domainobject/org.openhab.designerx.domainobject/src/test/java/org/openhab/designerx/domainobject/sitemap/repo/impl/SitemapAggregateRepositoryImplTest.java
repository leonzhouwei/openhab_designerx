package org.openhab.designerx.domainobject.sitemap.repo.impl;

import java.util.Set;

import org.junit.Test;
import org.openhab.designerx.domainobject.sitemap.repo.SitemapAggregateRepository;
import org.openhab.designerx.util.StringHelper;

public class SitemapAggregateRepositoryImplTest {
	private static final SitemapAggregateRepository repo = SitemapAggregateRepositoryImpl.getInstance();

	@Test
	public void test() {
		StringHelper.printTestStartLine();
		Set<String> names = repo.nameSet();
		for (String name : names) {
			System.out.println(name);
			System.out.println(repo.findByName(name).toString());
		}
		StringHelper.printTestEndLine();
	}

}
