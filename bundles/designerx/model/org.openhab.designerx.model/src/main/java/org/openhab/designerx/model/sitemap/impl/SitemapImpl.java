package org.openhab.designerx.model.sitemap.impl;

import java.util.List;

import org.openhab.designerx.model.sitemap.Element;
import org.openhab.designerx.model.sitemap.Sitemap;

import com.google.common.collect.Lists;

final class SitemapImpl implements Sitemap {

	private String name;
	private String label;
	private String icon;
	private List<Element> children = Lists.newArrayList();
	
	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Override
	public String getIcon() {
		return icon;
	}

	@Override
	public List<Element> getChildren() {
		return children;
	}

	@Override
	public String toXtext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equalsLogically(Sitemap another) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void appendChild(Element e) {
		children.add(e);
	}

}
