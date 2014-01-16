package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import java.math.BigDecimal;

import org.openhab.designerx.model.sitemap2.Setpoint;
import org.openhab.designerx.model.sitemap2.producer.ElementFactory;
import org.openhab.designerx.model.sitemap2.producer.impl.ElementFactoryImpl;

/**
 * 
 * Syntax: 
 * Setpoint item="<itemname>" [label="<labelname>"] [icon="<iconname>"] minValue="<min value>" maxValue="<max value>" step="<step value>"
 * 
 * @author zhouwei
 * 
 */
public final class SetpointXtdex {
	private static final String MINVALUE = "minValue";
	private static final String MAXVALUE = "maxValue";
	private static final String STEP = "step";
	private static final String MATCH_REGEX = "\\s*" + Setpoint.TYPE_NAME + "\\b.*";
	private static final ElementFactory factory = new ElementFactoryImpl();
	
	public static Setpoint fromXtext(NonNestableElementXtextKeeper keeper) {
		String xtext = keeper.getXtext();
		if (!xtext.startsWith(Setpoint.TYPE_NAME)) {
			return null;
		}
		Setpoint instance = factory.createSetpoint();
		// set the elementary parameters
		ElementXtdexImpl.fillWithoutChildren(instance, keeper);
		// set the specific parameters
		String min = PropertyHandler.getValue(xtext, MINVALUE);
		if (min != null) {
			BigDecimal bd = new BigDecimal(min);
			instance.setMinValue(bd);
		}
		String max = PropertyHandler.getValue(xtext, MAXVALUE);
		if (max != null) {
			BigDecimal bd = new BigDecimal(max);
			instance.setMaxValue(bd);
		}
		String step = PropertyHandler.getValue(xtext, STEP);
		if (step != null) {
			BigDecimal bd = new BigDecimal(step);
			instance.setStep(bd);
		}
		return instance;
	}
	
	private SetpointXtdex() {}
	
	public static boolean isSetpoint(String xtext) {
		boolean result = false;
		if (xtext.matches(MATCH_REGEX)) {
			result = true;
		}
		return result;
	}
	
}
