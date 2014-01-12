package org.openhab.designerx.model.xtext.sitemap;

import org.openhab.designerx.model.sitemap.Slider;
import org.openhab.designerx.model.sitemap.impl.SliderBuilder;
import org.openhab.designerx.model.xtext.Constants;

/**
 * 
 * Syntax:
 * Slider item="<itemname>" [label="<labelname>"] [icon="<iconname>"] [sendFrequency="frequency"] [switchEnabled]
 * 
 * @author zhouwei
 *
 */
public final class SliderXtdex {
	
	static final String TARGET_TYPE_NAME = "Slider";
	
	private static final String SWITCHSUPPORT = "switchSupport";
	private static final String SWITCHENABLED = "switchEnabled";
	private static final String MATCH_REGEX = "\\s*" + TARGET_TYPE_NAME + "\\b.*";
	
	static Slider fromXtext(NonNestableElementXtextKeeper keeper) {
		return fromXtext(keeper.getXtext());
	}
	
	static Slider fromXtext(String xtext) {
		xtext = PreProcessor.preProcess(xtext);
		if (!xtext.startsWith(TARGET_TYPE_NAME)) {
			return null;
		}
		Slider instance = new SliderBuilder().build();
		// set the elementary parameters
		ElementXtdex.set(instance, xtext);
		// set the specific parameters
		String freq = PropertyHandler.getValueBetweenDoubleQuotes(xtext, Constants.SENDFREQUENCY);
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
	
	public static String toXtext(Slider e) {
		StringBuilder sb = new StringBuilder();
		sb.append(TARGET_TYPE_NAME);
		sb.append(Constants.SPACE_MARK);
		// element
		String elemStr = ElementXtdex.toXtext(e);
		if (!elemStr.isEmpty()) {
			sb.append(elemStr);	
			sb.append(Constants.SPACE_MARK);
		}
		// frequency
		sb.append(Constants.SENDFREQUENCY);
		sb.append(Constants.EQU_MARK);
		sb.append(e.getFrequency());
		sb.append(Constants.SPACE_MARK);
		// switchEnabled
		if (e.isSwitchEnabled()) {
			sb.append(SWITCHSUPPORT);
			sb.append(Constants.SPACE_MARK);
		}
		return sb.toString().trim();
	}
	
	private SliderXtdex() {}
	
	public static boolean isSlider(String xtext) {
		boolean result = false;
		if (xtext.matches(MATCH_REGEX)) {
			result = true;
		}
		return result;
	}
	
}
