package org.openhab.designerx.model.sitemap.childlesselement.xtext;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerx.model.sitemap.ColorArray;
import org.openhab.designerx.model.sitemap.childlesselement.xtext.ColorArrayXtdex;
import org.openhab.designerx.model.sitemap.impl.ColorArrayBuilder;

import com.google.common.collect.Lists;

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

	@Test
	public void testToXtext() {
		final String expected = "valuecolor=[Weather_LastUpdate==\"Uninitialized\"=\"lightgray\"]";
		List<ColorArray> list = Lists.newArrayList();
		ColorArray e = new ColorArrayBuilder().build();
		e.setItem("Weather_LastUpdate");
		e.setCondition("==\"Uninitialized\"");
		e.setArg("\"lightgray\"");
		list.add(e);
		final String actual = ColorArrayXtdex.toXtext(list, Constants.VALUECOLOR);
		assertThat(actual, Matchers.equalTo(expected));
	}
	
}
