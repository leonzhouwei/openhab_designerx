package org.openhab.designerx.model.sitemap.childlesselement.xtext;

final class PropertyHandler {
	
	/**
	 * get the value of a property in the form of "item=anItem"
	 * 
	 * @param xtext
	 * @param name
	 * @return
	 */
	public static String getValue(String xtext, String name) {
		if (!xtext.matches(".*" + name + "\\s*=.*")) {
			return null;
		}
		String[] split = xtext.split("\\b" + name + "\\s*=");
		String post = split[1].trim();
		split = post.split("\\s");
		String value = split[0].trim();
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
	 * @param open
	 * @param close
	 * @return
	 */
	public static String getValue(String xtext, String name, String open, String close) {
		if (!xtext.matches(".*" + name + "\\s*=\\s*" + open + "\\s*" + ".*" + "\\s*" + close + ".*")) {
			return null;
		}
		String[] split = xtext.split("\\b" + name + "\\s*=");
		String post = split[1].trim();
		int i = post.indexOf(open);
		int j = post.indexOf(close, i + open.length());
		String value = post.substring(i, j + 1);
		return value;
	}
	
	private PropertyHandler() {}
	
}
