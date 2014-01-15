package org.openhab.designerx.model.xtext.sitemap;

import org.openhab.designerx.model.xtext.XtextConstants;

final class PropertyHandler {
	
	/**
	 * get the value of a property in the form of "item=anItem"
	 * 
	 * @param xtext
	 * @param name
	 * @return
	 */
	static String getValue(String xtext, String name) {
		if (!xtext.matches(".*" + name + "\\s*=.*")) {
			return null;
		}
		String[] split = xtext.split("\\b" + name + "\\s*=");
		String post = split[1].trim();
		split = post.split("\\s");
		String value = split[0].trim();
		return value;
	}
	
	static String getValueBetweenBraces(String xtext, String name) {
		if (!xtext.matches(".*" + name + "\\s*=\\s*\\[.*\\].*")) {
			return null;
		}
		String[] split = xtext.split("\\b" + name + "\\s*=");
		String post = split[1].trim();
		int i = post.indexOf(XtextConstants.OPEN_BRACE_MARK);
		int j = post.indexOf(XtextConstants.CLOSE_BRACE_MARK, i + XtextConstants.OPEN_BRACE_MARK.length());
		String value = post.substring(i + 1, j).trim();
		return value;
	}
	
	/**
	 * get the value of the property in the form of "label=<open>content<close>]"
	 * e.g. 
	 * input: "mappings=[0="Hour"]", "mappings", "[", "]"
	 * output: "[0="Hour"]"
	 * 
	 * @param xtext
	 * @param name
	 * @return
	 */
	static String getValueBetweenDoubleQuotes(String xtext, String name) {
		if (!xtext.matches(".*" + name + "\\s*=\\s*" + XtextConstants.DOUBLE_QUOTE_MARK + ".*" + XtextConstants.DOUBLE_QUOTE_MARK + ".*")) {
			return null;
		}
		String[] split = xtext.split("\\b" + name + "\\s*=");
		String post = split[1].trim();
		int i = post.indexOf(XtextConstants.DOUBLE_QUOTE_MARK);
		int j = post.indexOf(XtextConstants.DOUBLE_QUOTE_MARK, i + XtextConstants.DOUBLE_QUOTE_MARK.length());
		String value = post.substring(i + 1, j).trim();
		return value;
	}
	
	private PropertyHandler() {}
	
}
