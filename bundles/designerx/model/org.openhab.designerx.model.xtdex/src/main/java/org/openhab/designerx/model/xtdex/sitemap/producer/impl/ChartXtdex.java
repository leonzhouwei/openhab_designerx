package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import org.openhab.designerx.model.sitemap2.Chart;
import org.openhab.designerx.model.sitemap2.producer.ElementFactory;
import org.openhab.designerx.model.sitemap2.producer.impl.ElementFactoryImpl;

/**
 * 
 * Syntax: 
 * Chart [item="<itemname>"] [icon="<iconname>"] [label="<labelname>"] [service="<service>"] [period=xxxx] [refresh=xxxx] [visibility=xxxx]
 * 
 * @author zhouwei
 * 
 */
final class ChartXtdex {
	private static final String PERIOD = "period";
	private static final String REFRESH = "refresh";
	private static final String SERVICE = "service";
	private static final String MATCH_REGEX = "\\s*" + Chart.TYPE_NAME + "\\b.*";
	private static final ElementFactory factory = new ElementFactoryImpl();
	
	static Chart fromXtext(NonNestableElementXtextKeeper keeper) {
		String xtext = keeper.getXtext();
		if (!xtext.startsWith(Chart.TYPE_NAME)) {
			return null;
		}
		Chart instance = factory.createChart();
		// set the elementary parameters
		ElementXtdexImpl.fillWithoutChildren(instance, keeper);
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
	
	private ChartXtdex() {}
	
	static boolean isChart(String xtext) {
		boolean result = false;
		if (xtext.matches(MATCH_REGEX)) {
			result = true;
		}
		return result;
	}
	
}
