package org.openhab.designerx.model.xtext.childless;

import java.util.List;
import java.util.Map;

import org.openhab.designerx.model.sitemap.Chart;
import org.openhab.designerx.model.sitemap.ColorArray;
import org.openhab.designerx.model.sitemap.VisibilityRule;
import org.openhab.designerx.model.sitemap.impl.ChartBuilder;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;

public final class ChartXtdex {
	
	public static final String TYPE = "Chart";

	public static final ImmutableSet<String> KEYWORDS = ImmutableSet.<String> builder()
			.addAll(Constants.COMMON_ELEMENT_KEYWORDS)
			.add(TYPE)
			.add("period=")
			.add("refresh=")
			.add("service=")
			.build();
	
	public static Chart fromXtext(String xtext) {
		xtext = xtext.replaceAll("\\{", "").trim();
		if (!xtext.startsWith(TYPE)) {
			throw new RuntimeException(xtext + " is NOT a " + TYPE);
		}
		Chart instance = new ChartBuilder().build();
		Map<String, String> map = Separator.separate(xtext, KEYWORDS);
		// set the parameters
		String icon = map.get("icon=");
		if (icon != null) {
			instance.setIcon(icon);
		}
		String item = map.get("item=");
		if (item != null) {
			instance.setItem(item);
		}
		String label = map.get("label=");
		if (label != null) {
			instance.setLabel(label);
		}
		String labelColor = map.get("labelColor=");
		if (labelColor != null) {
			List<ColorArray> list = Lists.newArrayList();
			ColorArray ca = ColorArrayXtdex.fromXtext(labelColor);
			list.add(ca);
			instance.addLabelColor(list);
		}
		String valueColor = map.get("valueColor=");
		if (valueColor != null) {
			List<ColorArray> list = Lists.newArrayList();
			ColorArray ca = ColorArrayXtdex.fromXtext(labelColor);
			list.add(ca);
			instance.addValueColor(list);
		}
		String visibility = map.get("visibility=");
		if (visibility != null) {
			List<VisibilityRule> list = Lists.newArrayList();
			VisibilityRule ca = VisibilityRuleXtdex.fromXtext(visibility);
			list.add(ca);
			instance.addVisibility(list);
		}
		String period = map.get("period=");
		if (period != null) {
			instance.setPeriod(period);
		}
		String refresh = map.get("refresh=");
		if (refresh != null) {
			int i = Integer.parseInt(refresh);
			instance.setRefresh(i);
		}
		String service = map.get("service=");
		if (service != null) {
			instance.setService(service);
		}
		return instance;
	}
	
	public static String toXtext(Chart e) {
		return null;
	}
	
	private ChartXtdex() {}
	
}
