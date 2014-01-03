package org.openhab.designerx.model.sitemap.childlesselement.xtext;

import java.util.List;

import org.junit.Test;
import org.openhab.designerx.model.sitemap.ColorArray;
import org.openhab.designerx.model.sitemap.childlesselement.xtext.ColorArrayXtdex;

public class ColorArrayXtdexTest {
	
	private static final String type = "valuecolor";
	
	private static final String xtext = 
		type + "=" + 
		"[" + 
		"Weather_LastUpdate==\"Uninitialized\"=\"lightgray\"," + 
		"Weather_LastUpdate>90=\"lightgray\",>25=\"orange\",>15=\"green\",>5=\"orange\",<=5=\"blue\"" +
		"]";

	@Test
	public void testFromXtext() {
		List<ColorArray> ca = ColorArrayXtdex.fromXtext(xtext, type);
		System.out.println(ColorArrayXtdex.toXtext(ca, type));
	}

	@Test
	public void testToXtext() {
		List<ColorArray> ca = ColorArrayXtdex.fromXtext(xtext, type);
		System.out.println(ColorArrayXtdex.toXtext(ca, type));
	}

}
