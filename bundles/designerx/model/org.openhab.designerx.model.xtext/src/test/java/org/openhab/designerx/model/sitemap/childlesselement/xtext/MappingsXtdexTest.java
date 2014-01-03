package org.openhab.designerx.model.sitemap.childlesselement.xtext;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerx.model.sitemap.Mapping;

public class MappingsXtdexTest {

	@Test
	public void testFromXtext() {
	}

	@Test
	public void testToXtext() {
		final String expected = "mappings=[0=\"Hour\",1=\"Day\",2=\"Week\"]";
		List<Mapping> mappings = MappingsXtdex.fromXtext(expected);
		final String actual = MappingsXtdex.toXtext(mappings);
		assertThat(actual, Matchers.equalTo(expected));
	}

}
