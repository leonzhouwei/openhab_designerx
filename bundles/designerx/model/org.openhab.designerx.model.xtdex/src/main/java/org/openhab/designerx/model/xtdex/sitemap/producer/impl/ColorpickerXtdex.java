package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import org.openhab.designerx.model.sitemap2.Colorpicker;
import org.openhab.designerx.model.sitemap2.producer.ElementFactory;
import org.openhab.designerx.model.sitemap2.producer.impl.ElementFactoryImpl;
import org.openhab.designerx.model.xtdex.ModelXtdexConstants;

/**
 * 
 * Syntax: Colorpicker [item="<itemname>"] [label="<labelname>"] [icon="<iconname>"] [sendFrequency=""]
 * 
 * @author zhouwei
 * 
 */
public final class ColorpickerXtdex {
	private static final String MATCH_REGEX = "\\s*" + Colorpicker.TYPE_NAME + "\\b.*";
	private static final ElementFactory factory = new ElementFactoryImpl();
	
	public static Colorpicker fromXtext(NonNestableElementXtextKeeper keeper) {
		String xtext = keeper.getXtext();
		if (!xtext.startsWith(Colorpicker.TYPE_NAME)) {
			return null;
		}
		Colorpicker instance = factory.createColorpicker();
		// set the elementary parameters
		ElementXtdexImpl.fillWithoutChildren(instance, keeper);
		// set the specific parameters
		String freq = PropertyHandler.getValue(xtext, ModelXtdexConstants.SENDFREQUENCY);
		if (freq != null) {
			int i = Integer.parseInt(freq);
			instance.setFrequency(i);
		}
		return instance;
	}
	
	private ColorpickerXtdex() {}
	
	public static boolean isColorpicker(String xtext) {
		boolean result = false;
		if (xtext.matches(MATCH_REGEX)) {
			result = true;
		}
		return result;
	}

}
