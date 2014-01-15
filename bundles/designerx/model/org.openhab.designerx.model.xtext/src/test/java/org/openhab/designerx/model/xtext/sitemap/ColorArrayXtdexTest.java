package org.openhab.designerx.model.xtext.sitemap;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerx.model.sitemap.ColorArray;
import org.openhab.designerx.model.xtext.XtextConstants;
import org.openhab.designerx.model.xtext.sitemap.ColorArrayXtdex;

public class ColorArrayXtdexTest {
	
	@Test
	public void testFromXtext() {
		final String expected = 
				"valuecolor=" + 
				"[" + 
				"Weather_LastUpdate==\"Uninitialized\"=\"lightgray\"," + 
				"Weather_LastUpdate>90=\"lightgray\",>25=\"orange\",>15=\"green\",>5=\"orange\",<=5=\"blue\"" +
				"]";
		List<ColorArray> ca = ColorArrayXtdex.fromXtext(expected, XtextConstants.VALUECOLOR);
		String actual = ColorArrayXtdex.toXtext(ca, XtextConstants.VALUECOLOR);
		assertThat(actual, Matchers.equalTo(expected));
	}

}
