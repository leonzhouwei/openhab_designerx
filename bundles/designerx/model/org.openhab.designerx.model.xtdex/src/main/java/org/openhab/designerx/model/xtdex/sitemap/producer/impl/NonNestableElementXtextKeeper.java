package org.openhab.designerx.model.xtdex.sitemap.producer.impl;

import org.openhab.designerx.model.xtext.ModelXtextException;

public final class NonNestableElementXtextKeeper {
	
	private String xtext;
	
	public NonNestableElementXtextKeeper(String xtext) throws ModelXtextException {
		xtext = xtext.trim().replaceAll("\\}", "");
		int i = xtext.indexOf("{");
		if (i != -1) {
			xtext = xtext.substring(0, i).trim();
		}
		if (xtext.isEmpty()) {
			throw new ModelXtextException("no effective content in '" + xtext + "'");
		}
		this.xtext = xtext;
	}
	
	public String getXtext() {
		return xtext;
	}

}
