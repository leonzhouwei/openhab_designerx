package org.openhab.designerx.model.xtdex.sitemap.impl;

import org.openhab.designerx.model.sitemap.Element;
import org.openhab.designerx.model.sitemap.SitemapElementFactory;
import org.openhab.designerx.model.sitemap.Slider;
import org.openhab.designerx.model.sitemap.impl.SitemapElementFactoryImpl;
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
	private static final String SWITCHSUPPORT = "switchSupport";
	private static final String SWITCHENABLED = "switchEnabled";
	
	private static final SitemapElementFactory factory = new SitemapElementFactoryImpl();

	static boolean isSlider(ChildlessElementXtextKeeper keeper) {
		boolean result = false;
		String xtext = keeper.getXtext();
		if (xtext.matches(MATCH_REGEX)) {
			result = true;
		}
		return result;
	}
	
	static <T extends Element> boolean isSlider(T e) {
		boolean result = false;
		if (e instanceof Slider) {
			result = true;
		}
		return result;
	}

	static Slider parseIgnoringChildren(ChildlessElementXtextKeeper keeper) {
		String xtext = keeper.getXtext();
		if (!xtext.startsWith(Slider.TYPE_NAME)) {
			return null;
		}
		Slider instance = factory.createSlider();
		// set the elementary parameters
		ElementFiller.fillWithoutChildren(instance, keeper);
		// set the specific parameters
		String freq = PropertyHandler.getValueBetweenDoubleQuotes(xtext, ModelXtdexConstants.SENDFREQUENCY);
		if (freq != null) {
			int i = Integer.parseInt(freq);
			instance.setFrequency(i);
		}
		if (xtext.contains(SWITCHENABLED) || xtext.contains(SWITCHSUPPORT)) {
			instance.setSwitchEnabled(true);
		} else {
			instance.setSwitchEnabled(false);
		}
		return instance;
	}

	static String toXtextIgnoringChildren(Slider e) {
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
		// switchEnabled
		if (e.isSwitchEnabled()) {
			sb.append(SWITCHSUPPORT);
			sb.append(ModelXtdexConstants.SPACE_MARK);
		}
		return sb.toString().trim();
	}

	private SliderXtdex() {}

}
