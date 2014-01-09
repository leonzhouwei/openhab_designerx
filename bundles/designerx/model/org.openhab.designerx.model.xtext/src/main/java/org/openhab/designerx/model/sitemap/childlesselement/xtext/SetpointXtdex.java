package org.openhab.designerx.model.sitemap.childlesselement.xtext;

import java.math.BigDecimal;

import org.openhab.designerx.model.sitemap.Setpoint;
import org.openhab.designerx.model.sitemap.impl.SetpointBuilder;

/**
 * 
 * Syntax: 
 * Setpoint item="<itemname>" [label="<labelname>"] [icon="<iconname>"] minValue="<min value>" maxValue="<max value>" step="<step value>"
 * 
 * @author zhouwei
 * 
 */
public final class SetpointXtdex {
	
	public static final String TARGET_TYPE_NAME = "Setpoint";
	
	private static final String MINVALUE = "minValue";
	private static final String MAXVALUE = "maxValue";
	private static final String STEP = "step";
	
	public static Setpoint fromXtext(String xtext) {
		xtext = PreProcessor.preProcess(xtext);
		if (!xtext.startsWith(TARGET_TYPE_NAME)) {
			throw new RuntimeException(xtext + " is NOT a " + TARGET_TYPE_NAME);
		}
		Setpoint instance = new SetpointBuilder().build();
		// set the elementary parameters
		ElementXtdex.set(instance, xtext);
		// set the specific parameters
		String min = PropertyHandler.getValueWithoutStartEndMarks(xtext, MINVALUE);
		if (min != null) {
			BigDecimal bd = new BigDecimal(min);
			instance.setMinValue(bd);
		}
		String max = PropertyHandler.getValueWithoutStartEndMarks(xtext, MAXVALUE);
		if (max != null) {
			BigDecimal bd = new BigDecimal(max);
			instance.setMaxValue(bd);
		}
		String step = PropertyHandler.getValueWithoutStartEndMarks(xtext, STEP);
		if (step != null) {
			BigDecimal bd = new BigDecimal(step);
			instance.setStep(bd);
		}
		return instance;
	}
	
	public static String toXtext(Setpoint e) {
		StringBuilder sb = new StringBuilder();
		sb.append(TARGET_TYPE_NAME);
		sb.append(Constants.SPACE_MARK);
		if (e.getMinValue() != null) {
			sb.append(MINVALUE);
			sb.append(Constants.EQU_MARK);
			sb.append(e.getMinValue());
			sb.append(Constants.SPACE_MARK);
		}
		if (e.getMaxValue() != null) {
			sb.append(MAXVALUE);
			sb.append(Constants.EQU_MARK);
			sb.append(e.getMaxValue());
			sb.append(Constants.SPACE_MARK);
		}
		if (e.getStep() != null) {
			sb.append(STEP);
			sb.append(Constants.EQU_MARK);
			sb.append(e.getStep());
			sb.append(Constants.SPACE_MARK);
		}
		sb.append(ElementXtdex.toXtext(e).trim());
		return sb.toString().trim();
	}
	
	private SetpointXtdex() {}
	
}
