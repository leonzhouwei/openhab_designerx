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
		if (!xtext.contains(name)) {
			return null;
		}
		int i = xtext.indexOf(name);
		xtext = xtext.substring(i + name.length()).trim();
		if (!xtext.startsWith("=")) {
			return null;
		}
		String[] split = xtext.substring(1).split("\\s");
		return split[0];
	}
	
	/**
	 * get the value of the property in the form of "label=<open>content<close>]"
	 * 
	 * @param xtext
	 * @param name
	 * @param open
	 * @param close
	 * @return
	 */
	public static String getValue(String xtext, String name, String open, String close) {
		if (!xtext.contains(name)) {
			return null;
		}
		int i = xtext.indexOf(name);
		xtext = xtext.substring(i + name.length()).trim();
		if (!xtext.startsWith("=")) {
			return null;
		}
		i = xtext.indexOf(open);
		int j = xtext.indexOf(close, i + open.length());
		String property = xtext.substring(i, j + 1);
		return property;
	}
	
	public static String getValue(String property) {
		String value = null;
		String[] split = property.split(Constants.EQU_MARK);
		if (split.length == 2) {
			value = split[1].trim();
		}
		return value;
	}
	
	private PropertyHandler() {}
	
}
