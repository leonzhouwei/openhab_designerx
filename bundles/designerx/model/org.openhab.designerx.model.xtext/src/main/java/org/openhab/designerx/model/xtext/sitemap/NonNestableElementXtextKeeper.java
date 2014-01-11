package org.openhab.designerx.model.xtext.sitemap;

public final class NonNestableElementXtextKeeper {
	
	private String xtext;
	
	public NonNestableElementXtextKeeper(String xtext) {
		xtext = xtext.trim().replaceAll("\\}", "");
		int i = xtext.indexOf("{");
		if (i != -1) {
			xtext = xtext.substring(0, i).trim();
		}
		this.xtext = xtext;
	}
	
	public String getXtext() {
		return xtext;
	}

}
