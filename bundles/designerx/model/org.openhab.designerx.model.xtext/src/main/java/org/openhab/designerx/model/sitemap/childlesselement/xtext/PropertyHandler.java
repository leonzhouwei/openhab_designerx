package org.openhab.designerx.model.sitemap.childlesselement.xtext;

final class PropertyHandler {
	
	/**
	 * get the value of a property in the form of "item=anItem"
	 * 
	 * @param xtext
	 * @param name
	 * @return
	 */
	public static String getValueWithoutStartEndMarks(String xtext, String name) {
		if (!xtext.matches(".*" + name + "\\s*=.*")) {
			return null;
		}
		String[] split = xtext.split("\\b" + name + "\\s*=");
		String post = split[1].trim();
		split = post.split("\\s");
		String value = split[0].trim();
		return value;
	}
	
	public static String getValueStartingEndingWithBraces(String xtext, String name) {
		if (!xtext.matches(".*" + name + "\\s*=\\s*\\[.*\\].*")) {
			return null;
		}
		String[] split = xtext.split("\\b" + name + "\\s*=");
		String post = split[1].trim();
		int i = post.indexOf(Constants.OPEN_BRACE_MARK);
		int j = post.indexOf(Constants.CLOSE_BRACE_MARK, i + Constants.OPEN_BRACE_MARK.length());
		String value = post.substring(i, j + 1);
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
	public static String getValueStartingEndingWithDoubleQuotes(String xtext, String name) {
		if (!xtext.matches(".*" + name + "\\s*=\\s*" + Constants.DOUBLE_QUOTE_MARK + ".*" + Constants.DOUBLE_QUOTE_MARK + ".*")) {
			return null;
		}
		String[] split = xtext.split("\\b" + name + "\\s*=");
		String post = split[1].trim();
		int i = post.indexOf(Constants.DOUBLE_QUOTE_MARK);
		int j = post.indexOf(Constants.DOUBLE_QUOTE_MARK, i + Constants.DOUBLE_QUOTE_MARK.length());
		String value = post.substring(i, j + 1);
		return value;
	}
	
	private PropertyHandler() {}
	
}
