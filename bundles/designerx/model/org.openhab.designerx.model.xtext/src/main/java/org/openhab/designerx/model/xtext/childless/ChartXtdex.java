package org.openhab.designerx.model.xtext.childless;

import org.openhab.designerx.model.sitemap.Chart;
import org.openhab.designerx.model.sitemap.Element;
import org.openhab.designerx.model.sitemap.impl.ChartBuilder;

public final class ChartXtdex {
	
	public static final String TYPE = "Chart";

	private static final String PERIOD_EQU = "period=";
	private static final String REFRESH_EQU = "refresh=";
	private static final String SERVICE_EQU = "service=";
	
	public static Chart fromXtext(String xtext) {
		xtext = xtext.replaceAll("\\{", "").trim();
		if (!xtext.startsWith(TYPE)) {
			throw new RuntimeException(xtext + " is NOT a " + TYPE);
		}
		Chart instance = new ChartBuilder().build();
		// set the elementary parameters
		Element e = ElementXdtex.fromXtext(xtext);
		instance.setIcon(e.getIcon());
		instance.setItem(e.getItem());
		instance.setLabel(e.getLabel());
		instance.addLabelColor(e.getLabelColor());
		instance.addValueColor(e.getValueColor());
		instance.addVisibility(e.getVisibility());
		// set the specific parameters
		String period = Extractor.extract(xtext, PERIOD_EQU, "\\b" + PERIOD_EQU + "\\w*");
		instance.setPeriod(period);
		String refresh = Extractor.extract(xtext, REFRESH_EQU, "\\b" + REFRESH_EQU + "\\w*");
		int i = Integer.parseInt(refresh);
		instance.setRefresh(i);
		String service = Extractor.extract(xtext, SERVICE_EQU, "\\b" + SERVICE_EQU + "\\w*");
		instance.setService(service);
		return instance;
	}
	
	public static String toXtext(Chart e) {
		StringBuilder sb = new StringBuilder();
		sb.append(TYPE);
		sb.append(Constants.SPACE);
		sb.append(ElementXdtex.toXtext(e).trim());
		sb.append(Constants.SPACE);
		if (e.getPeriod() != null) {
			sb.append(PERIOD_EQU);
			sb.append(e.getPeriod());
			sb.append(Constants.SPACE);
		}
		sb.append(REFRESH_EQU);
		sb.append(e.getRefresh());
		sb.append(Constants.SPACE);
		if (e.getService() != null) {
			sb.append(SERVICE_EQU);
			sb.append(e.getService());
		}
		
		return sb.toString().trim();
	}
	
	private ChartXtdex() {}
	
}
