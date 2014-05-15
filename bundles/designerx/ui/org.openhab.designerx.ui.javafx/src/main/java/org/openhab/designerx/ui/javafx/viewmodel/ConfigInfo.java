package org.openhab.designerx.ui.javafx.viewmodel;

public final class ConfigInfo {
	public enum Type {
		NONE, ITEM_RESOURCE, SITEMAP
	}

	private Type type;
	private String name;
	
	public ConfigInfo(Type type, String name) {
		this.type = type;
		this.name = name;
	}
	
	public boolean mapItemResource() {
		return type == Type.ITEM_RESOURCE;
	}
	
	public boolean mapSitemap() {
		return type == Type.SITEMAP;
	}
	
	public String toString() {
		return name;
	}
	
	public String getName() {
		return name;
	}

}
