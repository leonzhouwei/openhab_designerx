package org.openhab.designerx.model.xtdex.sitemap.impl;

import java.math.BigDecimal;

import org.openhab.designerx.model.sitemap.Element;
import org.openhab.designerx.model.sitemap.SitemapElementFactory;
import org.openhab.designerx.model.sitemap.Setpoint;
import org.openhab.designerx.model.sitemap.impl.SitemapElementFactoryImpl;
import org.openhab.designerx.model.xtdex.ModelXtdexConstants;

/**
 * 
 * Syntax: 
 * Setpoint item="<itemname>" [label="<labelname>"] [icon="<iconname>"] minValue="<min value>" maxValue="<max value>" step="<step value>"
 * 
 * @author zhouwei
 * 
 */
final class SetpointXtdex {
	private static final String MATCH_REGEX = "\\s*" + Setpoint.TYPE_NAME + "\\b.*";
	private static final String MINVALUE = "minValue";
	private static final String MAXVALUE = "maxValue";
	private static final String STEP = "step";
	
	private static final SitemapElementFactory factory = new SitemapElementFactoryImpl();

	static boolean isSetpoint(ChildlessElementXtextKeeper keeper) {
		boolean result = false;
		String xtext = keeper.getXtext();
		if (xtext.matches(MATCH_REGEX)) {
			result = true;
		}
		return result;
	}
	
	static <T extends Element> boolean isSetpoint(T e) {
		boolean result = false;
		if (e instanceof Setpoint) {
			result = true;
		}
		return result;
	}

	static Setpoint parseIgnoringChildren(ChildlessElementXtextKeeper keeper) {
		String xtext = keeper.getXtext();
		if (!xtext.startsWith(Setpoint.TYPE_NAME)) {
			return null;
		}
		Setpoint instance = factory.createSetpoint();
		// set the elementary parameters
		ElementFiller.fillWithoutChildren(instance, keeper);
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

	static String toXtextIgnoringChildren(Setpoint e) {
		StringBuilder sb = new StringBuilder();
		// convert the elementary parameters
		sb.append(ElementXtextualizer.toXtextIgnoringChildren(e));
		sb.append(ModelXtdexConstants.SPACE_MARK);
		// convert the specific parameters below
		// minValue
		BigDecimal minValue = e.getMinValue();
		if (minValue != null) {
			sb.append(MINVALUE);
			sb.append(ModelXtdexConstants.EQU_MARK);
			sb.append(minValue);
			sb.append(ModelXtdexConstants.SPACE_MARK);
		}
		// maxValue
		BigDecimal maxValue = e.getMaxValue();
		if (maxValue != null) {
			sb.append(MAXVALUE);
			sb.append(ModelXtdexConstants.EQU_MARK);
			sb.append(maxValue);
			sb.append(ModelXtdexConstants.SPACE_MARK);
		}
		// step
		BigDecimal step = e.getStep();
		if (step != null) {
			sb.append(STEP);
			sb.append(ModelXtdexConstants.EQU_MARK);
			sb.append(step);
			sb.append(ModelXtdexConstants.SPACE_MARK);
		}
		return sb.toString().trim();
	}

	private SetpointXtdex() {}

}
