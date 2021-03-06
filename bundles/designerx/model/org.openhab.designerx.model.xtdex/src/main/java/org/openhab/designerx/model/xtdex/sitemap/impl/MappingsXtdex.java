package org.openhab.designerx.model.xtdex.sitemap.impl;

import java.util.List;

import org.openhab.designerx.model.sitemap.Mapping;
import org.openhab.designerx.model.sitemap.SitemapElementFactory;
import org.openhab.designerx.model.sitemap.impl.SitemapElementFactoryImpl;
import org.openhab.designerx.model.xtdex.ModelXtdexConstants;

import com.google.common.collect.Lists;

/**
 * 
 * mappings="<mapping definition>"
 * 
 * @author zhouwei
 *
 */
public final class MappingsXtdex {
	static final String TARGET_TYPE_NAME = "mappings";
	
	private static final SitemapElementFactory factory = new SitemapElementFactoryImpl();
	
	static List<Mapping> fromXtext(String xtext) {
		List<Mapping> mappings = Lists.newArrayList();
		xtext = xtext.trim();
		if (!xtext.matches(".*" + TARGET_TYPE_NAME + "=\\[.*\\].*")) {
			return mappings;
		}
		// set the parameters
		String value = PropertyHandler.getValueBetweenSquareBrackets(xtext, TARGET_TYPE_NAME);
		value = value.trim();
		String[] split = value.trim().split(ModelXtdexConstants.COMMA_MARK);
		for (String s : split) {
			String[] a = s.split(ModelXtdexConstants.EQU_MARK);
			Mapping instance = factory.createMapping();
			instance.setCmd(a[0].trim());
			instance.setLabel(a[1].trim());
			mappings.add(instance);
		}
		return mappings;
	}
	
	static String toXtext(List<Mapping> mappings) {
		StringBuilder sb = new StringBuilder();
		sb.append(TARGET_TYPE_NAME);
		sb.append(ModelXtdexConstants.EQU_MARK);
		sb.append("[");
		int count = 0;
		for (Mapping e : mappings) {
			String cmd = e.getCmd();
			String label = e.getLabel();
			sb.append(cmd);
			sb.append(ModelXtdexConstants.EQU_MARK);
			sb.append(label);
			sb.append(ModelXtdexConstants.COMMA_MARK);
			count += 1;
		}
		if (count > 0) {
			sb.deleteCharAt(sb.length() - 1);
		}
		sb.append("]");
		return sb.toString();
	}
	
	private MappingsXtdex() {}
	
}
