package org.openhab.designerx.model.internal.sitemap.atom;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerx.model.internal.sitemap.node.atom.Group;

public class GroupTest {

	@Test
	public void testParse() {
		final String expected = "Group item=gFF label=\"First Floor\" icon=\"firstfloor\"";
		Group sitemapElement = Group.parse(expected);
		String actual = sitemapElement.toXtext();
		assertThat(actual, Matchers.equalTo(expected));
	}

}
