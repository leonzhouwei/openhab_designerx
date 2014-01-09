package org.openhab.designerx.model.sitemap.childlesselement.xtext;

import org.openhab.designerx.model.sitemap.Colorpicker;
import org.openhab.designerx.model.sitemap.impl.ColorpickerBuilder;

/**
 * 
 * Syntax: Colorpicker [item="<itemname>"] [label="<labelname>"] [icon="<iconname>"] [sendFrequency=""]
 * 
 * @author zhouwei
 * 
 */
public final class ColorpickerXtdex {
	
	public static final String TARGET_TYPE_NAME = "Colorpicker";
	
	public static Colorpicker fromXtext(String xtext) {
		xtext = PreProcessor.preProcess(xtext);
		if (!xtext.startsWith(TARGET_TYPE_NAME)) {
			throw new RuntimeException(xtext + " is NOT a " + TARGET_TYPE_NAME);
		}
		Colorpicker instance = new ColorpickerBuilder().build();
		// set the elementary parameters
		ElementXtdex.set(instance, xtext);
		// set the specific parameters
		String freq = PropertyHandler.getValueWithoutStartEndMarks(xtext, Constants.SENDFREQUENCY);
		if (freq != null) {
			int i = Integer.parseInt(freq);
			instance.setFrequency(i);
		}
		return instance;
	}
	
	public static String toXtext(Colorpicker e) {
		StringBuilder sb = new StringBuilder();
		sb.append(TARGET_TYPE_NAME);
		sb.append(Constants.SPACE_MARK);
		sb.append(ElementXtdex.toXtext(e).trim());
		sb.append(Constants.SPACE_MARK);
		sb.append(Constants.SENDFREQUENCY);
		sb.append(Constants.EQU_MARK);
		sb.append(e.getFrequency());
		return sb.toString().trim();
	}
	
	private ColorpickerXtdex() {}

}
