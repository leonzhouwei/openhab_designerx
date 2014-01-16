package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import org.junit.Test;
import org.openhab.designerx.model.sitemap2.Chart;
import org.openhab.designerx.model.sitemap2.Colorpicker;
import org.openhab.designerx.model.sitemap2.Frame;
import org.openhab.designerx.model.xtdex.ModelXtdexConstants;
import org.openhab.designerx.model.xtdex.ModelXtdexException;
import org.openhab.designerx.model.xtdex.sitemap.ElementXtdex;

import com.google.common.collect.ImmutableList;

public class ElementXtdexImplTest {
	
	private static final ElementXtdexImpl xtdex = new ElementXtdexImpl();

//	@Test
	public void testParseChart() throws ModelXtdexException {
		final String xtext = "Chart item=Weather_Chart";
		Chart e = xtdex.parseChart(xtext);
		System.out.println(xtdex.toXtext(e));
	}
	
//	@Test
	public void testParseColorpicker() throws ModelXtdexException {
		final String xtext = "Colorpicker item=RGBLight icon=\"slider\"";
		Colorpicker e = xtdex.parseColorpicker(xtext);
		System.out.println(xtdex.toXtext(e));
	}
	
	@Test
	public void testParseFrame() throws ModelXtdexException {
		StringBuilder sb = new StringBuilder();
		sb.append("Frame {");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR);
		sb.append("    Chart item=Weather_Chart");
		sb.append(ModelXtdexConstants.LINE_SEPARATOR);
		sb.append("}");
		final String xtext = sb.toString();
		Frame e = xtdex.parseFrame(xtext);
		System.out.println(xtdex.toXtext(e));
	}

}
