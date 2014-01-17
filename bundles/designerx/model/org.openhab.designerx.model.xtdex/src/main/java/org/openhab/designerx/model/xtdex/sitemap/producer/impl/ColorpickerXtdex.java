package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import org.openhab.designerx.model.sitemap.Colorpicker;
import org.openhab.designerx.model.sitemap.producer.ElementFactory;
import org.openhab.designerx.model.sitemap.producer.impl.ElementFactoryImpl;
import org.openhab.designerx.model.xtdex.ModelXtdexConstants;

/**
 * 
 * Syntax: Colorpicker [item="<itemname>"] [label="<labelname>"] [icon="<iconname>"] [sendFrequency=""]
 * 
 * @author zhouwei
 * 
 */
final class ColorpickerXtdex {
	private static final String MATCH_REGEX = "\\s*" + Colorpicker.TYPE_NAME + "\\b.*";
	private static final ElementFactory factory = new ElementFactoryImpl();

	static boolean isColorpicker(String xtext) {
		boolean result = false;
		if (xtext.matches(MATCH_REGEX)) {
			result = true;
		}
		return result;
	}

	static Colorpicker parseIgnoringChildren(NonNestableElementXtextKeeper keeper) {
		String xtext = keeper.getXtext();
		if (!xtext.startsWith(Colorpicker.TYPE_NAME)) {
			return null;
		}
		Colorpicker instance = factory.createColorpicker();
		// set the elementary parameters
		ElementFiller.fillWithoutChildren(instance, keeper);
		// set the specific parameters
		return instance;
	}

	static String toXtextIgnoringChildren(Colorpicker e) {
		StringBuilder sb = new StringBuilder();
		// convert the elementary parameters
		sb.append(ElementXtextualizer.toXtextIgnoringChildren(e));
		sb.append(ModelXtdexConstants.SPACE_MARK);
		// convert the specific parameters below
		return sb.toString().trim();
	}

	private ColorpickerXtdex() {}

}
