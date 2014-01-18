package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import java.util.List;

import org.openhab.designerx.model.sitemap.Element;
import org.openhab.designerx.model.sitemap.Sitemap;
import org.openhab.designerx.model.sitemap.producer.SitemapBuilder;
import org.openhab.designerx.model.sitemap.producer.impl.SitemapBuilderImpl;
import org.openhab.designerx.model.xtdex.ModelXtdexConstants;
import org.openhab.designerx.model.xtdex.ModelXtdexException;
import org.openhab.designerx.model.xtdex.sitemap.ElementXtdex;
import org.openhab.designerx.model.xtdex.sitemap.SitemapXtdex;
import org.openhab.designerx.model.xtdex.sitemap.producer.SitemapXtdexBuilder;

import com.google.common.collect.ImmutableList;

public final class SitemapXtdexBuilderImpl implements SitemapXtdexBuilder {

	@Override
	public SitemapXtdex build() {
		return new SitemapXtdexImpl();
	}
	
	private class SitemapXtdexImpl implements SitemapXtdex {
		private static final String MATCH_REGEX = "\\s*sitemap\\b.*";
		private static final String DEFAULT_INDENTATION = "    ";
		
		private SitemapBuilder builder = new SitemapBuilderImpl();
		private ElementXtdex xtdex = new ElementXtdexBuilderImpl().build();
		
		@Override
		public Sitemap parse(String xtext) throws ModelXtdexException {
			SitemapXtextKeeper keeper = new SitemapXtextKeeper(xtext);
			ImmutableList<String> il = keeper.getXtext();
			return parse(il);
		}

		@Override
		public String toXtext(Sitemap sitemap) {
			StringBuilder sb = new StringBuilder();
			sb.append(ModelXtdexConstants.SITEMAP);
			String name = sitemap.getName();
			if (name != null) {
				sb.append(ModelXtdexConstants.SPACE_MARK);
				sb.append(name);
			}
			String label = sitemap.getLabel();
			if (label != null) {
				sb.append(ModelXtdexConstants.SPACE_MARK);
				sb.append(ModelXtdexConstants.LABEL);
				sb.append(ModelXtdexConstants.EQU_MARK);
				sb.append(ModelXtdexConstants.DOUBLE_QUOTE_MARK);
				sb.append(label);
				sb.append(ModelXtdexConstants.DOUBLE_QUOTE_MARK);
			}
			String icon = sitemap.getIcon();
			if (icon != null) {
				sb.append(ModelXtdexConstants.SPACE_MARK);
				sb.append(ModelXtdexConstants.ICON);
				sb.append(ModelXtdexConstants.EQU_MARK);
				sb.append(ModelXtdexConstants.DOUBLE_QUOTE_MARK);
				sb.append(icon);
				sb.append(ModelXtdexConstants.DOUBLE_QUOTE_MARK);
			}
			List<Element> children = sitemap.getChildren();
			if (!children.isEmpty()) {
				sb.append(ModelXtdexConstants.SPACE_MARK);
				sb.append(ModelXtdexConstants.OPEN_CURLY_BRACE_MARK);
				sb.append(ModelXtdexConstants.LINE_SEPARATOR);
				for (Element child : children) {
					if (child.canHaveChildren()) {
						String temp = xtdex.toXtext(child, DEFAULT_INDENTATION);
						sb.append(temp);
						sb.append(ModelXtdexConstants.LINE_SEPARATOR);
					} else {
						String temp = xtdex.toXtext(child);
						sb.append(DEFAULT_INDENTATION);
						sb.append(temp);
						sb.append(ModelXtdexConstants.LINE_SEPARATOR);
					}
				}
				sb.append(ModelXtdexConstants.CLOSE_CURLY_BRACE_MARK);
			}
			return sb.toString();
		}
		
		private boolean isSitemap(String xtext) {
			if (xtext.matches(MATCH_REGEX)) {
				return true;
			}
			return false;
		}
		
		public Sitemap parse(List<String> xtext) throws ModelXtdexException {
			SitemapXtextKeeper keeper = new SitemapXtextKeeper(xtext);
			ImmutableList<String> il = keeper.getXtext();
			return parse(il);
		}
		
		private Sitemap parse(ImmutableList<String> il) throws ModelXtdexException {
			if (!isSitemap(il.get(0))) {
				throw new ModelXtdexException(il.get(0) + " is NOT a sitemap");
			}
			final String first = il.get(0);
			String[] split = first.split("\\s");
			if (split.length < 2) {
				throw new ModelXtdexException(first + " is NOT a sitemap");
			}
			String name = split[1].trim();
			if (name.startsWith("label=") || name.startsWith("icon=")) {
				throw new ModelXtdexException("sitemap name NOT found in '" + first + "'");
			}
			//
			Sitemap instance = builder.build();
			instance.setName(name);
			String label = PropertyHandler.getValueBetweenDoubleQuotes(first, ModelXtdexConstants.LABEL);
			if (label != null && !label.trim().isEmpty()) {
				instance.setLabel(label);
			}
			String icon = PropertyHandler.getValueBetweenDoubleQuotes(first, ModelXtdexConstants.ICON);
			if (icon != null && !icon.trim().isEmpty()) {
				instance.setIcon(icon);
			}
			//
			final int size = il.size();
			for (int i = 1; i >= 1 && i < size - 1;) {
				String s = new ChildlessElementXtextKeeper(il.get(i)).getXtext();
				if (xtdex.isChildlessElement(s)) {
					Element e = xtdex.parse(s);
					i += 1;
					instance.appendChild(e);
				} else if (xtdex.isChildfulElement(s)) {
					int end = ChildfulElementXtdex.endIndexOf(il, i);
					ImmutableList<String> subList = il.subList(i, end + 1);
					Element e = xtdex.parseChildfulElement(subList);
					instance.appendChild(e);
					i = end + 1;
				} else {
					i += 1;
				}
			}
			return instance;
		}
		
	}

}
