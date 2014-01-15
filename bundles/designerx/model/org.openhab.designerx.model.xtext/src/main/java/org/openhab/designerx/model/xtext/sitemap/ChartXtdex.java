package org.openhab.designerx.model.xtext.sitemap;

import org.openhab.designerx.model.sitemap.Chart;
import org.openhab.designerx.model.sitemap.impl.ChartBuilder;
import org.openhab.designerx.model.xtext.XtextConstants;

/**
 * 
 * Syntax: 
 * Chart [item="<itemname>"] [icon="<iconname>"] [label="<labelname>"] [service="<service>"] [period=xxxx] [refresh=xxxx] [visibility=xxxx]
 * 
 * @author zhouwei
 * 
 */
public final class ChartXtdex {
	
	static final String TARGET_TYPE_NAME = "Chart";

	private static final String PERIOD = "period";
	private static final String REFRESH = "refresh";
	private static final String SERVICE = "service";
	private static final String MATCH_REGEX = "\\s*" + TARGET_TYPE_NAME + "\\b.*";
	
	public static Chart fromXtext(NonNestableElementXtextKeeper keeper) {
		return fromXtext(keeper.getXtext());
	}
	
	static Chart fromXtext(String xtext) {
		xtext = PreProcessor.preProcess(xtext);
		if (!xtext.startsWith(TARGET_TYPE_NAME)) {
			return null;
		}
		Chart instance = new ChartBuilder().build();
		// set the elementary parameters
		ElementXtdex.set(instance, xtext);
		// set the specific parameters
		String period = PropertyHandler.getValue(xtext, PERIOD);
		instance.setPeriod(period);
		String refresh = PropertyHandler.getValue(xtext, REFRESH);
		if (refresh != null) {
			int i = Integer.parseInt(refresh);
			instance.setRefresh(i);
		}
		String service = PropertyHandler.getValue(xtext, SERVICE);
		instance.setService(service);
		return instance;
	}
	
	public static String toXtext(Chart e) {
		StringBuilder sb = new StringBuilder();
		sb.append(TARGET_TYPE_NAME);
		sb.append(XtextConstants.SPACE_MARK);
		// element
		String elemStr = ElementXtdex.toXtext(e);
		if (!elemStr.isEmpty()) {
			sb.append(elemStr);	
			sb.append(XtextConstants.SPACE_MARK);
		}
		// period
		String period = e.getPeriod();
		if (period != null) {
			sb.append(PERIOD);
			sb.append(XtextConstants.EQU_MARK);
			sb.append(period);
			sb.append(XtextConstants.SPACE_MARK);
		}
		// refresh
		sb.append(REFRESH);
		sb.append(XtextConstants.EQU_MARK);
		sb.append(e.getRefresh());
		sb.append(XtextConstants.SPACE_MARK);
		// service
		String service = e.getService();
		if (service != null) {
			sb.append(SERVICE);
			sb.append(XtextConstants.EQU_MARK);
			sb.append(service);
			sb.append(XtextConstants.SPACE_MARK);
		}
		return sb.toString().trim();
	}
	
	private ChartXtdex() {}
	
	public static boolean isChart(String xtext) {
		boolean result = false;
		if (xtext.matches(MATCH_REGEX)) {
			result = true;
		}
		return result;
	}
	
}
