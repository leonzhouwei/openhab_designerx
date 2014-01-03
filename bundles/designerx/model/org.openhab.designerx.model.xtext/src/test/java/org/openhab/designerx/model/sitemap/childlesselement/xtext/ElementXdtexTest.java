package org.openhab.designerx.model.sitemap.childlesselement.xtext;

import org.junit.Test;
import org.openhab.designerx.model.sitemap.Element;

public class ElementXdtexTest {

	@Test
	public void testFromXtext() {
		String xtext = null;
		Element e = null;
		xtext = "item=gFF";
		e = ElementXdtex.fromXtext(xtext);
		System.out.println(ElementXdtex.toXtext(e));
		xtext = "label=\"First Floor\"";
		e = ElementXdtex.fromXtext(xtext);
		System.out.println(ElementXdtex.toXtext(e));
		xtext = "icon=\"firstfloor\"";
		e = ElementXdtex.fromXtext(xtext);
		System.out.println(ElementXdtex.toXtext(e));
		xtext = "item=gFF label=\"First Floor\" icon=\"firstfloor\"";
		e = ElementXdtex.fromXtext(xtext);
		System.out.println(ElementXdtex.toXtext(e));
	}

	@Test
	public void testToXtext() {
		String xtext = "item=gFF label=\"First Floor\" icon=\"firstfloor\"";
		Element e = ElementXdtex.fromXtext(xtext);
		System.out.println(ElementXdtex.toXtext(e));
	}

}
