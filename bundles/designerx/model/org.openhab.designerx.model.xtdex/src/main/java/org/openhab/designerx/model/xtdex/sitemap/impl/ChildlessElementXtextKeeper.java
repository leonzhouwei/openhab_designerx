package org.openhab.designerx.model.xtdex.sitemap.impl;

import org.openhab.designerx.model.xtdex.ModelXtdexException;

final class ChildlessElementXtextKeeper {
	private String xtext;
	
	ChildlessElementXtextKeeper(String xtext) throws ModelXtdexException {
		xtext = xtext.trim().replaceAll("\\}", "");
		int i = xtext.indexOf("{");
		if (i != -1) {
			xtext = xtext.substring(0, i).trim();
		}
		if (xtext.isEmpty()) {
			throw new ModelXtdexException("no effective content in '" + xtext + "'");
		}
		this.xtext = xtext;
	}
	
	String getXtext() {
		return xtext;
	}

}
