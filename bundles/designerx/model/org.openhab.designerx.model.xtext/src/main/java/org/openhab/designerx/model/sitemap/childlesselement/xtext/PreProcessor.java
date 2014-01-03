package org.openhab.designerx.model.sitemap.childlesselement.xtext;

final class PreProcessor {
	
	public static String preProcess(String xtext) {
		xtext = xtext.trim().replaceAll("\\}", "");
		int i = xtext.indexOf("{");
		if (i != -1) {
			xtext = xtext.substring(0, i).trim();
		}
		return xtext;
	}
	
	private PreProcessor() {}
	
}
