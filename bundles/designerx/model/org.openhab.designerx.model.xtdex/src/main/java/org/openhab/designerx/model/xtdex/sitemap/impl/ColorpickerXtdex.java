package org.openhab.designerx.model.xtdex.sitemap.impl;

import org.openhab.designerx.model.sitemap.Colorpicker;
import org.openhab.designerx.model.sitemap.Element;
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
	
	static boolean isColorpicker(ChildlessElementXtextKeeper keeper) {
		boolean result = false;
		String xtext = keeper.getXtext();
		if (xtext.matches(MATCH_REGEX)) {
			result = true;
		}
		return result;
	}

	static <T extends Element> boolean isColorpicker(T e) {
		boolean result = false;
		if (e instanceof Colorpicker) {
			result = true;
		}
		return result;
	}

	static Colorpicker parseIgnoringChildren(ChildlessElementXtextKeeper keeper) {
		String xtext = keeper.getXtext();
		if (!xtext.matches(MATCH_REGEX)) {
			return null;
		}
		Colorpicker instance = factory.createColorpicker();
		// set the elementary parameters
		ElementFiller.fillWithoutChildren(instance, keeper);
		// set the specific parameters
		String freq = PropertyHandler.getValue(xtext, ModelXtdexConstants.SENDFREQUENCY);
		if (freq != null) {
			int i = Integer.parseInt(freq);
			instance.setFrequency(i);
		}
		return instance;
	}

	static String toXtextIgnoringChildren(Colorpicker e) {
		StringBuilder sb = new StringBuilder();
		// convert the elementary parameters
		sb.append(ElementXtextualizer.toXtextIgnoringChildren(e));
		sb.append(ModelXtdexConstants.SPACE_MARK);
		// convert the specific parameters below
		// frequency
		sb.append(ModelXtdexConstants.SENDFREQUENCY);
		sb.append(ModelXtdexConstants.EQU_MARK);
		sb.append(e.getFrequency());
		sb.append(ModelXtdexConstants.SPACE_MARK);
		return sb.toString().trim();
	}

	private ColorpickerXtdex() {}

}
