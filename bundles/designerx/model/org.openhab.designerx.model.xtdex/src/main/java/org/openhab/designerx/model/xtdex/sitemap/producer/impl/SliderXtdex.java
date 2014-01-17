package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import org.openhab.designerx.model.sitemap.Slider;
import org.openhab.designerx.model.sitemap.producer.ElementFactory;
import org.openhab.designerx.model.sitemap.producer.impl.ElementFactoryImpl;
import org.openhab.designerx.model.xtdex.ModelXtdexConstants;

/**
 * 
 * Syntax:
 * Slider item="<itemname>" [label="<labelname>"] [icon="<iconname>"] [sendFrequency="frequency"] [switchEnabled]
 * 
 * @author zhouwei
 *
 */
final class SliderXtdex {
	private static final String MATCH_REGEX = "\\s*" + Slider.TYPE_NAME + "\\b.*";
	private static final ElementFactory factory = new ElementFactoryImpl();

	static boolean isSlider(String xtext) {
		boolean result = false;
		if (xtext.matches(MATCH_REGEX)) {
			result = true;
		}
		return result;
	}

	static Slider parseIgnoringChildren(NonNestableElementXtextKeeper keeper) {
		String xtext = keeper.getXtext();
		if (!xtext.startsWith(Slider.TYPE_NAME)) {
			return null;
		}
		Slider instance = factory.createSlider();
		// set the elementary parameters
		ElementFiller.fillWithoutChildren(instance, keeper);
		// set the specific parameters
		return instance;
	}

	static String toXtextIgnoringChildren(Slider e) {
		StringBuilder sb = new StringBuilder();
		// convert the elementary parameters
		sb.append(ElementXtextualizer.toXtextIgnoringChildren(e));
		sb.append(ModelXtdexConstants.SPACE_MARK);
		// convert the specific parameters below
		return sb.toString().trim();
	}

	private SliderXtdex() {}

}
