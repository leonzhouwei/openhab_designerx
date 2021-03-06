package org.openhab.designerx.model.xtdex.sitemap.impl;

import org.openhab.designerx.model.sitemap.Chart;
import org.openhab.designerx.model.sitemap.Element;
import org.openhab.designerx.model.sitemap.SitemapElementFactory;
import org.openhab.designerx.model.sitemap.impl.SitemapElementFactoryImpl;
import org.openhab.designerx.model.xtdex.ModelXtdexConstants;

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
	
	private static final SitemapElementFactory factory = new SitemapElementFactoryImpl();
	
	static boolean isChart(ChildlessElementXtextKeeper keeper) {
		boolean result = false;
		String xtext = keeper.getXtext();
		if (xtext.matches(MATCH_REGEX)) {
			result = true;
		}
		return result;
	}

	static <T extends Element> boolean isChart(T e) {
		boolean result = false;
		if (e instanceof Chart) {
			result = true;
		}
		return result;
	}

	static Chart parseIgnoringChildren(ChildlessElementXtextKeeper keeper) {
		String xtext = keeper.getXtext();
		if (!xtext.matches(MATCH_REGEX)) {
			return null;
		}
		Chart instance = factory.createChart();
		// set the elementary parameters
		ElementFiller.fillWithoutChildren(instance, keeper);
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

	static String toXtextIgnoringChildren(Chart e) {
		StringBuilder sb = new StringBuilder();
		// convert the elementary parameters
		sb.append(ElementXtextualizer.toXtextIgnoringChildren(e));
		sb.append(ModelXtdexConstants.SPACE_MARK);
		// convert the specific parameters below
		// period
		String period = e.getPeriod();
		if (period != null) {
			sb.append(PERIOD);
			sb.append(ModelXtdexConstants.EQU_MARK);
			sb.append(period);
			sb.append(ModelXtdexConstants.SPACE_MARK);
		}
		// refresh
		sb.append(REFRESH);
		sb.append(ModelXtdexConstants.EQU_MARK);
		sb.append(e.getRefresh());
		sb.append(ModelXtdexConstants.SPACE_MARK);
		// service
		String service = e.getService();
		if (service != null) {
			sb.append(SERVICE);
			sb.append(ModelXtdexConstants.EQU_MARK);
			sb.append(service);
			sb.append(ModelXtdexConstants.SPACE_MARK);
		}
		return sb.toString().trim();
	}

	private ChartXtdex() {}

}
