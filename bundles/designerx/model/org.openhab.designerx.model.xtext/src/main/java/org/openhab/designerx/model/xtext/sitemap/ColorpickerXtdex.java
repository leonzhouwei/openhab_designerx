package org.openhab.designerx.model.xtext.sitemap;

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
	
	static final String TARGET_TYPE_NAME = "Colorpicker";
	
	public static Colorpicker fromXtext(NonNestableElementXtextKeeper keeper) {
		return fromXtext(keeper.getXtext());
	}
	
	static Colorpicker fromXtext(String xtext) {
		xtext = PreProcessor.preProcess(xtext);
		if (!xtext.startsWith(TARGET_TYPE_NAME)) {
			throw new RuntimeException(xtext + " is NOT a " + TARGET_TYPE_NAME);
		}
		Colorpicker instance = new ColorpickerBuilder().build();
		// set the elementary parameters
		ElementXtdex.set(instance, xtext);
		// set the specific parameters
		String freq = PropertyHandler.getValue(xtext, Constants.SENDFREQUENCY);
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
		return sb.toString().trim();
	}
	
	private ColorpickerXtdex() {}

}
