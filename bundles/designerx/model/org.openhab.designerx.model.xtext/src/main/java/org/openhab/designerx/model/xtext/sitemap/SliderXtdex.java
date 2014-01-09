package org.openhab.designerx.model.xtext.sitemap;

import org.openhab.designerx.model.sitemap.Slider;
import org.openhab.designerx.model.sitemap.impl.SliderBuilder;

/**
 * 
 * Syntax:
 * Slider item="<itemname>" [label="<labelname>"] [icon="<iconname>"] [sendFrequency="frequency"] [switchEnabled]
 * 
 * @author zhouwei
 *
 */
public final class SliderXtdex {
	
	public static final String TARGET_TYPE_NAME = "Slider";
	
	private static final String SWITCHSUPPORT = "switchSupport";
	private static final String SWITCHENABLED = "switchEnabled";
	
	public static Slider fromXtext(String xtext) {
		xtext = PreProcessor.preProcess(xtext);
		if (!xtext.startsWith(TARGET_TYPE_NAME)) {
			throw new RuntimeException(xtext + " is NOT a " + TARGET_TYPE_NAME);
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
		sb.append(ElementXtdex.toXtext(e).trim());
		sb.append(Constants.SPACE_MARK);
		sb.append(Constants.SENDFREQUENCY);
		sb.append(Constants.EQU_MARK);
		sb.append(e.getFrequency());
		if (e.isSwitchEnabled()) {
			sb.append(Constants.SPACE_MARK);
			sb.append(SWITCHSUPPORT);
		}
		return sb.toString().trim();
	}
	
	private SliderXtdex() {}
	
}
