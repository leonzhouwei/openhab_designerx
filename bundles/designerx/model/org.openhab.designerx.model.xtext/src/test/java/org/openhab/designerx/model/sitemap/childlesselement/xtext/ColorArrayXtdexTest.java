package org.openhab.designerx.model.sitemap.childlesselement.xtext;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerx.model.sitemap.ColorArray;

public class ColorArrayXtdexTest {
	
	@Test
	public void testFromXtext() {
		final String expected = 
				"valuecolor=" + 
				"[" + 
				"Weather_LastUpdate==\"Uninitialized\"=\"lightgray\"," + 
				"Weather_LastUpdate>90=\"lightgray\",>25=\"orange\",>15=\"green\",>5=\"orange\",<=5=\"blue\"" +
				"]";
		List<ColorArray> ca = ColorArrayXtdex.fromXtext(expected, Constants.VALUECOLOR);
		String actual = ColorArrayXtdex.toXtext(ca, Constants.VALUECOLOR);
		assertThat(actual, Matchers.equalTo(expected));
	}

}
