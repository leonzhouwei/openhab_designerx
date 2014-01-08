package org.openhab.designerx.model.sitemap.childlesselement.xtext;

import java.util.List;

import org.openhab.designerx.model.sitemap.Mapping;
import org.openhab.designerx.model.sitemap.impl.MappingBuilder;

import com.google.common.collect.Lists;

public final class MappingsXtdex {

	public static final String TARGET_TYPE_NAME = "mappings";

	public static List<Mapping> fromXtext(String xtext) {
		List<Mapping> mappings = Lists.newArrayList();
		xtext = PreProcessor.preProcess(xtext);
		if (!xtext.matches(".*" + TARGET_TYPE_NAME + "=\\[.*\\].*")) {
			return mappings;
		}
		// set the parameters
		String value = PropertyHandler.getValueBetweenBraces(xtext, TARGET_TYPE_NAME);
		value = value.trim();
		String[] split = value.trim().split(Constants.COMMA_MARK);
		for (String s : split) {
			String[] a = s.split(Constants.EQU_MARK);
			Mapping instance = new MappingBuilder().build();
			instance.setCmd(a[0].trim());
			instance.setLabel(a[1].trim());
			mappings.add(instance);
		}
		return mappings;
	}
	
	public static String toXtext(List<Mapping> mappings) {
		StringBuilder sb = new StringBuilder();
		sb.append(TARGET_TYPE_NAME);
		sb.append(Constants.EQU_MARK);
		sb.append("[");
		for (Mapping e : mappings) {
			String cmd = e.getCmd();
			String label = e.getLabel();
			sb.append(cmd);
			sb.append(Constants.EQU_MARK);
			sb.append(label);
			sb.append(Constants.COMMA_MARK);
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("]");
		return sb.toString().trim();
	}
	
	private MappingsXtdex() {}
	
}
