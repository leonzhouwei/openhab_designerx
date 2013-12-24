package org.openhab.designerx.model.internal.sitemap.node;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerx.model.Atom;
import org.openhab.designerx.model.internal.sitemap.node.AtomBuilder;

public class AtomBuilderTest {

	@Test
	public void testBuild() {
		final String expected = "Chart item=Weather_Chart period=h refresh=600 visibility=[Weather_Chart_Period==0, Weather_Chart_Period==\"Uninitialized\"]";
		Atom atom = AtomBuilder.build(expected);
		String actual = atom.toXtext();
		assertThat(actual, Matchers.equalTo(expected));
	}

}
