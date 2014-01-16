package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import java.util.List;

import org.openhab.designerx.model.sitemap.Element;
import org.openhab.designerx.model.sitemap.NestableElement;
import org.openhab.designerx.model.sitemap.NonNestableElement;
import org.openhab.designerx.model.sitemap.Sitemap;
import org.openhab.designerx.model.sitemap.impl.SitemapBuilder;
import org.openhab.designerx.model.xtext.XtextConstants;
import org.openhab.designerx.model.xtext.ModelXtextException;

import com.google.common.collect.ImmutableList;

public final class SitemapXtdex {
	
	private static final String MATCH_REGEX = "\\s*sitemap\\b.*";
	private static final String DEFAULT_INDENTATION = "    ";
	
	public static Sitemap fromXtext(SitemapXtextKeeper keeper) throws ModelXtextException {
		ImmutableList<String> il = keeper.getXtext();
		if (!isSitemap(il.get(0))) {
			throw new ModelXtextException(il.get(0) + " is NOT a sitemap");
		}
		final String first = il.get(0);
		String[] split = first.split("\\s");
		if (split.length < 2) {
			throw new ModelXtextException(first + " is NOT a sitemap");
		}
		String name = split[1].trim();
		if (name.startsWith("label=") || name.startsWith("icon=")) {
			throw new ModelXtextException("sitemap name NOT found in '" + first + "'");
		}
		
		Sitemap instance = new SitemapBuilder().build();
		instance.setName(name);
		String label = PropertyHandler.getValueBetweenDoubleQuotes(first, XtextConstants.LABEL);
		if (label != null && !label.trim().isEmpty()) {
			instance.setLabel(label);
		}
		String icon = PropertyHandler.getValueBetweenDoubleQuotes(first, XtextConstants.ICON);
		if (icon != null && !icon.trim().isEmpty()) {
			instance.setIcon(icon);
		}
		
		final int size = il.size();
		for (int i = 1; i > 0 && i < size;) {
			String s = il.get(i);
			if (NonNestableElementXtdex.isNonNestableElement(s)) {
				NonNestableElement e = NonNestableElementXtdex.fromXtext(s);
				i += 1;
				instance.appendChild(e);
			} else if (NestableElementXtdex.isNestableElement(s)) {
				int end = NestableElementXtdex.endIndexOf(il, i);
				ImmutableList<String> subList = il.subList(i, end + 1);
				NestableElement e = NestableElementXtdex.fromXtext(subList);
				instance.appendChild(e);
				i = end + 1;
			} else {
				i += 1;
			}
		}
		return instance;
	}
	
	static boolean isSitemap(String xtext) {
		if (xtext.matches(MATCH_REGEX)) {
			return true;
		}
		return false;
	}
	
	private SitemapXtdex() {}
	
	public static String toXtext(Sitemap sitemap) {
		StringBuilder sb = new StringBuilder();
		sb.append(XtextConstants.SITEMAP);
		String name = sitemap.getName();
		if (name != null) {
			sb.append(XtextConstants.SPACE_MARK);
			sb.append(name);
		}
		String label = sitemap.getLabel();
		if (label != null) {
			sb.append(XtextConstants.SPACE_MARK);
			sb.append(XtextConstants.LABEL);
			sb.append(XtextConstants.EQU_MARK);
			sb.append(XtextConstants.DOUBLE_QUOTE_MARK);
			sb.append(label);
			sb.append(XtextConstants.DOUBLE_QUOTE_MARK);
		}
		String icon = sitemap.getIcon();
		if (icon != null) {
			sb.append(XtextConstants.SPACE_MARK);
			sb.append(XtextConstants.ICON);
			sb.append(XtextConstants.EQU_MARK);
			sb.append(XtextConstants.DOUBLE_QUOTE_MARK);
			sb.append(icon);
			sb.append(XtextConstants.DOUBLE_QUOTE_MARK);
		}
		List<Element> children = sitemap.getChildren();
		if (!children.isEmpty()) {
			sb.append(XtextConstants.SPACE_MARK);
			sb.append(XtextConstants.OPEN_BRACE_MARK);
			sb.append(XtextConstants.LINE_SEPARATOR);
			for (Element child : children) {
				if (child instanceof NonNestableElement) {
					String temp = NonNestableElementXtdex.toXtext((NonNestableElement) child);
					sb.append(DEFAULT_INDENTATION);
					sb.append(temp);
					sb.append(XtextConstants.LINE_SEPARATOR);
				} else if (child instanceof NestableElement) {
					String temp = NestableElementXtdex.toXtext((NestableElement) child, DEFAULT_INDENTATION);
					sb.append(temp);
					sb.append(XtextConstants.LINE_SEPARATOR);
				}
			}
			sb.append(XtextConstants.CLOSE_BRACE_MARK);
		}
		return sb.toString();
	}

}
