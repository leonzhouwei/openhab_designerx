package org.openhab.designerx.model.sitemap.childlesselement.xtext;

import org.openhab.designerx.model.sitemap.Mapping;
import org.openhab.designerx.model.sitemap.impl.MappingBuilder;

public final class MappingXtdex {

	public static final String TYPE = "mappings";

	public static Mapping fromXtext(String xtext) {
		xtext = PreProcessor.preProcess(xtext);
		if (!xtext.startsWith(TYPE)) {
			throw new RuntimeException(xtext + " is NOT a " + TYPE);
		}
		// set the parameters
		Mapping instance = new MappingBuilder().build();
		String cmd = Extractor.extract(xtext, Constants.CMD_EQU, "\\b" + Constants.CMD_EQU + "\\w*");
		instance.setCmd(cmd);
		String label = Extractor.extract(xtext, Constants.LABEL_EQU, "\\b" + Constants.LABEL_EQU + "\\w*");
		instance.setLabel(label);
		return instance;
	}
	
	public static String toXtext(Mapping e) {
		return null;
	}
	
	private MappingXtdex() {}
	
}
