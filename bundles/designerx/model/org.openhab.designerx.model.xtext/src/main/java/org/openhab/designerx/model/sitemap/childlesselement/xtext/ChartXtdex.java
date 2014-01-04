package org.openhab.designerx.model.sitemap.childlesselement.xtext;

import org.openhab.designerx.model.sitemap.Chart;
import org.openhab.designerx.model.sitemap.Element;
import org.openhab.designerx.model.sitemap.impl.ChartBuilder;

public final class ChartXtdex {
	
	public static final String TYPE = "Chart";

	private static final String PERIOD = "period";
	private static final String REFRESH = "refresh";
	private static final String SERVICE = "service";
	
	public static Chart fromXtext(String xtext) {
		xtext = PreProcessor.preProcess(xtext);
		if (!xtext.startsWith(TYPE)) {
			throw new RuntimeException(xtext + " is NOT a " + TYPE);
		}
		Chart instance = new ChartBuilder().build();
		// set the elementary parameters
		Element e = ElementXtdex.fromXtext(xtext);
		instance.setIcon(e.getIcon());
		instance.setItem(e.getItem());
		instance.setLabel(e.getLabel());
		instance.addLabelColor(e.getLabelColor());
		instance.addValueColor(e.getValueColor());
		instance.addVisibility(e.getVisibility());
		// set the specific parameters
		String period = PropertyHandler.getValueWithoutStartEndMarks(xtext, PERIOD);
		instance.setPeriod(period);
		String refresh = PropertyHandler.getValueWithoutStartEndMarks(xtext, REFRESH);
		int i = Integer.parseInt(refresh);
		instance.setRefresh(i);
		String service = PropertyHandler.getValueWithoutStartEndMarks(xtext, SERVICE);
		instance.setService(service);
		return instance;
	}
	
	public static String toXtext(Chart e) {
		StringBuilder sb = new StringBuilder();
		sb.append(TYPE);
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
