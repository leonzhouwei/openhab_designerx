package org.openhab.designerx.model.xtext.items.impl;

import org.openhab.designerx.model.xtext.ModelXtextException;

final class ItemXtextKeeper {
	private String xtext;
	
	public ItemXtextKeeper(String xtext) throws ModelXtextException {
		xtext = xtext.trim();
		if (xtext.isEmpty()) {
			throw new ModelXtextException("could not find any effective content in the input");
		}
		this.xtext = xtext;
	}
	
	String getXtext() {
		return xtext;
	}

}
