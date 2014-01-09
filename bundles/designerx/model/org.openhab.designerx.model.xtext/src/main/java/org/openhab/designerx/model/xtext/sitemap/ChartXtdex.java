package org.openhab.designerx.model.xtext.sitemap;

import org.openhab.designerx.model.sitemap.Chart;
import org.openhab.designerx.model.sitemap.impl.ChartBuilder;

/**
 * 
 * Syntax: 
 * Chart [item="<itemname>"] [icon="<iconname>"] [label="<labelname>"] [service="<service>"] [period=xxxx] [refresh=xxxx] [visibility=xxxx]
 * 
 * @author zhouwei
 * 
 */
public final class ChartXtdex {
	
	public static final String TARGET_TYPE_NAME = "Chart";

	private static final String PERIOD = "period";
	private static final String REFRESH = "refresh";
	private static final String SERVICE = "service";
	
	public static Chart fromXtext(String xtext) {
		xtext = PreProcessor.preProcess(xtext);
		if (!xtext.startsWith(TARGET_TYPE_NAME)) {
			throw new RuntimeException(xtext + " is NOT a " + TARGET_TYPE_NAME);
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
		sb.append(Constants.SPACE_MARK);
		sb.append(ElementXtdex.toXtext(e).trim());
		sb.append(Constants.SPACE_MARK);
		if (e.getPeriod() != null) {
			sb.append(PERIOD);
			sb.append(Constants.EQU_MARK);
			sb.append(e.getPeriod());
			sb.append(Constants.SPACE_MARK);
		}
		sb.append(REFRESH);
		sb.append(Constants.EQU_MARK);
		sb.append(e.getRefresh());
		sb.append(Constants.SPACE_MARK);
		if (e.getService() != null) {
			sb.append(SERVICE);
			sb.append(Constants.EQU_MARK);
			sb.append(e.getService());
		}
		
		return sb.toString().trim();
	}
	
	private ChartXtdex() {}
	
}
