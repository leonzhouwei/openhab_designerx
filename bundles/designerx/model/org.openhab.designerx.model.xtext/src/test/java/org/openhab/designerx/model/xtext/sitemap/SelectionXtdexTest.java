package org.openhab.designerx.model.xtext.sitemap;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerx.model.sitemap.Mapping;
import org.openhab.designerx.model.sitemap.Selection;
import org.openhab.designerx.model.sitemap.impl.SelectionBuilder;
import org.openhab.designerx.model.xtext.sitemap.MappingsXtdex;
import org.openhab.designerx.model.xtext.sitemap.SelectionXtdex;

public class SelectionXtdexTest {

	@Test
	public void testFromXtext() {
		final String item = "Scene_General";
		final String label = "Scene Selection";
		final List<Mapping> mappings = MappingsXtdex.fromXtext("mappings=[0=off, 1=TV, 2=Dinner, 3=Reading]");
		final String xtext = "Selection item=Scene_General label=\"Scene Selection\" mappings=[0=off, 1=TV, 2=Dinner, 3=Reading]";
		final Selection expected = new SelectionBuilder().build();
		expected.setItem(item);
		expected.setLabel(label);
		expected.addMappings(mappings);
		final Selection actual = SelectionXtdex.fromXtext(xtext);
		assertThat(expected.equalsLogically(actual), Matchers.equalTo(true));
	}

}
